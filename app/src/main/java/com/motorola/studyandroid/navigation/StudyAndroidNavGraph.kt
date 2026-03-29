package com.motorola.studyandroid.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.motorola.studyandroid.lessons.compose.ComposeChapter00GettingStartedScreen
import com.motorola.studyandroid.lessons.compose.ComposeChapter01TextScreen
import com.motorola.studyandroid.lessons.compose.ComposeChapter02LayoutScreen
import com.motorola.studyandroid.lessons.compose.ComposeChapter03StateScreen
import com.motorola.studyandroid.lessons.compose.ComposeChapter04ListScreen
import com.motorola.studyandroid.lessons.compose.ComposeChapter05InputScreen
import com.motorola.studyandroid.lessons.compose.ComposeChapter06ImageScreen
import com.motorola.studyandroid.lessons.compose.ComposeChapter07NetworkScreen
import com.motorola.studyandroid.lessons.compose.ComposeChapter08NavigationScreen
import com.motorola.studyandroid.lessons.compose.ComposeChapter09CoroutinesScreen
import com.motorola.studyandroid.lessons.compose.ComposeChapter10PagerAndScrollScreen
import com.motorola.studyandroid.lessons.java.JavaLesson01BasicsScreen
import com.motorola.studyandroid.lessons.java.JavaLesson02JavaVsKotlinScreen
import com.motorola.studyandroid.lessons.kotlin.KotlinChapter1_Variables
import com.motorola.studyandroid.lessons.kotlin.KotlinChapter2_TypesAndStrings
import com.motorola.studyandroid.lessons.kotlin.KotlinChapter3_FunctionsBasics
import com.motorola.studyandroid.lessons.kotlin.KotlinChapter4_FunctionsAdvanced
import com.motorola.studyandroid.lessons.kotlin.KotlinChapter5_Collections
import com.motorola.studyandroid.lessons.kotlin.KotlinChapter6_NullSafety
import com.motorola.studyandroid.lessons.kotlin.KotlinChapter7_Classes
import com.motorola.studyandroid.lessons.shared.LessonCatalog
import com.motorola.studyandroid.lessons.shared.LessonsMenu

@Composable
fun StudyAndroidNavGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    onNavigate: (String) -> Unit
) {
    NavHost(navController = navController, startDestination = LessonCatalog.menuRoute, modifier = modifier) {
        composable(LessonCatalog.menuRoute) { LessonsMenu(onLessonSelect = onNavigate) }
        composable(LessonCatalog.kotlinVariables.route) { KotlinChapter1_Variables() }
        composable(LessonCatalog.kotlinTypesStrings.route) { KotlinChapter2_TypesAndStrings() }
        composable(LessonCatalog.kotlinFunctionsBasics.route) { KotlinChapter3_FunctionsBasics() }
        composable(LessonCatalog.kotlinFunctionsAdvanced.route) { KotlinChapter4_FunctionsAdvanced() }
        composable(LessonCatalog.kotlinCollections.route) { KotlinChapter5_Collections() }
        composable(LessonCatalog.kotlinNullSafety.route) { KotlinChapter6_NullSafety() }
        composable(LessonCatalog.kotlinClasses.route) { KotlinChapter7_Classes() }
        composable(LessonCatalog.javaBasics.route) { JavaLesson01BasicsScreen() }
        composable(LessonCatalog.javaVsKotlin.route) { JavaLesson02JavaVsKotlinScreen() }
        composable(LessonCatalog.gettingStarted.route) { ComposeChapter00GettingStartedScreen() }
        composable(LessonCatalog.text.route) { ComposeChapter01TextScreen() }
        composable(LessonCatalog.layout.route) { ComposeChapter02LayoutScreen() }
        composable(LessonCatalog.state.route) { ComposeChapter03StateScreen() }
        composable(LessonCatalog.list.route) { ComposeChapter04ListScreen() }
        composable(LessonCatalog.input.route) { ComposeChapter05InputScreen() }
        composable(LessonCatalog.pagerAndScroll.route) { ComposeChapter10PagerAndScrollScreen() }
        composable(LessonCatalog.image.route) { ComposeChapter06ImageScreen() }
        composable(LessonCatalog.network.route) { ComposeChapter07NetworkScreen() }
        composable(LessonCatalog.navigation.route) { ComposeChapter08NavigationScreen(onNavigate = onNavigate) }
        composable(LessonCatalog.coroutines.route) { ComposeChapter09CoroutinesScreen() }
    }
}

