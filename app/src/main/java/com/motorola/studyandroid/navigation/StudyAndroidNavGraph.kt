package com.motorola.studyandroid.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.motorola.studyandroid.lessons.compose.ComposeLesson00GettingStartedScreen
import com.motorola.studyandroid.lessons.compose.ComposeLesson01TextScreen
import com.motorola.studyandroid.lessons.compose.ComposeLesson02LayoutScreen
import com.motorola.studyandroid.lessons.compose.ComposeLesson03StateScreen
import com.motorola.studyandroid.lessons.compose.ComposeLesson04ListScreen
import com.motorola.studyandroid.lessons.compose.ComposeLesson05InputScreen
import com.motorola.studyandroid.lessons.compose.ComposeLesson06ImageScreen
import com.motorola.studyandroid.lessons.compose.ComposeLesson07NetworkScreen
import com.motorola.studyandroid.lessons.compose.ComposeLesson08NavigationScreen
import com.motorola.studyandroid.lessons.compose.ComposeLesson09CoroutinesScreen
import com.motorola.studyandroid.lessons.compose.ComposeLesson10PagerAndScrollScreen
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
        composable(LessonCatalog.gettingStarted.route) { ComposeLesson00GettingStartedScreen() }
        composable(LessonCatalog.text.route) { ComposeLesson01TextScreen() }
        composable(LessonCatalog.layout.route) { ComposeLesson02LayoutScreen() }
        composable(LessonCatalog.state.route) { ComposeLesson03StateScreen() }
        composable(LessonCatalog.list.route) { ComposeLesson04ListScreen() }
        composable(LessonCatalog.input.route) { ComposeLesson05InputScreen() }
        composable(LessonCatalog.pagerAndScroll.route) { ComposeLesson10PagerAndScrollScreen() }
        composable(LessonCatalog.image.route) { ComposeLesson06ImageScreen() }
        composable(LessonCatalog.network.route) { ComposeLesson07NetworkScreen() }
        composable(LessonCatalog.navigation.route) { ComposeLesson08NavigationScreen(onNavigate = onNavigate) }
        composable(LessonCatalog.coroutines.route) { ComposeLesson09CoroutinesScreen() }
    }
}

