package com.motorola.studyandroid.lessons.compose

import com.motorola.studyandroid.lessons.shared.*
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

private val pagerPages = listOf(
    "第一页：Kotlin Part",
    "第二页：Java Part",
    "第三页：Compose Part"
)

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ComposeChapter10PagerAndScrollScreen() {
    val sections = listOf(
        LearningSection(
            title = "1. 横向滚动不止一种实现方式",
            bullets = listOf(
                "单纯让内容横向滑，可以考虑 horizontalScroll。",
                "展示很多横向条目时，通常会用 LazyRow。",
                "当你要切换整页内容时，HorizontalPager 更自然。"
            ),
            code = "Modifier.horizontalScroll(...)\nLazyRow { ... }\nHorizontalPager(state = pagerState) { page -> ... }"
        ),
        LearningSection(
            title = "2. 为什么课程首页适合用 HorizontalPager？",
            bullets = listOf(
                "因为首页切换的是整组课程 Part，不是几张小卡片。",
                "每一页都是完整的学习区域，所以 pager 的语义更合适。",
                "这也是为什么你现在这个项目首页已经用上了 HorizontalPager。"
            )
        ),
        LearningSection(
            title = "3. Pager 常见配套：TabRow + pagerState + 协程",
            bullets = listOf(
                "TabRow 负责显示当前页签。",
                "pagerState 记录当前页。",
                "切换到指定页面时，经常会用协程调用 animateScrollToPage。"
            ),
            code = "val pagerState = rememberPagerState(pageCount = { 3 })\nval scope = rememberCoroutineScope()\nscope.launch { pagerState.animateScrollToPage(1) }"
        )
    )

    LessonPage(
        title = "Compose 第 7 章：横向滚动与分页 HorizontalPager",
        subtitle = "这一课不仅讲知识点，还直接解释你当前项目首页为什么能左右滑动切换学习 Part。学完它，你会更容易读懂项目本身的实现。"
    ) {
        renderLessonSections(sections)

        item {
            LessonSectionCard(title = "编程实验：一个最小可运行的 HorizontalPager") {
                BulletLine("点顶部 Tab 或点按钮，都可以切换页。")
                BulletLine("这个例子和首页横向切换学习 Part 的实现思路是一样的。")
                PagerPlayground()
            }
        }

        renderPracticeSection(
            exercises = listOf(
                "把 pagerPages 再加一页，观察 Tab 和页面数如何一起变化。",
                "把切到下一页按钮改成切到上一页。",
                "试着把某一页背景色改掉，让分页切换更明显。"
            )
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun PagerPlayground() {
    val pagerState = rememberPagerState(pageCount = { pagerPages.size })
    val scope = rememberCoroutineScope()
    val colors = listOf(Color(0xFFE3F2FD), Color(0xFFE8F5E9), Color(0xFFFFF3E0))

    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        TabRow(selectedTabIndex = pagerState.currentPage) {
            pagerPages.forEachIndexed { index, title ->
                Tab(
                    selected = pagerState.currentPage == index,
                    onClick = { scope.launch { pagerState.animateScrollToPage(index) } },
                    text = { Text(title) }
                )
            }
        }

        HorizontalPager(state = pagerState, modifier = Modifier.fillMaxWidth()) { page ->
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .background(colors[page], RoundedCornerShape(16.dp))
                    .padding(16.dp)
            ) {
                Text(text = pagerPages[page], style = MaterialTheme.typography.titleMedium)
                Text(
                    text = "当前页码：$page。继续左右滑动，感受整页切换和普通横向列表的区别。",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(top = 8.dp)
                )
            }
        }

        Button(onClick = {
            scope.launch {
                val nextPage = (pagerState.currentPage + 1) % pagerPages.size
                pagerState.animateScrollToPage(nextPage)
            }
        }) {
            Text("切到下一页")
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun ComposeChapter10PagerAndScrollPreview() {
    LessonPreviewContainer {
        ComposeChapter10PagerAndScrollScreen()
    }
}
