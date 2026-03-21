package com.motorola.studyandroid.lessons

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Lesson4_List() {
    // 模拟一些数据: 创建一个包含 50 个字符串的列表
    val itemsList = List(50) { index -> "列表项Item #$index" }

    // LazyColumn: 相当于以前的 RecyclerView 或 ListView
    // 它的神奇之处在于：它只会渲染屏幕上**可见**的项目。
    // 如果你有 10000 个项目，它也只处理你看到的这几个，非常高效。
    LazyColumn(
        modifier = Modifier
            .fillMaxSize() // 占满整个父容器
            .padding(16.dp)
    ) {
        // 1. item { ... }: 用来添加单个不需要循环的组件，比如标题
        item {
            Text(
                text = "这是列表头部 (Header)",
                fontSize = 24.sp,
                modifier = Modifier.padding(bottom = 16.dp)
            )
        }

        // 2. items(...) { ... }: 用来遍历列表数据
        // 它会自动为 itemsList 中的每一个元素生成一个 ListItemView
        items(itemsList) { itemData ->
            ListItemView(text = itemData)
        }
        
        // 3. 也可以再添加底部的单个组件
         item {
            Text(
                text = "这是列表底部 (Footer)",
                fontSize = 18.sp,
                modifier = Modifier.padding(top = 16.dp)
            )
        }
    }
}

@Composable
fun ListItemView(text: String) {
    // Card 卡片组件，自带一点阴影和圆角，很好看
    Card(
        modifier = Modifier
            .fillMaxWidth() // 宽度填满
            .padding(vertical = 4.dp), // 上下留一点空隙
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Row(modifier = Modifier.padding(0.dp)) {
            Icon(
                imageVector = androidx.compose.material.icons.Icons.Default.Star,
                contentDescription = "Star Icon",
                modifier = Modifier.padding(16.dp)
            )

            Text(
            text = text,
            modifier = Modifier.padding(16.dp), // 文字内部留白
            fontSize = 18.sp
        ) }

    }
}

