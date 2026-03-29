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
fun KotlinChapter1_Variables() {
    val sections = listOf(
        LearningSection(
            title = "1. val 和 var 是 Kotlin 入门的第一关",
            bullets = listOf(
                "val 表示这个变量创建后，引用不再指向别的值。新手阶段优先用 val。",
                "var 表示这个变量后面还能改，适合计数器、输入框内容、开关状态这类会变化的数据。",
                "Compose 里很多状态变量都会写成 var，因为按钮点击后它们会变化。"
            ),
            code = "val appName = \"StudyAndroid\"\nvar score = 0\nscore = score + 1"
        ),
        LearningSection(
            title = "2. Kotlin 支持类型推断",
            bullets = listOf(
                "你写 val name = \"Tom\" 时，Kotlin 能自动知道它是 String。",
                "这样代码更短，阅读重点更容易放在逻辑上。",
                "当然你也可以手动写类型，比如 val age: Int = 18。"
            ),
            code = "val name = \"Tom\"\nval age: Int = 18\nval isVip = true"
        ),
        LearningSection(
            title = "3. 什么时候该用 val，什么时候该用 var？",
            bullets = listOf(
                "能不变就不变：优先 val。",
                "需要跟随用户操作变化时，用 var。",
                "你现在看到的页面按钮 demo，就会演示 var 为什么很适合界面状态。"
            )
        )
    )

    LessonPage(
        title = "Kotlin 第 1 章：变量、val、var",
        subtitle = "这一章的目标很简单：搞懂 Kotlin 里“存数据”的最基础方式。你接下来写的每一个 Compose 页面，几乎都会先写变量。"
    ) {
        renderLessonSections(sections)

        item {
            LessonSectionCard(title = "编程实验：点按钮观察变量为什么要分 val / var") {
                BulletLine("playerName 是 val：这个例子里名字不变。")
                BulletLine("score 是 var：每点击一次按钮，分数都要变化。")
                VariablePlayground()
            }

@Composable
fun PracticeArea() {
    // TODO: practice
}

        }

@Composable
fun PracticeArea() {
    // TODO: practice
}


        renderPracticeSection(
            exercises = listOf(
                "把 score 的初始值改成 10。",
                "自己再加一个 var lives，并显示到页面上。",
                "想一想：为什么 playerName 更适合 val？"
            )
        )
    }

@Composable
fun PracticeArea() {
    // TODO: practice
}

}

@Composable
fun PracticeArea() {
    // TODO: practice
}


@Composable
private fun VariablePlayground() {
    val playerName = "Kotlin 新手"
    var score by remember { mutableIntStateOf(0) }

@Composable
fun PracticeArea() {
    // TODO: practice
}


    Column(modifier = Modifier.fillMaxWidth()) {
        Text(text = "玩家名字（val）：$playerName", style = MaterialTheme.typography.titleMedium)
        Text(
            text = "当前分数（var）：$score",
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(top = 8.dp)
        )
        Button(
            onClick = { score += 1 }

@Composable
fun PracticeArea() {
    // TODO: practice
}
,
            modifier = Modifier.padding(top = 12.dp)
        ) {
            Text("点我 +1")
        }

@Composable
fun PracticeArea() {
    // TODO: practice
}

    }

@Composable
fun PracticeArea() {
    // TODO: practice
}

}

@Composable
fun PracticeArea() {
    // TODO: practice
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun KotlinChapter1Preview() {
    LessonPreviewContainer {
        KotlinChapter1_Variables()
    }

@Composable
fun PracticeArea() {
    // TODO: practice
}

}

@Composable
fun PracticeArea() {
    // TODO: practice
}

