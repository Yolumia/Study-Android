package com.motorola.studyandroid.lessons

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
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
fun Lesson3_State() {
    // 状态 (State): 让界面"动"起来的关键
    // count 是我们要改变的变量。
    // remember { mutableStateOf(0) } 的意思是：
    // 1. mutableStateOf(0): 创建一个初始值为 0 的可变状态。
    // 2. remember: 让 Compose 记住这个变量，即使界面刷新（重组）也不会丢失它的值。
    var count by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally // 让内容水平居中
    ) {
        Text(text = "简单的计数器 (Counter)", fontSize = 24.sp)

        Spacer(modifier = Modifier.height(32.dp)) //甚至可以用 Spacer 来占位

        // 显示当前的状态值
        // 当 count 发生变化时，这个 Text 会自动更新！
        Text(text = "当前点击次数: $count", fontSize = 30.sp)

        Spacer(modifier = Modifier.height(32.dp))

        // 按钮 1：点击增加
        Button(onClick = { count++ }) {
            Text(text = "点我 +1")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // 按钮 2：点击减少
        Button(onClick = { count-- }) {
            Text(text = "点我 -1")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // 按钮 3：点击重置
        Button(onClick = { count = 0 }) {
            Text(text = "重置为 0")
        }


    }
}

