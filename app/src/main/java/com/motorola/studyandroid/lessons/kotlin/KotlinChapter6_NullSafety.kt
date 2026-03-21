package com.motorola.studyandroid.lessons

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
fun KotlinChapter6_NullSafety() {
    val sections = listOf(
        LearningSection(
            title = "1. String 和 String? 完全不是一回事",
            bullets = listOf(
                "String 表示一定有值。",
                "String? 表示可能为空。",
                "Kotlin 通过这种区分，把很多空指针风险提前暴露出来。"
            ),
            code = "val userName: String = \"Tom\"\nval nickName: String? = null"
        ),
        LearningSection(
            title = "2. ?. 表示安全调用",
            bullets = listOf(
                "如果变量不为空，就继续调用。",
                "如果变量为空，就直接得到 null。",
                "它很适合接口数据、输入框数据这类“可能没有值”的场景。"
            ),
            code = "val nickName: String? = null\nval length = nickName?.length"
        ),
        LearningSection(
            title = "3. ?: 给默认值",
            bullets = listOf(
                "如果左边是 null，就用右边的值。",
                "这在页面显示时非常常见。",
                "比如用户还没登录、昵称还没拿到时，就先显示“游客”。"
            ),
            code = "val showName = nickName ?: \"游客\""
        ),
        LearningSection(
            title = "4. 为什么新手阶段少用 !!",
            bullets = listOf(
                "!! 表示“我保证它绝对不为空”。",
                "如果你保证错了，程序就会崩。",
                "所以新手阶段优先用 ?. 和 ?:，会更安全。"
            )
        )
    )

    LessonPage(
        title = "Kotlin 第 6 章：空安全 Null Safety",
        subtitle = "这一章会让你第一次真正体会 Kotlin 的“安全感”来自哪里。后面你学网络请求、用户输入、数据库时，这个知识会反复出现。"
    ) {
        renderLessonSections(sections)

        item {
            LessonSectionCard(title = "编程实验：名字可能为空时，页面如何安全显示") {
                BulletLine("displayName 使用了 ?:，所以 null 时也能显示“游客”。")
                BulletLine("safeNameLength() 使用了 ?. 和 ?:，所以不会空指针崩溃。")
                NullSafetyPlayground()
            }
        }
    }
}

@Composable
private fun NullSafetyPlayground() {
    var rawName by remember { mutableStateOf<String?>(null) }
    val displayName = nullableDisplayName(rawName)
    val nameLength = safeNameLength(rawName)

    Column(modifier = Modifier.fillMaxWidth()) {
        Text(text = "当前显示名：$displayName", style = MaterialTheme.typography.titleMedium)
        Text(
            text = "安全长度：$nameLength",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(top = 8.dp)
        )
        Button(
            onClick = { rawName = "空安全学习者" },
            modifier = Modifier.padding(top = 12.dp)
        ) {
            Text("给它一个名字")
        }
        Button(
            onClick = { rawName = null },
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Text("把名字改回 null")
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun KotlinChapter6Preview() {
    LessonPreviewContainer {
        KotlinChapter6_NullSafety()
    }
}

