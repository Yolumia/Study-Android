package com.motorola.studyandroid.lessons

import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

private data class NavigationSection(
    val title: String,
    val bullets: List<String>,
    val code: String? = null
)

@Composable
fun Lesson8_Navigation(onNavigate: (String) -> Unit) {
    val sections = listOf(
        NavigationSection(
            title = "1. 什么叫导航（Navigation）？",
            bullets = listOf(
                "导航就是：从一个页面去另一个页面，再决定能不能返回。",
                "小 App 也许只切 2~3 个页面，大一点的 App 会有首页、详情页、设置页、登录页。",
                "你现在这个项目的课程菜单 → 某一课，本质上就是导航。"
            )
        ),
        NavigationSection(
            title = "2. route 是什么？",
            bullets = listOf(
                "route 可以理解成页面的唯一名字，也像页面的身份证。",
                "例如 Menu、Lesson1、Lesson8 都是 route。",
                "只要 route 不重复，NavController 才知道你要去哪里。"
            ),
            code = "composable(\"Lesson1\") {\n    Lesson1_Text()\n}"
        ),
        NavigationSection(
            title = "3. NavController、NavHost、composable 三件套",
            bullets = listOf(
                "NavController：负责发出跳转命令，像导航的大脑。",
                "NavHost：负责承载页面，像一个页面容器。",
                "composable(route) { ... }：负责注册每个页面应该显示什么内容。"
            ),
            code = "val navController = rememberNavController()\n\nNavHost(navController = navController, startDestination = \"Menu\") {\n    composable(\"Menu\") { LessonsMenu(...) }\n    composable(\"Lesson1\") { Lesson1_Text() }\n}"
        ),
        NavigationSection(
            title = "4. navigate 和 popBackStack 分别做什么？",
            bullets = listOf(
                "navigate(route) = 前进到一个新页面。",
                "popBackStack() = 返回上一个页面。",
                "如果你连续 navigate 很多次，返回栈会一层一层累积起来。"
            ),
            code = "navController.navigate(\"Lesson5\")\nnavController.popBackStack()"
        ),
        NavigationSection(
            title = "5. 新手最容易踩的坑",
            bullets = listOf(
                "route 名字拼错：比如写成 Lesson-1，结果注册的是 Lesson1。",
                "页面没注册到 NavHost：即使你写了函数，也不能直接跳过去。",
                "跳转逻辑分散在很多地方：项目大了以后，最好把 route 集中管理，所以我已经帮你加了 LessonCatalog。"
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
                title = "Lesson 8：导航基础 Navigation",
                subtitle = "这一课你要明白：页面跳转并不神秘，本质就是给 NavController 一个 route，然后由 NavHost 展示对应页面。"
            )
        }

        items(sections) { section ->
            LessonSectionCard(title = section.title) {
                section.bullets.forEach { BulletLine(it) }
                section.code?.let { CodeBlock(it) }
            }
        }

        item {
            LessonSectionCard(title = "马上练习：点按钮体验跳转") {
                Text(
                    text = "下面几个按钮会直接调用项目里的导航逻辑。你可以反复点，感受“从菜单进入课程”和“从课程再去另一个课程”的区别。",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(bottom = 12.dp)
                )

                Button(
                    onClick = { onNavigate(LessonCatalog.text.route) },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("跳到 Lesson 1：看看最简单的文字页面")
                }

                Button(
                    onClick = { onNavigate(LessonCatalog.input.route) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp)
                ) {
                    Text("跳到 Lesson 5：看看输入框如何工作")
                }

                Button(
                    onClick = { onNavigate(LessonCatalog.menuRoute) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp)
                ) {
                    Text("回到课程目录")
                }
            }
        }

        item {
            LessonSectionCard(title = "课后小练习") {
                BulletLine("试着在 LessonCatalog 里新增一个 route，看你是否能顺利在 NavHost 注册并从菜单跳过去。")
                BulletLine("想一想：为什么页面跳转最好不要直接把字符串到处复制，而要集中管理？")
                BulletLine("观察顶部栏的返回按钮：它为什么只在离开菜单后出现？")
            }
        }
    }
}

