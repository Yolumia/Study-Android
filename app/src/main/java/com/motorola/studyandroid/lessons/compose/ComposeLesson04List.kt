package com.motorola.studyandroid.lessons.compose

import com.motorola.studyandroid.lessons.shared.*
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
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
import androidx.compose.ui.unit.sp

@Composable
fun ComposeLesson04ListScreen() {
    val sections = listOf(
        LearningSection(
            title = "1. LazyColumn 是 Compose 里的高性能纵向列表",
            bullets = listOf(
                "它和传统 Android 里的 RecyclerView 思路很接近。",
                "最大特点是：只渲染当前可见区域附近的内容。",
                "所以即使数据很多，也不会一次性把所有项都画出来。"
            ),
            code = "LazyColumn {\n    items(dataList) { item -> ... }\n}"
        ),
        LearningSection(
            title = "2. item 和 items 的区别",
            bullets = listOf(
                "item 用来放单个固定内容，比如头部、底部、说明块。",
                "items 用来遍历一整个列表。",
                "以后你做标题 + 列表 + 底部按钮页面时，这种组合很常见。"
            ),
            code = "item { Text(\"头部\") }\nitems(tasks) { task -> TaskRow(task) }"
        )
    )

    LessonPage(
        title = "Compose 第 5 章：列表 LazyColumn",
        subtitle = "这一课会让你理解：列表页面不是神秘组件，而是数据集合 + 列表容器 + 每一项布局的组合。"
    ) {
        renderLessonSections(sections)
        item {
            LessonSectionCard(title = "编程实验：切换不同任务列表") {
                BulletLine("点击按钮后，我们会替换掉整个 List。")
                BulletLine("LazyColumn 会根据新的数据重新显示列表项。")
                ListPlayground()
            }
        }
        renderPracticeSection(
            exercises = listOf(
                "在任务列表里再加一项你今天最想学的内容。",
                "把列表项前面的星标换成别的图标。",
                "尝试给列表头部再多加一段说明文本。"
            )
        )
    }
}

@Composable
private fun ListPlayground() {
    var currentTasks by remember { mutableStateOf(listOf("学习 val / var", "理解函数参数", "尝试写一个 Text 页面")) }

    LazyColumn {
        item {
            Button(onClick = {
                currentTasks = listOf("学习 LazyColumn", "给列表加头部", "让列表项支持点击", "把数据换成网络结果")
            }, modifier = Modifier.padding(bottom = 12.dp)) {
                Text("切换到进阶列表")
            }
        }
        items(currentTasks) { task -> TaskRow(task) }
    }
}

@Composable
private fun TaskRow(task: String) {
    Card(
        modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(modifier = Modifier.padding(16.dp)) {
            Icon(imageVector = Icons.Default.Star, contentDescription = "task")
            Text(text = task, modifier = Modifier.padding(start = 12.dp), fontSize = 18.sp)
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun ComposeLesson04ListPreview() {
    LessonPreviewContainer { ComposeLesson04ListScreen() }
}
