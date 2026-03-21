package com.motorola.studyandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.motorola.studyandroid.lessons.shared.LessonCatalog
import com.motorola.studyandroid.navigation.StudyAndroidNavGraph
import com.motorola.studyandroid.ui.theme.StudyAndroidTheme

@OptIn(androidx.compose.material3.ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            StudyAndroidTheme {
                // 1. 创建 NavController: 它是导航的大脑，负责控制页面跳转
                val navController = rememberNavController()
                val currentBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = currentBackStackEntry?.destination?.route ?: LessonCatalog.menuRoute
                val currentTitle = LessonCatalog.findByRoute(currentRoute)?.title ?: LessonCatalog.appTitle

                val navigateToRoute: (String) -> Unit = { targetScreen ->
                    navController.navigate(targetScreen) {
                        launchSingleTop = true
                        if (targetScreen == LessonCatalog.menuRoute) {
                            popUpTo(LessonCatalog.menuRoute) {
                                inclusive = false
                            }
                        }
                    }
                }

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        TopAppBar(
                            title = { Text(currentTitle) },
                            navigationIcon = {
                                if (currentRoute != LessonCatalog.menuRoute && navController.previousBackStackEntry != null) {
                                    TextButton(onClick = { navController.popBackStack() }) {
                                        Text("返回")
                                    }
                                }
                            },
                            colors = TopAppBarDefaults.topAppBarColors(
                                containerColor = MaterialTheme.colorScheme.primaryContainer,
                                titleContentColor = MaterialTheme.colorScheme.primary
                            )
                        )
                    }
                ) { innerPadding ->
                    StudyAndroidNavGraph(
                        navController = navController,
                        modifier = Modifier.padding(innerPadding),
                        onNavigate = navigateToRoute
                    )
                }
            }
        }
    }
}
