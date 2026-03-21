package com.motorola.studyandroid.lessons

data class LessonEntry(
    val route: String,
    val title: String,
    val description: String
)

object LessonCatalog {
    const val menuRoute = "Menu"
    const val appTitle = "我的安卓学习大本营"

    val gettingStarted = LessonEntry(
        route = "Lesson0",
        title = "Lesson 0：先认识 Android 与 Compose",
        description = "补课专用：搞懂 Activity、setContent、@Composable、Modifier、Scaffold、State、Preview。"
    )

    val text = LessonEntry(
        route = "Lesson1",
        title = "Lesson 1：文字 Text 基础",
        description = "学习怎样把文字显示出来，并修改字号、颜色、粗细。"
    )

    val layout = LessonEntry(
        route = "Lesson2",
        title = "Lesson 2：布局 Row / Column / Box",
        description = "学会横着排、竖着排、叠着放，建立页面布局思维。"
    )

    val state = LessonEntry(
        route = "Lesson3",
        title = "Lesson 3：状态 State（计数器）",
        description = "理解 remember、mutableStateOf 和为什么界面会自动刷新。"
    )

    val list = LessonEntry(
        route = "Lesson4",
        title = "Lesson 4：列表 LazyColumn",
        description = "认识 Compose 里的高性能列表，以及 item / items 的区别。"
    )

    val input = LessonEntry(
        route = "Lesson5",
        title = "Lesson 5：用户输入 TextField",
        description = "接收用户输入、点击按钮处理数据、做简单校验。"
    )

    val image = LessonEntry(
        route = "Lesson6",
        title = "Lesson 6：网络图片 Coil",
        description = "加载网络图片，理解圆角、裁剪、占位和 contentScale。"
    )

    val network = LessonEntry(
        route = "Lesson7",
        title = "Lesson 7：网络请求 Retrofit",
        description = "从接口下载数据，处理加载中、成功、失败三种状态。"
    )

    val navigation = LessonEntry(
        route = "Lesson8",
        title = "Lesson 8：导航基础 Navigation",
        description = "学习 route、NavController、NavHost、navigate 和返回栈。"
    )

    val allLessons = listOf(
        gettingStarted,
        text,
        layout,
        state,
        list,
        input,
        image,
        network,
        navigation
    )

    fun findByRoute(route: String?): LessonEntry? {
        return allLessons.firstOrNull { it.route == route }
    }
}

