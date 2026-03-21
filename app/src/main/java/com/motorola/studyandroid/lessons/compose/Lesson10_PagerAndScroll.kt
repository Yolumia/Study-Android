package com.motorola.studyandroid.lessons

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
fun Lesson10_PagerAndScroll() {
    val sections = listOf(
        LearningSection(
            title = "1. 横向滚动不等于只有一种实现",
            bullets = listOf(
                "如果你只是让一排内容能左右滚动，可以用 horizontalScroll。",
                "如果你要显示很多横向列表项，通常会用 LazyRow。",
                "如果你要做“整页切换”的学习 Part，HorizontalPager 更合适。"
            ),
            code = "Modifier.horizontalScroll(...)\nLazyRow { ... }\nHorizontalPager(state = pagerState) { page -> ... }"
        ),
        LearningSection(
            title = "2. 为什么首页适合 HorizontalPager？",
            bullets = listOf(
                "因为首页不是在横向摆一堆小卡片，而是在切换“整组课程”。",
                "每个 Part 都像一个完整页面，所以 pager 的语义更自然。",
                "这也是为什么你现在的课程首页已经改成了左右滑动切 Part。"
            )
        ),
        LearningSection(
            title = "3. Pager 最常见的配套元素",
            bullets = listOf(
                "pagerState：记录当前是第几页。",
                "TabRow：显示顶部页签，让用户可以点选切换。",
                "CoroutineScope：因为滚动到指定页通常要在协程里调用 scrollToPage / animateScrollToPage。"
            ),
            code = "val pagerState = rememberPagerState(pageCount = { 3 })\nval scope = rememberCoroutineScope()\n\nscope.launch {\n    pagerState.animateScrollToPage(1)\n}"
        )
    )

    LessonPage(
        title = "Lesson 10：横向滚动与分页 HorizontalPager",
        subtitle = "这节课不仅讲知识点，还直接解释你当前项目首页为什么能左右滑动切换学习 Part。学完这节课，你就能看懂项目本身的一部分实现。"
    ) {
        renderLessonSections(sections)

        item {
            LessonSectionCard(title = "编程实验：一个最小可运行的 HorizontalPager") {
                BulletLine("点顶部 Tab 或点按钮，都可以切换页。")
                BulletLine("这个例子和首页“横向切换学习 Part”的实现思路是一样的。")
                PagerPlayground()
            }
        }
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
                    onClick = {
                        scope.launch { pagerState.animateScrollToPage(index) }
                    },
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
                    text = "当前页码：$page。试着继续左右滑动，感受整页切换和 LazyRow 的区别。",
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
private fun Lesson10PagerPreview() {
    LessonPreviewContainer {
        Lesson10_PagerAndScroll()
    }
}

