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
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun KotlinChapter7_Classes() {
    val sections = listOf(
        LearningSection(
            title = "1. class 是把数据和行为装到一起",
            bullets = listOf(
                "类可以同时保存数据，也可以定义方法。",
                "如果说函数是做事的单位，类就是组织数据和行为的容器。",
                "以后你写 ViewModel、数据模型、状态对象时都会频繁接触类。"
            ),
            code = "class User(val name: String, val level: Int)"
        ),
        LearningSection(
            title = "2. data class 很适合放纯数据",
            bullets = listOf(
                "data class 是 Kotlin 非常常见的数据模型写法。",
                "它会自动帮你生成 toString、equals、copy 等常用能力。",
                "网络返回结果、本地数据、UI 状态对象都很适合 data class。"
            ),
            code = "data class KotlinHero(val name: String, val level: Int, val title: String)"
        ),
        LearningSection(
            title = "3. 函数和类会一起工作",
            bullets = listOf(
                "createHero() 是函数。",
                "KotlinHero 是 data class。",
                "函数把参数加工后，返回一个对象，这是特别常见的编程模式。"
            )
        )
    )

    LessonPage(
        title = "Kotlin 第 7 章：类、data class、对象",
        subtitle = "这一章把你从只会写函数推进到会组织数据结构。你会发现：Kotlin 的很多强大之处，恰恰在于函数和 data class 配合得很好。"
    ) {
        renderLessonSections(sections)

        item {
            LessonSectionCard(title = "编程实验：点击按钮，重新创建一个 KotlinHero 对象") {
                BulletLine("每点一次按钮，就会重新调用 createHero()。")
                BulletLine("返回的是一个 KotlinHero 数据对象，然后显示到界面上。")
                ClassPlayground()
            }
        }

        renderPracticeSection(
            exercises = listOf(
                "给 KotlinHero 再增加一个 hp 字段。",
                "把 createHero() 里 title 的判定阈值改掉。",
                "试着新增一个函数，专门返回 hero 的展示文案。"
            )
        )
    }
}

@Composable
private fun ClassPlayground() {
    var level by remember { mutableIntStateOf(1) }
    val hero = createHero(name = "Compose 勇者", level = level)

    Column(modifier = Modifier.fillMaxWidth()) {
        Text(text = "name = ${hero.name}", style = MaterialTheme.typography.titleMedium)
        Text(
            text = "level = ${hero.level}",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(top = 6.dp)
        )
        Text(
            text = "title = ${hero.title}",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(top = 6.dp)
        )
        Button(
            onClick = { level += 3 },
            modifier = Modifier.padding(top = 12.dp)
        ) {
            Text("升级 +3")
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun KotlinChapter7Preview() {
    LessonPreviewContainer {
        KotlinChapter7_Classes()
    }
}
