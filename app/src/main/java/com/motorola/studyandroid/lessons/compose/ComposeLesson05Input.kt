package com.motorola.studyandroid.lessons.compose

import com.motorola.studyandroid.lessons.shared.*
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
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
fun ComposeLesson05InputScreen() {
    val sections = listOf(
        LearningSection(
            title = "1. 输入框本质上是界面 + 状态的组合",
            bullets = listOf(
                "value 表示当前显示内容。",
                "onValueChange 表示用户输入后状态怎么更新。",
                "所以输入课其实也是状态课的延伸。"
            ),
            code = "OutlinedTextField(value = name, onValueChange = { name = it })"
        ),
        LearningSection(
            title = "2. 表单通常还要做校验",
            bullets = listOf(
                "真实 App 里常有判空、长度检查、数字格式检查。",
                "因此输入页往往不止一个状态变量。",
                "提交按钮通常会把多个输入一起处理。"
            )
        )
    )

    LessonPage(
        title = "Compose 第 6 章：用户输入 TextField",
        subtitle = "这一课会把输入框为什么能记住用户输入讲清楚，并让你亲手做一个最小表单。"
    ) {
        renderLessonSections(sections)
        item {
            LessonSectionCard(title = "编程实验：填写一个三字段表单并做简单校验") {
                BulletLine("下面这个 demo 同时包含名字、年龄、职业三个输入。")
                BulletLine("点击按钮后，如果输入不完整，会看到校验提示。")
                InputPlayground()
            }
        }
        renderPracticeSection(
            exercises = listOf(
                "把年龄校验改成必须大于 0。",
                "再加一个城市输入框。",
                "把提交成功后的文案改成你自己喜欢的风格。"
            )
        )
    }
}

@Composable
private fun InputPlayground() {
    var name by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }
    var job by remember { mutableStateOf("") }
    var resultText by remember { mutableStateOf("先输入完整信息，再点击提交") }

    Column(modifier = Modifier.fillMaxWidth()) {
        OutlinedTextField(value = name, onValueChange = { name = it }, label = { Text("名字") }, modifier = Modifier.fillMaxWidth())
        OutlinedTextField(value = age, onValueChange = { age = it }, label = { Text("年龄") }, modifier = Modifier.fillMaxWidth().padding(top = 8.dp))
        OutlinedTextField(value = job, onValueChange = { job = it }, label = { Text("职业") }, modifier = Modifier.fillMaxWidth().padding(top = 8.dp))
        Button(onClick = {
            resultText = when {
                name.isBlank() || age.isBlank() || job.isBlank() -> "请把名字、年龄、职业都填写完整。"
                age.toIntOrNull() == null -> "年龄必须是数字。"
                else -> "你好，$name！你今年 $age 岁，当前职业是 $job。"
            }
        }, modifier = Modifier.padding(top = 12.dp)) {
            Text("提交表单")
        }
        Text(text = resultText, style = MaterialTheme.typography.bodyLarge, modifier = Modifier.padding(top = 12.dp))
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun ComposeLesson05InputPreview() {
    LessonPreviewContainer { ComposeLesson05InputScreen() }
}
