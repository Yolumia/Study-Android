package com.motorola.studyandroid.lessons

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest

@Composable
fun Lesson6_Image() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Lesson 6: 网络图片 (Coil)", fontSize = 24.sp)
        
        Spacer(modifier = Modifier.height(32.dp))

        Text("1. 基本用法 (加载一张风景图)")
        Spacer(modifier = Modifier.height(8.dp))
        
        // AsyncImage 是 Coil 提供的核心组件
        // model: 图片的 URL 地址
        // contentDescription: 给盲人读屏软件用的描述
        AsyncImage(
            model = "https://himg.bdimg.com/sys/portrait/item/public.1.555f8a99.3wEprjAsVjt3PxXcdOOxKw.jpg?_d=29568347", // 这是一个随机图片 API
            contentDescription = "Random Landscape",
            modifier = Modifier
                .size(300.dp, 200.dp)
                .clip(RoundedCornerShape(16.dp)) // 给图片切圆角
        )

        Spacer(modifier = Modifier.height(32.dp))

        Text("2. 圆形头像 (Crop and Circle)")
        Spacer(modifier = Modifier.height(8.dp))

        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data("https://himg.bdimg.com/sys/portrait/item/public.1.555f8a99.3wEprjAsVjt3PxXcdOOxKw.jpg?_d=29568347")
                .crossfade(true) // 开启淡入淡出动画
                .build(),
            contentDescription = "Avatar",
            contentScale = ContentScale.Crop, // 裁剪模式：保持比例填满
            modifier = Modifier
                .size(120.dp)
                .clip(CircleShape) // 切成圆形
        )
    }
}

