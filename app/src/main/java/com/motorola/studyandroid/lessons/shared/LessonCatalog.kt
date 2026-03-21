package com.motorola.studyandroid.lessons

data class LessonEntry(
    val route: String,
    val title: String,
    val description: String,
    val partTitle: String
)

data class LessonPart(
    val route: String,
    val title: String,
    val description: String,
    val swipeTip: String,
    val lessons: List<LessonEntry>
)

object LessonCatalog {
    const val menuRoute = "Menu"
    const val appTitle = "我的安卓学习大本营"

    val kotlinVariables = LessonEntry(
        route = "Kotlin1",
        title = "Kotlin 第 1 章：变量、val、var",
        description = "通过点击计数 demo 学会 val / var 的区别。",
        partTitle = "Part 1：Kotlin 编程基础"
    )

    val kotlinTypesStrings = LessonEntry(
        route = "Kotlin2",
        title = "Kotlin 第 2 章：类型、字符串模板、Boolean",
        description = "认识 Int、String、Boolean，并把它们显示到界面上。",
        partTitle = "Part 1：Kotlin 编程基础"
    )

    val kotlinFunctionsBasics = LessonEntry(
        route = "Kotlin3",
        title = "Kotlin 第 3 章：函数基础（重点）",
        description = "重点讲解 fun、参数、返回值，并通过输入框真实调用函数。",
        partTitle = "Part 1：Kotlin 编程基础"
    )

    val kotlinFunctionsAdvanced = LessonEntry(
        route = "Kotlin4",
        title = "Kotlin 第 4 章：函数进阶、默认参数、vararg、高阶函数",
        description = "进一步吃透 Kotlin 函数，这也是理解 Compose API 的关键。",
        partTitle = "Part 1：Kotlin 编程基础"
    )

    val kotlinCollections = LessonEntry(
        route = "Kotlin5",
        title = "Kotlin 第 5 章：集合 List、遍历、和函数配合",
        description = "把语言知识连接到真实列表页面。",
        partTitle = "Part 1：Kotlin 编程基础"
    )

    val kotlinNullSafety = LessonEntry(
        route = "Kotlin6",
        title = "Kotlin 第 6 章：空安全 Null Safety",
        description = "用可交互 demo 看懂 String?、?.、?:。",
        partTitle = "Part 1：Kotlin 编程基础"
    )

    val kotlinClasses = LessonEntry(
        route = "Kotlin7",
        title = "Kotlin 第 7 章：类、data class、对象",
        description = "通过创建 KotlinHero 对象理解 class 和 data class。",
        partTitle = "Part 1：Kotlin 编程基础"
    )

    val javaBasics = LessonEntry(
        route = "PreLesson3",
        title = "Java 第 1 章：基础语法 + 真实 Java Demo",
        description = "直接调用 Java 文件学习 class、if、for、new。",
        partTitle = "Part 2：Java 补充与互操作"
    )

    val javaVsKotlin = LessonEntry(
        route = "PreLesson4",
        title = "Java 第 2 章：Java 和 Kotlin 怎么选？",
        description = "通过对照代码理解为什么 Compose 主线用 Kotlin。",
        partTitle = "Part 2：Java 补充与互操作"
    )

    val gettingStarted = LessonEntry(
        route = "Lesson0",
        title = "Compose 第 1 章：先认识 Android 与 Compose",
        description = "搞懂 Activity、setContent、Composable、State。",
        partTitle = "Part 3：Compose 基础与交互"
    )

    val text = LessonEntry(
        route = "Lesson1",
        title = "Compose 第 2 章：Text 文字基础",
        description = "学习怎样把文字显示出来，并修改字号、颜色、粗细。",
        partTitle = "Part 3：Compose 基础与交互"
    )

    val layout = LessonEntry(
        route = "Lesson2",
        title = "Compose 第 3 章：布局 Row / Column / Box",
        description = "学会横着排、竖着排、叠着放，建立页面布局思维。",
        partTitle = "Part 3：Compose 基础与交互"
    )

    val state = LessonEntry(
        route = "Lesson3",
        title = "Compose 第 4 章：状态 State（计数器）",
        description = "理解 remember、mutableStateOf 和重组。",
        partTitle = "Part 3：Compose 基础与交互"
    )

    val list = LessonEntry(
        route = "Lesson4",
        title = "Compose 第 5 章：列表 LazyColumn",
        description = "认识 Compose 里的高性能列表。",
        partTitle = "Part 3：Compose 基础与交互"
    )

    val input = LessonEntry(
        route = "Lesson5",
        title = "Compose 第 6 章：用户输入 TextField",
        description = "接收用户输入并用状态驱动界面变化。",
        partTitle = "Part 3：Compose 基础与交互"
    )

    val pagerAndScroll = LessonEntry(
        route = "Lesson10",
        title = "Compose 第 7 章：横向滚动与分页 HorizontalPager",
        description = "学会横向分页，并看懂首页为什么能左右滑动切换 Part。",
        partTitle = "Part 3：Compose 基础与交互"
    )

    val image = LessonEntry(
        route = "Lesson6",
        title = "实战第 1 章：网络图片 Coil",
        description = "加载网络图片，理解圆角、裁剪、占位和 contentScale。",
        partTitle = "Part 4：Compose 实战与异步"
    )

    val network = LessonEntry(
        route = "Lesson7",
        title = "实战第 2 章：网络请求 Retrofit",
        description = "从接口下载数据，处理加载中、成功、失败三种状态。",
        partTitle = "Part 4：Compose 实战与异步"
    )

    val navigation = LessonEntry(
        route = "Lesson8",
        title = "实战第 3 章：导航基础 Navigation",
        description = "学习 route、NavController、NavHost、navigate 和返回栈。",
        partTitle = "Part 4：Compose 实战与异步"
    )

    val coroutines = LessonEntry(
        route = "Lesson9",
        title = "实战第 4 章：协程 Coroutines 入门",
        description = "从 suspend、launch、delay、LaunchedEffect 开始理解异步任务。",
        partTitle = "Part 4：Compose 实战与异步"
    )

    val parts = listOf(
        LessonPart(
            route = "PartKotlin",
            title = "Part 1：Kotlin 编程基础",
            description = "通过真正可运行的代码，把 Kotlin 从变量一路学到函数、集合、空安全和 data class。",
            swipeTip = "左右滑动就能切换 Part。这个首页本身就是 HorizontalPager 的真实案例。",
            lessons = listOf(
                kotlinVariables,
                kotlinTypesStrings,
                kotlinFunctionsBasics,
                kotlinFunctionsAdvanced,
                kotlinCollections,
                kotlinNullSafety,
                kotlinClasses
            )
        ),
        LessonPart(
            route = "PartJava",
            title = "Part 2：Java 补充与互操作",
            description = "不是死记概念，而是通过真实 Java 文件看懂老 Android 代码，并理解 Kotlin/Java 互调。",
            swipeTip = "这一 Part 建议放在 Kotlin 之后学习，因为你会更容易理解 Java 为什么更啰嗦。",
            lessons = listOf(javaBasics, javaVsKotlin)
        ),
        LessonPart(
            route = "PartCompose",
            title = "Part 3：Compose 基础与交互",
            description = "把语言知识真正落到 Android 界面开发：文字、布局、状态、输入、列表、横向分页。",
            swipeTip = "本 Part 的 Lesson 10 会专门讲你现在正在使用的左右滑动分页。",
            lessons = listOf(gettingStarted, text, layout, state, list, input, pagerAndScroll)
        ),
        LessonPart(
            route = "PartAdvanced",
            title = "Part 4：Compose 实战与异步",
            description = "开始像真实 App 一样思考：图片、网络、导航、协程。",
            swipeTip = "学到这里时，建议你一边读代码，一边自己改参数，观察界面和行为的变化。",
            lessons = listOf(image, network, navigation, coroutines)
        )
    )

    val allLessons = parts.flatMap { it.lessons }

    fun findByRoute(route: String?): LessonEntry? {
        return allLessons.firstOrNull { it.route == route }
    }

    fun findPartByLessonRoute(route: String?): LessonPart? {
        return parts.firstOrNull { part -> part.lessons.any { it.route == route } }
    }
}

