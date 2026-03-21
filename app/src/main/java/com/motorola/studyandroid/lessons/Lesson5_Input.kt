package com.motorola.studyandroid.lessons

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Lesson5_Input() {
    // 状态: 存储用户输入的文字
    var name by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }
    // 状态: 存储显示在屏幕上的问候语
    var greetingText by remember { mutableStateOf("请输入名字并点击按钮") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Lesson 5: 用户输入", fontSize = 24.sp)
        
        Spacer(modifier = Modifier.height(32.dp))

        // 输入框 (TextField)
        // value: 当前显示在框里的文字 (通常绑定到 state)
        // onValueChange: 当用户打字时触发，用来更新 state
        OutlinedTextField(
            value = name,
            onValueChange = { newText -> 
                name = newText 
            },
            label = { Text("你的名字") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = age,
            onValueChange = { newText ->
                age = newText
            },
            label = { Text("你的年龄") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))


        Button(
            onClick = {
                if (name.isNotBlank() && age.isNotBlank()) {
                    greetingText = "你好, $name！你今年 $age 岁了。"
                } else {
                    greetingText = "请输入完整的信息！"
                }

            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("发送问候")
        }

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = greetingText,
            fontSize = 20.sp,
            color = androidx.compose.material3.MaterialTheme.colorScheme.primary
        )
    }
}

