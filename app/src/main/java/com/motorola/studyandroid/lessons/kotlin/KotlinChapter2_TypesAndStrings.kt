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
fun KotlinChapter2_TypesAndStrings() {
    val sections = listOf(
        LearningSection(
            title = "1. Kotlin 常见基本类型",
            bullets = listOf(
                "Int：整数。比如 18、100。",
                "Double / Float：小数。比如 19.9、3.14。",
                "Boolean：true 或 false。常用来表示开关、条件。",
                "String：字符串，也就是一段文字。"
            ),
            code = "val age: Int = 18\nval price: Double = 19.9\nval isVip: Boolean = true\nval nickname: String = \"Tom\""
        ),
        LearningSection(
            title = "2. 字符串模板非常常用",
            bullets = listOf(
                "Kotlin 支持在字符串里直接写变量。",
                "写法是 ${'$'}变量名，或者 ${'$'}{表达式}。",
                "在 Compose 里拼接界面文案时，这种写法特别高频。"
            ),
            code = "val name = \"Tom\"\nval score = 90\nval message = \"你好，${'$'}name，你的分数是 ${'$'}score\""
        ),
        LearningSection(
            title = "3. Boolean 往往配合 if 一起用",
            bullets = listOf(
                "条件判断最终都要落到 true / false。",
                "比如是否登录、是否会员、按钮是否可点击，背后都常常是 Boolean。",
                "下一章和函数一起写逻辑时，你会更常看到这种组合。"
            )
        )
    )

    LessonPage(
        title = "Kotlin 第 2 章：类型、字符串模板、Boolean",
        subtitle = "这一章的目标是：看到一段 Kotlin 变量声明时，你能大概说出它是什么类型；看到字符串模板时，不再觉得语法奇怪。"
    ) {
        renderLessonSections(sections)

        item {
            LessonSectionCard(title = "编程实验：切换会员状态，观察字符串模板怎么更新") {
                BulletLine("这里同时用到了 String、Int、Boolean。")
                BulletLine("点击按钮后，isVip 会变化，所以显示文字也会变化。")
                TypesPlayground()
            }
        }

        renderPracticeSection(
            exercises = listOf(
                "把 level 改成别的数字，看看文案如何变化。",
                "自己新增一个 city 变量，并把它拼进字符串模板。",
                "把普通用户和 VIP 用户的文案写得更有区别。"
            )
        )
    }
}

@Composable
private fun TypesPlayground() {
    val nickname = "类型学习者"
    val level = 3
    var isVip by remember { mutableStateOf(false) }
    val summary = if (isVip) {
        "你好，$nickname！你现在是 VIP 用户，等级是 $level。"
    } else {
        "你好，$nickname！你现在是普通用户，等级是 $level。"
    }

    Column(modifier = Modifier.fillMaxWidth()) {
        Text(text = summary, style = MaterialTheme.typography.titleMedium)
        Button(
            onClick = { isVip = !isVip },
            modifier = Modifier.padding(top = 12.dp)
        ) {
            Text(if (isVip) "切换成普通用户" else "切换成 VIP 用户")
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun KotlinChapter2Preview() {
    LessonPreviewContainer {
        KotlinChapter2_TypesAndStrings()
    }
}
