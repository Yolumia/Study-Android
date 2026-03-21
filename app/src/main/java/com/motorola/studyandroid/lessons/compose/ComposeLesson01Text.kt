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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ComposeLesson01TextScreen() {
    val sections = listOf(
        LearningSection(
            title = "1. Text 是 Compose 里最基础的显示组件",
            bullets = listOf(
                "只要你想在屏幕上显示一段文字，最常见就是用 Text。",
                "标题、按钮文案、错误提示、用户名、价格，本质上都离不开 Text。",
                "所以 Text 看起来简单，但几乎每个页面都会用到。"
            ),
            code = "Text(text = \"你好，Compose\")"
        ),
        LearningSection(
            title = "2. 常见可调属性：字号、颜色、字重",
            bullets = listOf(
                "fontSize 控制文字大小。",
                "color 控制文字颜色。",
                "fontWeight 控制文字粗细，比如 Bold。",
                "这些属性一起用时，就能很快做出“标题”和“正文”的层次感。"
            ),
            code = "Text(\n    text = \"重要标题\",\n    fontSize = 24.sp,\n    color = Color(0xFF1565C0),\n    fontWeight = FontWeight.Bold\n)"
        ),
        LearningSection(
            title = "3. Modifier 会影响 Text 在页面里的表现",
            bullets = listOf(
                "Text 不是只有内容本身，还会受到 padding、fillMaxWidth 等 Modifier 影响。",
                "所以你以后看到文字位置不对，不一定是 Text 属性错了，也可能是 Modifier 问题。",
                "这也是为什么 Text 和 Modifier 往往要一起理解。"
            )
        )
    )

    LessonPage(
        title = "Compose 第 2 章：Text 文字基础",
        subtitle = "这一课不只是告诉你 Text 能显示字，而是要让你知道：文字在真实 App 里会有层级、状态和样式变化。"
    ) {
        renderLessonSections(sections)

        item {
            LessonSectionCard(title = "编程实验：点击按钮，切换同一段文字的样式") {
                BulletLine("下面这个 demo 会让同一段文字在“普通提示”和“重点标题”之间切换。")
                BulletLine("这样你能立刻看到 fontSize、color、fontWeight 的作用。")
                TextStylePlayground()
            }
        }

        renderPracticeSection(
            exercises = listOf(
                "把高亮状态下的颜色改成你自己喜欢的颜色。",
                "把普通状态的文字改成更小的字号，观察层级差异。",
                "尝试给 Text 再加一个 Modifier.padding，看位置会怎么变化。"
            )
        )
    }
}

@Composable
private fun TextStylePlayground() {
    var isHighlighted by remember { mutableStateOf(false) }

    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = if (isHighlighted) "现在是重点标题样式" else "现在是普通正文样式",
            fontSize = if (isHighlighted) 26.sp else 16.sp,
            color = if (isHighlighted) Color(0xFF0D47A1) else MaterialTheme.colorScheme.onSurfaceVariant,
            fontWeight = if (isHighlighted) FontWeight.Bold else FontWeight.Normal,
            modifier = Modifier.padding(bottom = 12.dp)
        )
        Button(onClick = { isHighlighted = !isHighlighted }) {
            Text(if (isHighlighted) "切回普通样式" else "切换成重点样式")
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun ComposeLesson01TextPreview() {
    LessonPreviewContainer {
        ComposeLesson01TextScreen()
    }
}
