package com.motorola.studyandroid.lessons

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

private data class CompareSection(
    val title: String,
    val bullets: List<String>,
    val code: String? = null
)

@Composable
fun PreLesson4_JavaVsKotlin() {
    val sections = listOf(
        CompareSection(
            title = "1. 先记结论：Android 新项目优先 Kotlin",
            bullets = listOf(
                "Compose 基本就是 Kotlin 世界。",
                "官方文档、示例、现代写法，大多优先 Kotlin。",
                "所以你的主线学习应该是 Kotlin，Java 先作为“看懂旧代码”的辅助能力。"
            )
        ),
        CompareSection(
            title = "2. 同样的变量，Kotlin 更短",
            bullets = listOf(
                "Java 通常要写完整类型和分号。",
                "Kotlin 很多时候可以自动推断类型。",
                "代码更短，不代表更难，反而更容易聚焦核心逻辑。"
            ),
            code = "Java：\nString name = \"Tom\";\n\nKotlin：\nval name = \"Tom\""
        ),
        CompareSection(
            title = "3. 同样的函数，Kotlin 更像在写“表达式”",
            bullets = listOf(
                "Java 写法更传统。",
                "Kotlin 函数可以更简洁。",
                "以后你看到很多 Kotlin 代码会发现：样板代码少很多。"
            ),
            code = "Java：\npublic int add(int a, int b) {\n    return a + b;\n}\n\nKotlin：\nfun add(a: Int, b: Int): Int {\n    return a + b\n}"
        ),
        CompareSection(
            title = "4. 空安全是 Kotlin 很大的优势",
            bullets = listOf(
                "Java 里 null 更容易一不小心就出问题。",
                "Kotlin 通过 String 和 String? 的区分，提前提醒你风险。",
                "这对 Android 页面状态、网络数据、用户输入都非常有帮助。"
            )
        ),
        CompareSection(
            title = "5. 你作为零基础，该怎么安排语言学习？",
            bullets = listOf(
                "先把 Kotlin 基础、Kotlin 空安全搞懂。",
                "再补一点 Java 基础，至少能看懂老教程和老项目。",
                "然后进入 Lesson 0 和 Android 主线课程，把语言知识用到真实页面里。"
            )
        )
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        contentPadding = PaddingValues(vertical = 16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        item {
            LessonHeader(
                title = "预备课 4：Java 和 Kotlin 怎么选？",
                subtitle = "这节课帮你建立方向感：主线先学 Kotlin，Java 作为补充。这样你既不会迷路，也不会害怕旧项目代码。"
            )
        }

        items(sections) { section ->
            LessonSectionCard(title = section.title) {
                section.bullets.forEach { BulletLine(it) }
                section.code?.let { CodeBlock(it) }
            }
        }

        item {
            LessonSectionCard(title = "课后小练习") {
                BulletLine("试着说出：为什么 Compose 学习一定要先掌握 Kotlin。")
                BulletLine("比较 Java 和 Kotlin 的变量声明，你更容易读哪一种？为什么？")
                BulletLine("给自己定一个学习顺序：Kotlin 基础 → Kotlin 空安全 → Java 基础 → Android Compose。")
            }
        }

        item {
            LessonSectionCard(title = "动手看效果：同一个需求，Kotlin 往往写得更短") {
                BulletLine("下面这个例子不是让你死记代码，而是让你形成一个感觉：Kotlin 更适合现代 Android。")
                JavaVsKotlinDemo()
            }
        }
    }
}

@Composable
private fun JavaVsKotlinDemo() {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "需求：显示一个用户名，如果为空就显示“游客”。",
            style = MaterialTheme.typography.titleMedium
        )
        Text(
            text = "Kotlin 里可以直接用 ?: 给默认值，所以很适合处理 Android 页面状态。",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(top = 8.dp, bottom = 12.dp)
        )
        CodeBlock(
            code = "Java：\nString name = null;\nString displayName = name != null ? name : \"游客\";\n\nKotlin：\nval name: String? = null\nval displayName = name ?: \"游客\""
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun PreLesson4JavaVsKotlinPreview() {
    LessonPreviewContainer {
        PreLesson4_JavaVsKotlin()
    }
}

