package com.motorola.studyandroid.lessons.compose

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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ComposeLesson03StateScreen() {
    val sections = listOf(
        LearningSection(
            title = "1. State 是 Compose 的核心概念之一",
            bullets = listOf(
                "界面显示什么，往往取决于当前状态值。",
                "状态一变，依赖这个状态的 UI 就会重新计算。",
                "所以学习 Compose，最重要的思维之一就是：不要直接改界面，而是改状态。"
            ),
            code = "var count by remember { mutableIntStateOf(0) }"
        ),
        LearningSection(
            title = "2. remember 让状态在重组后还能保留",
            bullets = listOf(
                "如果没有 remember，界面一刷新，变量就可能回到初始值。",
                "remember 的作用是：把这个状态值记住。",
                "这也是为什么计数器 demo 总会和 remember 一起出现。"
            )
        ),
        LearningSection(
            title = "3. 重组会更新依赖状态的 UI",
            bullets = listOf(
                "当 count 改变时，依赖 count 的文字会更新。",
                "这就是为什么 Compose 看起来像自动刷新。",
                "理解重组后，你会更明白为什么 state 是框架核心。"
            )
        )
    )

    LessonPage(
        title = "Compose 第 4 章：状态 State（计数器）",
        subtitle = "这节课会把界面为什么会变讲透。你以后写输入框、列表、网络加载、按钮点击，全都离不开状态。"
    ) {
        renderLessonSections(sections)
        item {
            LessonSectionCard(title = "编程实验：两个 UI 同时依赖一个状态") {
                BulletLine("下面计数器和心情文本都依赖同一个 count。")
                BulletLine("只要 count 变化，两块 UI 都会自动更新。")
                StatePlayground()
            }
        }
        renderPracticeSection(
            exercises = listOf(
                "自己加一个 +10 按钮。",
                "给 count 小于 0 时增加一段警告提示。",
                "把心情文案改成你自己更容易理解的版本。"
            )
        )
    }
}

@Composable
private fun StatePlayground() {
    var count by remember { mutableIntStateOf(0) }
    var label by remember { mutableStateOf("还没有开始点击") }

    Column(modifier = Modifier.fillMaxWidth()) {
        Text(text = "当前 count = $count", style = MaterialTheme.typography.titleMedium)
        Text(text = label, style = MaterialTheme.typography.bodyMedium, modifier = Modifier.padding(top = 8.dp, bottom = 12.dp))
        Button(onClick = {
            count += 1
            label = if (count >= 5) "你已经连续点击很多次了，状态正在驱动 UI 刷新。" else "继续点击，观察文字如何跟着状态变化。"
        }) {
            Text("点我 +1")
        }
        Button(onClick = { count = 0; label = "状态已重置回初始值。" }, modifier = Modifier.padding(top = 8.dp)) {
            Text("重置状态")
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun ComposeLesson03StatePreview() {
    LessonPreviewContainer { ComposeLesson03StateScreen() }
}
