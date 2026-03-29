package com.motorola.studyandroid.lessons.compose

import com.motorola.studyandroid.lessons.shared.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ComposeChapter02LayoutScreen() {
    val sections = listOf(
        LearningSection(
            title = "1. Row / Column / Box 是 Compose 三个最基础的布局容器",
            bullets = listOf(
                "Row：横向排列。",
                "Column：纵向排列。",
                "Box：允许组件叠在一起。",
                "绝大多数页面布局，本质上都是这三个容器组合出来的。"
            ),
            code = "Row { ... }\nColumn { ... }\nBox { ... }"
        ),
        LearningSection(
            title = "2. 布局不只是摆放，还要考虑对齐和间距",
            bullets = listOf(
                "你放进去的组件会怎么排，取决于布局容器和 Modifier。",
                "常见问题有：为什么靠左、为什么没有空隙、为什么重叠了。",
                "所以布局课的重点不是背 API，而是建立页面结构感。"
            ),
            code = "Row(modifier = Modifier.fillMaxWidth()) {\n    ...\n}"
        ),
        LearningSection(
            title = "3. 以后写复杂页面，本质也是组合这些基础布局",
            bullets = listOf(
                "顶部标题栏通常可以理解成 Row。",
                "详情页正文区域通常常见 Column。",
                "头像叠徽章、小红点提示，常常就会用到 Box。"
            )
        )
    )

    LessonPage(
        title = "Compose 第 3 章：布局 Row / Column / Box",
        subtitle = "这一课不是只让你记住三个名字，而是让你学会看到一个界面时，脑中能拆出布局结构。"
    ) {
        renderLessonSections(sections)

        item {
            LessonSectionCard(title = "编程实验：切换不同布局，看组件怎样重新排列") {
                BulletLine("点击按钮后，下面的三个彩色方块会在 Row、Column、Box 三种布局之间切换。")
                BulletLine("同一组元素，不同容器，结果会完全不同。")
                LayoutPlayground()
            }
        }

        renderPracticeSection(
            exercises = listOf(
                "在 Row 模式下，再多加一个黄色方块。",
                "把 Box 模式下最上层的方块尺寸改小，看叠层更明显。",
                "试着给 Column 模式下的每个方块再加一点 padding。"
            )
        )
    }
}

@Composable
private fun LayoutPlayground() {
    var layoutMode by remember { mutableStateOf("Row") }

    Column(modifier = Modifier.fillMaxWidth()) {
        Text(text = "当前布局模式：$layoutMode", style = MaterialTheme.typography.titleMedium)
        Button(
            onClick = {
                layoutMode = when (layoutMode) {
                    "Row" -> "Column"
                    "Column" -> "Box"
                    else -> "Row"
                }
            },
            modifier = Modifier.padding(top = 12.dp, bottom = 12.dp)
        ) {
            Text("切换布局模式")
        }

        when (layoutMode) {
            "Row" -> Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                ColorBlock(Color(0xFF66BB6A), "A")
                ColorBlock(Color(0xFF42A5F5), "B")
                ColorBlock(Color(0xFFEF5350), "C")
            }

            "Column" -> Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                ColorBlock(Color(0xFF66BB6A), "A")
                ColorBlock(Color(0xFF42A5F5), "B")
                ColorBlock(Color(0xFFEF5350), "C")
            }

            else -> Box(
                modifier = Modifier
                    .size(160.dp)
                    .background(Color(0xFFECEFF1)),
                contentAlignment = Alignment.Center
            ) {
                ColorBlock(Color(0xFF66BB6A), "A", 120.dp)
                ColorBlock(Color(0xFF42A5F5), "B", 90.dp)
                ColorBlock(Color(0xFFEF5350), "C", 60.dp)
            }
        }
    }
}

@Composable
private fun ColorBlock(color: Color, label: String, size: androidx.compose.ui.unit.Dp = 56.dp) {
    Box(
        modifier = Modifier
            .size(size)
            .background(color),
        contentAlignment = Alignment.Center
    ) {
        Text(text = label, color = Color.White)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun ComposeChapter02LayoutPreview() {
    LessonPreviewContainer {
        ComposeChapter02LayoutScreen()
    }
}
