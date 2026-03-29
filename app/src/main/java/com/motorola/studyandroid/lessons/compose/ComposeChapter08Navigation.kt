package com.motorola.studyandroid.lessons.compose

import com.motorola.studyandroid.lessons.shared.*
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ComposeChapter08NavigationScreen(onNavigate: (String) -> Unit) {
    val sections = listOf(
        LearningSection(
            title = "1. 导航本质上是在切换 route",
            bullets = listOf(
                "每个页面都要有一个唯一 route。",
                "NavController 负责发出跳转命令。",
                "NavHost 负责根据 route 把正确页面显示出来。"
            ),
            code = "composable(\"Lesson1\") { ComposeChapter01TextScreen() }"
        ),
        LearningSection(
            title = "2. 页面跳转常见两个动作",
            bullets = listOf(
                "navigate(route)：前往一个新页面。",
                "popBackStack()：返回上一个页面。",
                "理解返回栈后，你就能明白为什么返回按钮能工作。"
            )
        )
    )

    LessonPage(
        title = "实战第 3 章：导航基础 Navigation",
        subtitle = "这一课会把页面跳转从抽象概念变成你能点、能观察、能改的真实行为。"
    ) {
        renderLessonSections(sections)
        item {
            LessonSectionCard(title = "编程实验：直接调用项目里的导航逻辑") {
                Text(
                    text = "下面几个按钮会直接使用项目的路由和导航函数。你可以反向切换，感受 route 和返回栈在真实工程中的作用。",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(bottom = 12.dp)
                )
                Button(onClick = { onNavigate(LessonCatalog.text.route) }, modifier = Modifier.fillMaxWidth()) { Text("跳到 Compose Text 课") }
                Button(onClick = { onNavigate(LessonCatalog.input.route) }, modifier = Modifier.fillMaxWidth().padding(top = 8.dp)) { Text("跳到输入课") }
                Button(onClick = { onNavigate(LessonCatalog.menuRoute) }, modifier = Modifier.fillMaxWidth().padding(top = 8.dp)) { Text("回到课程首页") }
            }
        }
        renderPracticeSection(
            exercises = listOf(
                "在 LessonCatalog 里新增一个测试 route，并把它接进 NavGraph。",
                "把其中一个跳转按钮改成跳去协程课。",
                "想一想：为什么 route 最好不要把字符串复制到很多地方？"
            )
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun ComposeChapter08NavigationPreview() {
    LessonPreviewContainer { ComposeChapter08NavigationScreen(onNavigate = {}) }
}
