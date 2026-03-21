package com.motorola.studyandroid.lessons.compose

import com.motorola.studyandroid.lessons.shared.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

private data class CoroutineSection(
    val title: String,
    val bullets: List<String>,
    val code: String? = null
)

@Composable
fun ComposeLesson09CoroutinesScreen() {
    val sections = listOf(
        CoroutineSection(
            title = "1. 为什么要学协程？",
            bullets = listOf(
                "因为手机界面线程很宝贵，不能被耗时任务堵住。",
                "像网络请求、数据库读取、文件下载，都不应该直接卡在主线程上。",
                "协程可以帮你把“要等一会儿的事情”优雅地放到合适的位置处理。"
            )
        ),
        CoroutineSection(
            title = "2. suspend 可以理解成“这个函数会等一下”",
            bullets = listOf(
                "suspend 函数不能乱调用，通常需要在协程作用域里启动。",
                "它很适合表示：我要去做一个可能耗时的动作。",
                "Retrofit 的接口方法经常就是 suspend。"
            ),
            code = "suspend fun loadUserName(): String {\n    delay(1000)\n    return \"小白用户\"\n}"
        ),
        CoroutineSection(
            title = "3. launch 是“开一个协程去做事”",
            bullets = listOf(
                "launch 常用来启动一个不会直接返回结果的任务。",
                "在 Compose 页面里，经常配合 rememberCoroutineScope() 使用。",
                "如果只是想点击按钮后去做一个异步任务，launch 很常见。"
            ),
            code = "val scope = rememberCoroutineScope()\nscope.launch {\n    val name = loadUserName()\n}"
        ),
        CoroutineSection(
            title = "4. delay 和 Thread.sleep 的区别",
            bullets = listOf(
                "delay 是协程友好的“等待”，不会粗暴卡死整个线程。",
                "Thread.sleep 会让线程真停住，新手在 Android 页面逻辑里尽量不要这样用。",
                "所以你看到协程示例时，大多会用 delay。"
            )
        ),
        CoroutineSection(
            title = "5. Compose 里最常见的两个协程入口",
            bullets = listOf(
                "LaunchedEffect：页面第一次出现时自动执行某些异步逻辑。",
                "rememberCoroutineScope：适合按钮点击后再启动任务。",
                "Lesson 7 网络请求里，你已经见过 LaunchedEffect。"
            ),
            code = "LaunchedEffect(Unit) {\n    // 页面一出现就执行\n}\n\nval scope = rememberCoroutineScope()\nButton(onClick = {\n    scope.launch {\n        // 点击按钮后执行\n    }\n}) { ... }"
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
                title = "Lesson 9：协程 Coroutines 入门",
                subtitle = "这节课会把协程讲成“页面不卡顿的工具”。你不用一开始背很多术语，先知道为什么要异步、怎么在 Compose 里启动任务。"
            )
        }

        items(sections) { section ->
            LessonSectionCard(title = section.title) {
                section.bullets.forEach { BulletLine(it) }
                section.code?.let { CodeBlock(it) }
            }
        }

        item {
            LessonSectionCard(title = "动手看效果：按钮点击后，1 秒后再更新界面") {
                BulletLine("点击按钮后，界面先显示“加载中...”。")
                BulletLine("协程会等待 1 秒，再把结果更新到页面。")
                BulletLine("整个过程页面不会被卡死，这就是协程存在的意义。")
                CoroutineDemoCard()
            }
        }

        item {
            LessonSectionCard(title = "课后小练习") {
                BulletLine("把 delay(1000) 改成 delay(2000)，观察等待时间变化。")
                BulletLine("想一想：为什么网络请求不能直接在按钮 onClick 里同步执行？")
                BulletLine("回头再看 Lesson 7，找出那里哪里用到了协程思维。")
            }
        }
    }
}

@Composable
private fun CoroutineDemoCard() {
    val scope = rememberCoroutineScope()
    var status by remember { mutableStateOf("还没有开始加载") }

    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = status,
            style = MaterialTheme.typography.titleMedium
        )
        Button(
            onClick = {
                scope.launch {
                    status = "加载中... 请等 1 秒"
                    status = fakeLoadGreeting()
                }
            },
            modifier = Modifier.padding(top = 12.dp)
        ) {
            Text("启动一个协程")
        }
    }
}

private suspend fun fakeLoadGreeting(): String {
    delay(1000)
    return "加载完成：你好，协程世界！"
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun Lesson9CoroutinesPreview() {
    LessonPreviewContainer {
        ComposeLesson09CoroutinesScreen()
    }
}

