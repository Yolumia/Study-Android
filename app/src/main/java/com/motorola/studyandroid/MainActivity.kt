package com.motorola.studyandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.motorola.studyandroid.lessons.Lesson0_GettingStarted
import com.motorola.studyandroid.lessons.Lesson1_Text
import com.motorola.studyandroid.lessons.Lesson2_Layout
import com.motorola.studyandroid.lessons.Lesson3_State
import com.motorola.studyandroid.lessons.Lesson4_List
import com.motorola.studyandroid.lessons.Lesson5_Input
import com.motorola.studyandroid.lessons.Lesson6_Image
import com.motorola.studyandroid.lessons.Lesson7_Network
import com.motorola.studyandroid.lessons.Lesson8_Navigation
import com.motorola.studyandroid.lessons.LessonCatalog
import com.motorola.studyandroid.lessons.LessonsMenu
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
                                containerColor = androidx.compose.material3.MaterialTheme.colorScheme.primaryContainer,
                                titleContentColor = androidx.compose.material3.MaterialTheme.colorScheme.primary
                            )
                        )
                    }
                ) { innerPadding ->
                    // 2. NavHost: 它是页面的容器，用来承载不同的页面
                    // startDestination: 设置默认显示的页面 (这里是 "Menu")
                    NavHost(
                        navController = navController,
                        startDestination = LessonCatalog.menuRoute,
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        // 3. composable("route"): 定义每一个页面
                        // "route" (路由) 就是页面的身份证号，必须唯一

                        composable(LessonCatalog.menuRoute) {
                            // 当导航到 "Menu" 时，显示 LessonsMenu
                            // 并且把跳转逻辑传给它
                            LessonsMenu { targetScreen ->
                                navigateToRoute(targetScreen)
                            }
                        }

                        composable(LessonCatalog.gettingStarted.route) { Lesson0_GettingStarted() }
                        composable(LessonCatalog.text.route) { Lesson1_Text() }
                        composable(LessonCatalog.layout.route) { Lesson2_Layout() }
                        composable(LessonCatalog.state.route) { Lesson3_State() }
                        composable(LessonCatalog.list.route) { Lesson4_List() }
                        composable(LessonCatalog.input.route) { Lesson5_Input() }
                        composable(LessonCatalog.image.route) { Lesson6_Image() }
                        composable(LessonCatalog.network.route) { Lesson7_Network() }
                        composable(LessonCatalog.navigation.route) {
                            Lesson8_Navigation(onNavigate = navigateToRoute)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    StudyAndroidTheme {
        Greeting("Android")
    }
}