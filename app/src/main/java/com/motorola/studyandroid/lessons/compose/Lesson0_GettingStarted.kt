package com.motorola.studyandroid.lessons

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
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

private data class StarterSection(
    val title: String,
    val bullets: List<String>,
    val code: String? = null
)

@Composable
fun Lesson0_GettingStarted() {
    val sections = listOf(
        StarterSection(
            title = "1. 一个 Android Compose 页面是怎么跑起来的？",
            bullets = listOf(
                "应用启动后，系统会先打开 Activity。你项目里的入口就是 MainActivity。",
                "在 MainActivity 的 setContent { ... } 里面，我们开始写 Compose 界面。",
                "你可以把 setContent 理解成：'从这里开始，后面的内容都交给 Compose 来画在屏幕上。'"
            ),
            code = "class MainActivity : ComponentActivity() {\n    override fun onCreate(savedInstanceState: Bundle?) {\n        super.onCreate(savedInstanceState)\n        setContent {\n            Lesson1_Text()\n        }\n    }\n}"
        ),
        StarterSection(
            title = "2. 什么是 @Composable？",
            bullets = listOf(
                "@Composable 表示：这个函数不是拿来做普通计算的，而是拿来描述界面的。",
                "它不会告诉手机 '一步步怎么画'，而是告诉 Compose '这个页面应该长什么样'。",
                "像 Lesson1_Text()、Lesson2_Layout() 都是 Composable 函数。"
            ),
            code = "@Composable\nfun HelloCard() {\n    Text(\"你好，Compose！\")\n}"
        ),
        StarterSection(
            title = "3. Modifier 是什么？为什么几乎每个组件都有它？",
            bullets = listOf(
                "Modifier 就像给组件贴标签：控制大小、间距、背景、点击事件、对齐方式。",
                "Modifier 可以链式写法，从前往后读：先填满宽度，再加背景，再加内边距。",
                "以后你写布局时，很多问题都可以先问自己：'我是不是少了一个 Modifier？'"
            ),
            code = "Text(\n    text = \"我是标题\",\n    modifier = Modifier\n        .padding(16.dp)\n)"
        ),
        StarterSection(
            title = "4. Scaffold、TopAppBar、内容区分别在干嘛？",
            bullets = listOf(
                "Scaffold 是页面骨架：它帮你安排顶部栏、底部栏、浮动按钮和内容区域。",
                "TopAppBar 是顶部标题栏。你现在这个项目已经在 MainActivity 里用了它。",
                "Scaffold 会给内容区一个 innerPadding，避免内容被顶部栏挡住。"
            )
        ),
        StarterSection(
            title = "5. 为什么点击按钮后，界面会自动变化？",
            bullets = listOf(
                "因为 Compose 盯着 State（状态）看。状态一变，界面就会重新计算。",
                "remember { mutableStateOf(...) } 可以让 Compose 记住当前值。",
                "Lesson 3 的计数器就是最经典的 State 示例。"
            ),
            code = "var count by remember { mutableStateOf(0) }\n\nButton(onClick = { count++ }) {\n    Text(\"点击次数：${'$'}count\")\n}"
        ),
        StarterSection(
            title = "6. 什么是重组（Recomposition）？",
            bullets = listOf(
                "重组不是整页都重新创建，而是 Compose 会尽量只更新受影响的那部分 UI。",
                "比如 count 变化后，只依赖 count 的 Text/按钮附近会重新计算。",
                "所以把数据写成状态，是 Compose 高效更新页面的关键。"
            )
        ),
        StarterSection(
            title = "7. Preview、Theme、资源文件分别有什么用？",
            bullets = listOf(
                "Preview 让你不用每次都跑模拟器，也能先看组件长什么样。",
                "Theme 统一控制颜色、字体、圆角风格，让页面更像一个完整 App。",
                "res 文件夹用来放字符串、图片、图标、颜色等资源。以后项目大了，会比把东西都写死在代码里更好维护。"
            )
        ),
        StarterSection(
            title = "8. 你现在这套课程建议怎么学？",
            bullets = listOf(
                "如果你是完全零基础，先进入首页的 Part 1，把 Kotlin 7 章按顺序学完，尤其要认真学函数两章。",
                "然后再学 Part 2 的 Java，两章就够你建立老项目阅读能力。",
                "再看 Lesson 0，搞清 Android 和 Compose 的大地图。",
                "接着进入 Part 3：文字、布局、状态、列表、输入、横向分页。",
                "最后学习 Part 4：图片、网络、导航、协程，开始像一个真正 App 那样思考。",
                "每学完一课，建议你自己改 1~2 个数字或颜色，观察 UI 为什么变化。"
            )
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
                title = "Lesson 0：先认识 Android 与 Compose",
                subtitle = "这一课是补基础。你先别急着背代码，先知道每个文件和每个关键字大概负责什么。"
            )
        }

        items(sections) { section ->
            LessonSectionCard(title = section.title) {
                section.bullets.forEach { BulletLine(it) }
                section.code?.let {
                    CodeBlock(it)
                }
            }
        }

        item {
            LessonSectionCard(title = "课后小练习") {
                BulletLine("打开 Lesson 1，把文字颜色改成你喜欢的颜色。")
                BulletLine("打开 Lesson 3，把初始 count 改成 10，看看界面启动时会发生什么。")
                BulletLine("回到 MainActivity，找到 Scaffold 和 NavHost，尝试说出它们各自的作用。")
            }
        }

        item {
            LessonSectionCard(title = "动手看效果：Compose 页面为什么会自动刷新？") {
                BulletLine("点击按钮后，count 状态发生变化。")
                BulletLine("因为 Text 依赖了 count，所以 Compose 会自动重新计算这块 UI。")
                BulletLine("这就是你后面学习 State、输入框、网络加载时的核心思想。")
                ComposeStateMiniDemo()
            }
        }
    }
}

@Composable
private fun ComposeStateMiniDemo() {
    var count by remember { mutableIntStateOf(0) }

    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "当前 count = $count",
            style = MaterialTheme.typography.titleMedium
        )
        Text(
            text = "你每点一次按钮，状态就更新一次，界面也会自动跟着变。",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(top = 8.dp)
        )
        Button(
            onClick = { count++ },
            modifier = Modifier.padding(top = 12.dp)
        ) {
            Text("点我 +1")
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun Lesson0GettingStartedPreview() {
    LessonPreviewContainer {
        Lesson0_GettingStarted()
    }
}

