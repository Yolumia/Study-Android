package com.motorola.studyandroid.lessons.compose

import com.motorola.studyandroid.lessons.shared.*
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

data class Post(
    val id: Int,
    val title: String,
    val body: String
)

interface JsonPlaceholderApi {
    @GET("posts")
    suspend fun getPosts(): List<Post>
}

object RetrofitClient {
    private const val BASE_URL = "https://jsonplaceholder.typicode.com/"

    val api: JsonPlaceholderApi by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(JsonPlaceholderApi::class.java)
    }
}

@Composable
fun ComposeLesson07NetworkScreen() {
    var posts by remember { mutableStateOf<List<Post>>(emptyList()) }
    var isLoading by remember { mutableStateOf(true) }
    var errorMessage by remember { mutableStateOf<String?>(null) }
    val scope = rememberCoroutineScope()

    fun loadPosts() {
        scope.launch {
            isLoading = true
            errorMessage = null
            try {
                posts = withContext(Dispatchers.IO) { RetrofitClient.api.getPosts() }
            } catch (e: Exception) {
                errorMessage = "加载失败：${e.message}"
            } finally {
                isLoading = false
            }
        }
    }

    LaunchedEffect(Unit) {
        loadPosts()
    }

    val sections = listOf(
        LearningSection(
            title = "1. 网络课的核心不是 Retrofit 语法，而是状态流转",
            bullets = listOf(
                "请求开始时：isLoading = true。",
                "请求成功时：posts 有数据。",
                "请求失败时：errorMessage 有内容。",
                "所以网络页面通常至少要管理加载中、成功、失败三种状态。"
            ),
            code = "var isLoading by remember { mutableStateOf(true) }\nvar posts by remember { mutableStateOf<List<Post>>(emptyList()) }\nvar errorMessage by remember { mutableStateOf<String?>(null) }"
        ),
        LearningSection(
            title = "2. Retrofit 接口为什么经常写成 suspend？",
            bullets = listOf(
                "因为网络请求是耗时操作，不应该堵住主线程。",
                "suspend 表示这个函数需要在协程环境里调用。",
                "这也是为什么网络课和协程课会天然连在一起。"
            ),
            code = "interface JsonPlaceholderApi {\n    @GET(\"posts\")\n    suspend fun getPosts(): List<Post>\n}"
        ),
        LearningSection(
            title = "3. 页面上要把数据状态翻译成 UI",
            bullets = listOf(
                "isLoading 为 true 时，显示进度条。",
                "errorMessage 不为空时，显示错误文案。",
                "都不是时，就渲染列表。",
                "这正是状态驱动界面的又一个真实场景。"
            )
        )
    )

    LessonPage(
        title = "实战第 2 章：网络请求 Retrofit",
        subtitle = "这一课会把 Kotlin、协程、状态、列表串起来。网络请求不是单独的知识点，而是它们的综合应用。"
    ) {
        renderLessonSections(sections)

        item {
            LessonSectionCard(title = "编程实验：重新加载网络数据") {
                BulletLine("你可以反复点击按钮，观察加载中、成功、失败三种状态如何切换。")
                BulletLine("这个 demo 就是最小的真实网络页面雏形。")
                NetworkPlayground(
                    posts = posts,
                    isLoading = isLoading,
                    errorMessage = errorMessage,
                    onReload = ::loadPosts
                )
            }
        }

        renderPracticeSection(
            exercises = listOf(
                "把列表只显示前 5 条，看看界面会怎么变化。",
                "给错误状态加一个更友好的提示文案。",
                "尝试把加载按钮文案改成重新请求接口。"
            )
        )
    }
}

@Composable
private fun NetworkPlayground(
    posts: List<Post>,
    isLoading: Boolean,
    errorMessage: String?,
    onReload: () -> Unit
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Button(onClick = onReload, modifier = Modifier.padding(bottom = 12.dp)) {
            Text("重新加载网络数据")
        }

        when {
            isLoading -> {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.CenterHorizontally))
            }

            errorMessage != null -> {
                Text(text = errorMessage, color = Color.Red)
            }

            else -> {
                LazyColumn {
                    items(posts.take(8)) { post ->
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 4.dp),
                            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                        ) {
                            Column(modifier = Modifier.padding(16.dp)) {
                                Text(text = post.title, fontWeight = FontWeight.Bold)
                                Text(
                                    text = post.body,
                                    style = MaterialTheme.typography.bodyMedium,
                                    modifier = Modifier.padding(top = 8.dp)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun ComposeLesson07NetworkPreview() {
    LessonPreviewContainer {
        LessonPage(
            title = "实战第 2 章：网络请求 Retrofit",
            subtitle = "Preview 中使用假数据来模拟成功状态。"
        ) {
            item {
                LessonSectionCard(title = "Preview：成功状态示例") {
                    NetworkPlayground(
                        posts = listOf(
                            Post(1, "示例标题 1", "这是 Preview 里的假数据，用来让你在 IDE 中预览网络页面结构。"),
                            Post(2, "示例标题 2", "真实运行时，这些内容会来自接口。")
                        ),
                        isLoading = false,
                        errorMessage = null,
                        onReload = {}
                    )
                }
            }
        }
    }
}
