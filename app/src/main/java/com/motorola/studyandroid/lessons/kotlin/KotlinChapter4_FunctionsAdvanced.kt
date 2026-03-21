package com.motorola.studyandroid.lessons

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun KotlinChapter4_FunctionsAdvanced() {
    val sections = listOf(
        LearningSection(
            title = "1. 默认参数：不给值时也能正常工作",
            bullets = listOf(
                "默认参数能减少很多重复重载函数。",
                "比如城市没填时，函数自己用默认城市。",
                "在 Android 里做格式化文本时特别好用。"
            ),
            code = "fun formatProfile(name: String, city: String = \"未知城市\"): String {\n    return \"${'$'}name，来自 ${'$'}city\"\n}"
        ),
        LearningSection(
            title = "2. 命名参数让调用更清晰",
            bullets = listOf(
                "如果参数变多，用命名参数更容易读懂。",
                "尤其在 Compose 里，你已经经常看到这种风格，比如 Text(text = ..., color = ...)。",
                "这说明 Kotlin 的函数设计和 Compose 的 API 风格是高度契合的。"
            ),
            code = "formatProfile(name = \"小白\", city = \"北京\")"
        ),
        LearningSection(
            title = "3. vararg：让函数接收不定数量参数",
            bullets = listOf(
                "有时候你不知道会传几个值，这时可以用 vararg。",
                "比如把很多分数、很多标签、很多数字一次性传给函数。",
                "底层你可以把它理解成“函数内部收到了一组数据”。"
            ),
            code = "fun sumAll(vararg values: Int): Int {\n    return values.sum()\n}"
        ),
        LearningSection(
            title = "4. 高阶函数：函数也可以当参数传进去",
            bullets = listOf(
                "这一步是 Kotlin 很有力量的地方。",
                "你可以把“怎么处理数据”这件事，也变成一个可传入的参数。",
                "Compose 的点击事件 onClick，本质上就是把一个函数传给另一个函数。"
            ),
            code = "fun applyTransformation(value: Int, transform: (Int) -> Int): Int {\n    return transform(value)\n}"
        )
    )

    LessonPage(
        title = "Kotlin 第 4 章：函数进阶、默认参数、vararg、高阶函数",
        subtitle = "如果说上一章是“会定义函数”，这一章就是“会把函数用得更像 Kotlin”。也是你看懂 Compose API 的关键一章。"
    ) {
        renderLessonSections(sections)

        item {
            LessonSectionCard(title = "编程实验：同一个数字，传给不同函数处理") {
                BulletLine("下面你会看到：函数不仅能返回值，还能把“处理方式”作为参数传进去。")
                BulletLine("这就是你以后理解 onClick、lambda、状态处理的重要基础。")
                FunctionAdvancedPlayground()
            }
        }
    }
}

@Composable
private fun FunctionAdvancedPlayground() {
    var currentValue by remember { mutableIntStateOf(10) }
    var profileText by remember { mutableStateOf(formatProfile(name = "函数学习者")) }
    val totalText = sumAll(3, 5, 7, 9)

    Column(modifier = Modifier.fillMaxWidth()) {
        Text(text = "当前数字：$currentValue", style = MaterialTheme.typography.titleMedium)
        Text(
            text = "默认参数示例：$profileText",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(top = 8.dp)
        )
        Text(
            text = "vararg 求和示例：sumAll(3, 5, 7, 9) = $totalText",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(top = 8.dp)
        )
        Button(
            onClick = { currentValue = applyTransformation(currentValue) { it + 5 } },
            modifier = Modifier.padding(top = 12.dp)
        ) {
            Text("把当前数字 +5")
        }
        Button(
            onClick = {
                currentValue = applyTransformation(currentValue) { it * 2 }
                profileText = formatProfile(name = "函数学习者", city = "上海", age = currentValue)
            },
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Text("把当前数字 *2，并用命名参数更新资料")
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun KotlinChapter4Preview() {
    LessonPreviewContainer {
        KotlinChapter4_FunctionsAdvanced()
    }
}

