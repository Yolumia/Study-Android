package com.motorola.studyandroid.lessons.compose

import com.motorola.studyandroid.lessons.shared.*
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest

private const val DemoImageUrl = "https://himg.bdimg.com/sys/portrait/item/public.1.555f8a99.3wEprjAsVjt3PxXcdOOxKw.jpg?_d=29568347"

@Composable
fun ComposeLesson06ImageScreen() {
    val sections = listOf(
        LearningSection(
            title = "1. 网络图片通常需要专门库来加载",
            bullets = listOf(
                "因为图片来自网络，不是本地资源。",
                "加载时还要考虑缓存、失败、动画等问题。",
                "Coil 已经把这些常见工作封装好了。"
            ),
            code = "AsyncImage(model = imageUrl, contentDescription = \"avatar\")"
        ),
        LearningSection(
            title = "2. contentScale 会影响图片显示方式",
            bullets = listOf(
                "Crop：裁剪填满，常见于头像、封面。",
                "Fit：完整显示，尽量不裁剪。",
                "同一张图在不同 contentScale 下，视觉效果会不一样。"
            )
        )
    )

    LessonPage(
        title = "实战第 1 章：网络图片 Coil",
        subtitle = "这一课不只是把图片显示出来，而是让你理解图片的加载、裁剪和显示形态为什么在真实 App 里这么重要。"
    ) {
        renderLessonSections(sections)
        item {
            LessonSectionCard(title = "编程实验：一键切换圆角图和圆形头像") {
                BulletLine("点击按钮后，会在封面图和头像图之间切换。")
                BulletLine("观察 clip 和 contentScale 一起工作时，图片效果如何变化。")
                ImagePlayground()
            }
        }
        renderPracticeSection(
            exercises = listOf(
                "把圆角半径改大一点。",
                "尝试把 contentScale 从 Crop 改成 Fit。",
                "给图片外层再包一层 Card。"
            )
        )
    }
}

@Composable
private fun ImagePlayground() {
    var isAvatarMode by remember { mutableStateOf(false) }
    val modifier = if (isAvatarMode) Modifier.size(140.dp).clip(CircleShape) else Modifier.size(280.dp, 180.dp).clip(RoundedCornerShape(16.dp))

    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()) {
        Text(text = if (isAvatarMode) "当前模式：圆形头像" else "当前模式：圆角封面图", style = MaterialTheme.typography.titleMedium, modifier = Modifier.padding(bottom = 12.dp))
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current).data(DemoImageUrl).crossfade(true).build(),
            contentDescription = if (isAvatarMode) "Avatar" else "Cover",
            contentScale = ContentScale.Crop,
            modifier = modifier
        )
        Button(onClick = { isAvatarMode = !isAvatarMode }, modifier = Modifier.padding(top = 12.dp)) {
            Text(if (isAvatarMode) "切换成圆角封面图" else "切换成圆形头像")
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun ComposeLesson06ImagePreview() {
    LessonPreviewContainer { ComposeLesson06ImageScreen() }
}
