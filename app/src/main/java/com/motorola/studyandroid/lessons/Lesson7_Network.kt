package com.motorola.studyandroid.lessons

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


// 1. 数据模型 (Data Model)
// 这就是我们要从网上下载的数据格式
// URL: https://jsonplaceholder.typicode.com/posts
data class Post(
    val id: Int,
    val title: String,
    val body: String
)

// 2. API 接口 (API Interface)
// 告诉 Retrofit 怎么去请求数据
interface JsonPlaceholderApi {
    @GET("posts") // 这里对应的是 https://jsonplaceholder.typicode.com/posts
    suspend fun getPosts(): List<Post>
}

// 3. 创建 Retrofit 实例 (通常应该放在专门的类里，这里为了简单直接写)
object RetrofitClient {
    private const val BASE_URL = "https://jsonplaceholder.typicode.com/"

    val api: JsonPlaceholderApi by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()) // 自动把 JSON 转换成 Post 对象
            .build()
            .create(JsonPlaceholderApi::class.java)
    }
}

@Composable
fun Lesson7_Network() {
    // 状态：存储下载到的文章列表
    var posts by remember { mutableStateOf<List<Post>>(emptyList()) }
    // 状态：是否正在加载中
    var isLoading by remember { mutableStateOf(true) }
    // 状态：如果出错，显示的错误信息
    var errorMessage by remember { mutableStateOf<String?>(null) }

    // 协程作用域：用来在后台运行网络请求，不卡住主线程
    val scope = rememberCoroutineScope()

    // LaunchedEffect: 当组件第一次显示时，自动执行里面的代码
    LaunchedEffect(Unit) {
        scope.launch {
            try {
                // 开始请求数据
                // 必须在 IO 线程进行网络请求
                val downloadedPosts = withContext(Dispatchers.IO) {
                    RetrofitClient.api.getPosts()
                }
                posts = downloadedPosts
                Log.d("Lesson7_Network", "posts: $posts")
                isLoading = false
            } catch (e: Exception) {
                errorMessage = "加载失败: ${e.message}"
                isLoading = false
            }
        }
    }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Lesson 7: 网络请求 (Retrofit)", fontSize = 24.sp, modifier = Modifier.padding(bottom = 16.dp))

        if (isLoading) {
            // 显示转圈圈
            CircularProgressIndicator(modifier = Modifier.align(Alignment.CenterHorizontally))
        } else if (errorMessage != null) {
            // 显示错误信息
            Text(text = errorMessage!!, color = androidx.compose.ui.graphics.Color.Red)
        } else {
            // 显示列表
            LazyColumn {
                items(posts) { post ->
                    Card(
                        modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
                        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Text(text = post.title, fontSize = 18.sp, fontWeight = androidx.compose.ui.text.font.FontWeight.Bold)
                            Text(text = post.body, fontSize = 14.sp, maxLines = 2)
                        }
                    }
                }
            }
        }
    }
}

