package com.motorola.studyandroid.lessons.kotlin

import com.motorola.studyandroid.lessons.shared.*
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun KotlinChapter5_Collections() {
    val sections = listOf(
        LearningSection(
            title = "1. List 是 Android UI 的高频基础",
            bullets = listOf(
                "一组有顺序的数据，最常见的就是 List。",
                "课程列表、商品列表、消息列表、评论列表，本质上都离不开 List。",
                "以后看到 LazyColumn，本质上就是把 List 渲染出来。"
            ),
            code = "val lessons = listOf(\"变量\", \"函数\", \"空安全\")"
        ),
        LearningSection(
            title = "2. for / forEach 都能遍历集合",
            bullets = listOf(
                "for 比较基础直观。",
                "forEach 更接近 Kotlin 常见风格。",
                "你以后处理列表数据时，这两种写法都常见。"
            ),
            code = "for (lesson in lessons) {\n    println(lesson)\n}\n\nlessons.forEach { println(it) }"
        ),
        LearningSection(
            title = "3. 集合和函数经常一起出现",
            bullets = listOf(
                "比如把多个任务传给函数，再拼成一段总结文案。",
                "这也是函数 + 集合的典型组合。",
                "理解这一点后，你看列表页面会轻松很多。"
            ),
            code = "fun buildTaskSummary(tasks: List<String>): String {\n    return tasks.joinToString(separator = \"、\")\n}"
        )
    )

    LessonPage(
        title = "Kotlin 第 5 章：集合 List、遍历、和函数配合",
        subtitle = "这一章帮你把 Kotlin 语言知识和真实页面开发连接起来。你会开始感受到：原来列表页面不是新知识，而是 Kotlin 集合知识的延伸。"
    ) {
        renderLessonSections(sections)

        item {
            LessonSectionCard(title = "编程实验：动态切换今天的学习任务") {
                BulletLine("点击按钮后，我们切换不同的 List。")
                BulletLine("屏幕上的文案由 buildTaskSummary(tasks) 这个函数生成。")
                CollectionsPlayground()
            }
        }

        renderPracticeSection(
            exercises = listOf(
                "给 taskGroup 再多加两个任务。",
                "尝试把 forEach 改成普通 for 来显示列表。",
                "自己写一个函数，把任务数量也拼到 summary 里。"
            )
        )
    }
}

@Composable
private fun CollectionsPlayground() {
    var taskGroup by remember {
        mutableStateOf(listOf("变量", "字符串模板", "函数"))
    }
    val summary = buildTaskSummary(taskGroup)

    Column(modifier = Modifier.fillMaxWidth()) {
        Text(text = "今日任务：$summary", style = MaterialTheme.typography.titleMedium)
        taskGroup.forEach { task ->
            Text(
                text = "- $task",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(top = 6.dp)
            )
        }
        Button(
            onClick = {
                taskGroup = listOf("高阶函数", "列表", "空安全", "Compose 状态")
            },
            modifier = Modifier.padding(top = 12.dp)
        ) {
            Text("切换到进阶任务")
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun KotlinChapter5Preview() {
    LessonPreviewContainer {
        KotlinChapter5_Collections()
    }
}
