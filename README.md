# Android 学习路线图

这个项目已经重构成一个**通过编程互动来学习**的 Jetpack Compose 教学 App，而不是单纯在手机上看一堆说明文字。

核心设计目标：

- **Part 化学习**：Kotlin → Java → Compose → 实战
- **首页可左右滑动**：用 `HorizontalPager` 横向切换不同学习 Part
- **知识点通过代码演示**：每一章尽量都有可运行 demo
- **重点强化 Kotlin 函数**：单独拆成多章讲解
- **项目本身也成为教材**：比如首页的横向分页，自己就是一节 Compose 课程案例

## 推荐学习顺序

建议按首页的 Part 顺序学习：

1. **Part 1：Kotlin 编程基础**
2. **Part 2：Java 补充与互操作**
3. **Part 3：Compose 基础与交互**
4. **Part 4：Compose 实战与异步**

这样学的原因是：

- 先把 Kotlin 语言打牢，尤其是函数
- 再补 Java，帮助你看懂旧 Android 代码
- 然后进入 Compose 基础，把语言知识真正用到界面里
- 最后学习网络、导航、协程等真实开发问题

## 现在课程是怎么分 Part 的？

### Part 1：Kotlin 编程基础
目标：先把 Kotlin 真正学懂，尤其是函数。不要只会看变量定义，要会自己写逻辑。

- `KotlinChapter1_Variables.kt`
- `KotlinChapter2_TypesAndStrings.kt`
- `KotlinChapter3_FunctionsBasics.kt`
- `KotlinChapter4_FunctionsAdvanced.kt`
- `KotlinChapter5_Collections.kt`
- `KotlinChapter6_NullSafety.kt`
- `KotlinChapter7_Classes.kt`

### Part 2：Java 补充与互操作
目标：让你能看懂老 Android 代码，并理解 Kotlin/Java 在一个项目里如何共存。

- `PreLesson3_JavaBasics.kt`
- `PreLesson4_JavaVsKotlin.kt`

### Part 3：Compose 基础与交互
目标：搞懂页面怎么写、为什么会自动刷新、为什么首页可以左右滑动切换 Part。

- `Lesson0_GettingStarted.kt`
- `Lesson1_Text.kt`
- `Lesson2_Layout.kt`
- `Lesson3_State.kt`
- `Lesson4_List.kt`
- `Lesson5_Input.kt`
- `Lesson10_PagerAndScroll.kt`

### Part 4：Compose 实战与异步
目标：开始像真实 App 一样思考页面、异步任务和页面跳转。

- `Lesson6_Image.kt`
- `Lesson7_Network.kt`
- `Lesson8_Navigation.kt`
- `Lesson9_Coroutines.kt`

## 这个项目现在是怎么“通过编程教学”的？

每一章尽量都有这几层：

1. **少量必要概念**：告诉你这个知识点是什么
2. **代码块**：告诉你真实写法长什么样
3. **可运行 demo**：让你直接点按钮、输入数据、看结果变化
4. **Preview**：方便在 IDE 里快速看效果

也就是说：

- Kotlin 函数不是只讲定义，而是让你真的调用函数
- Java 基础不是只讲名词，而是直接调用 `.java` 文件
- HorizontalPager 不是只讲 API，而是首页本身就在用

## 为什么 Kotlin 要拆这么细？

因为很多零基础同学不是被 Android 吓住，而是先被 Kotlin 语法卡住。

- 尤其是 **函数**，是 Compose、点击事件、状态处理、列表处理的底层基础。
- 如果函数没学懂，后面 `onClick`、`LaunchedEffect`、高阶函数、lambda 都会越来越吃力。

所以现在 Kotlin 被拆成了 7 章，函数单独用了两章来讲。

## 项目结构先认识一下

- **`MainActivity.kt`**
  - App 入口。
  - 负责 `setContent {}`、`Scaffold`、`NavHost` 和页面切换。
- **`lessons/`**
  - 每一课都是一个独立的 Compose 页面。
  - 现在已经按 Kotlin / Java / Compose / 实战 四个 Part 组织。
  - 目录层级也已经重构成：`lessons/kotlin/`、`lessons/java/`、`lessons/compose/`、`lessons/shared/`。
  - 你可以单独修改某一课，不容易把整个项目改坏。
- **`lessons/shared/LessonCatalog.kt`**
  - 统一管理课程标题、路由、Part 分组和学习顺序。
  - 这是一个很实用的项目整理思路：避免 route 字符串到处乱飞。
- **`lessons/shared/LessonsMenu.kt`**
  - 现在已经不是普通列表页，而是一个 `HorizontalPager` 首页。
  - 你可以把它本身当作学习分页组件的真实案例。
- **`ui/theme/`**
  - 管理主题、颜色、字体风格。

## 课程清单

### Part 1：Kotlin 编程基础

#### Kotlin 第 1 章：变量、val、var
文件：`lessons/kotlin/KotlinChapter1_Variables.kt`
- `val` 和 `var`
- 点击计数 demo
- 带 `Compose Preview`

#### Kotlin 第 2 章：类型、字符串模板、Boolean
文件：`lessons/kotlin/KotlinChapter2_TypesAndStrings.kt`
- Int / String / Boolean
- 字符串模板
- 条件显示
- 可切换会员状态 demo
- 带 `Compose Preview`

#### Kotlin 第 3 章：函数基础（重点）
文件：`lessons/kotlin/KotlinChapter3_FunctionsBasics.kt`
- `fun`
- 参数
- 返回值
- 表达式函数
- 输入框调用函数 demo
- 带 `Compose Preview`

#### Kotlin 第 4 章：函数进阶、默认参数、vararg、高阶函数
文件：`lessons/kotlin/KotlinChapter4_FunctionsAdvanced.kt`
- 默认参数
- 命名参数
- `vararg`
- 高阶函数
- 按钮切换不同函数逻辑 demo
- 带 `Compose Preview`

#### Kotlin 第 5 章：集合 List、遍历、和函数配合
文件：`lessons/kotlin/KotlinChapter5_Collections.kt`
- `List`
- `for`
- `forEach`
- 函数处理列表
- 动态任务列表 demo
- 带 `Compose Preview`

#### Kotlin 第 6 章：空安全 Null Safety
文件：`lessons/kotlin/KotlinChapter6_NullSafety.kt`
- `String` 和 `String?`
- `?.`
- `?:`
- null / 默认值可视化 demo
- 带 `Compose Preview`

#### Kotlin 第 7 章：类、data class、对象
文件：`lessons/kotlin/KotlinChapter7_Classes.kt`
- `class`
- `data class`
- 函数返回对象
- 角色升级 demo
- 带 `Compose Preview`

### Part 2：Java 补充与互操作

#### Java 第 1 章：基础语法 + 真实 Java Demo
文件：`lessons/java/PreLesson3_JavaBasics.kt`
- 真实 Java 示例文件：`lessons/java/JavaStudent.java`、`lessons/java/JavaBasicsSamples.java`
- Java 变量和常见类型
- 方法和类
- `if` / `for`
- `new` 创建对象
- 带一个真实 Java class / method / if / for 的实际演示
- 带 `Compose Preview`

#### Java 第 2 章：Java 和 Kotlin 怎么选？
文件：`lessons/java/PreLesson4_JavaVsKotlin.kt`
- 为什么 Android 新项目优先 Kotlin
- Java 和 Kotlin 常见语法对照
- 作为零基础该怎么安排语言学习顺序
- 带 Java / Kotlin 对照代码块
- 带 `Compose Preview`

### Part 3：Compose 基础与交互

#### Lesson 0：先认识 Android 与 Compose（补课）
文件：`lessons/compose/Lesson0_GettingStarted.kt`
- 什么是 `Activity`
- 什么是 `setContent {}`
- 什么是 `@Composable`
- 什么是 `Modifier`
- 什么是 `Scaffold`
- 什么是 `remember` / `mutableStateOf`
- 什么是 `Preview`、主题、资源目录
- 带一个最小 State 互动示例
- 带 `Compose Preview`

#### Lesson 1：Text 文字基础
文件：`lessons/compose/Lesson1_Text.kt`
- 显示文字
- 修改字号、颜色、粗细

#### Lesson 2：布局基础
文件：`lessons/compose/Lesson2_Layout.kt`
- `Row`：横向排列
- `Column`：纵向排列
- `Box`：叠层布局

#### Lesson 3：State 状态
文件：`lessons/compose/Lesson3_State.kt`
- `remember`
- `mutableStateOf`
- 点击按钮后界面为什么会更新

#### Lesson 4：列表 LazyColumn
文件：`lessons/compose/Lesson4_List.kt`
- 列表头部和底部
- `item {}` 和 `items {}`
- 为什么 LazyColumn 比一次性全部渲染更高效

#### Compose 第 6 章：用户输入
文件：`lessons/compose/Lesson5_Input.kt`
- `OutlinedTextField`
- 输入内容绑定到状态
- 按钮点击后做简单逻辑处理

#### Compose 第 7 章：横向滚动与分页
文件：`lessons/compose/Lesson10_PagerAndScroll.kt`
- `horizontalScroll`
- `LazyRow`
- `HorizontalPager`
- 首页为什么适合用 `HorizontalPager`
- 最小分页 demo
- 带 `Compose Preview`

### Part 4：Compose 实战与异步

#### Lesson 6：网络图片
文件：`lessons/compose/Lesson6_Image.kt`
- `AsyncImage`
- 圆角裁剪
- 圆形头像
- `contentScale`

#### Lesson 7：网络请求
文件：`lessons/compose/Lesson7_Network.kt`
- Retrofit 基础用法
- 数据模型 `data class`
- 接口定义 `@GET`
- 加载中 / 成功 / 失败 三种状态

#### Lesson 8：导航基础
文件：`lessons/compose/Lesson8_Navigation.kt`
- 什么是 route
- `NavController`、`NavHost`、`composable`
- `navigate()` 和 `popBackStack()`
- 返回栈是什么

#### Lesson 9：协程 Coroutines 入门
文件：`lessons/compose/Lesson9_Coroutines.kt`
- 为什么 UI 线程不能被耗时任务堵住
- `suspend`
- `launch`
- `delay`
- `LaunchedEffect` 和 `rememberCoroutineScope`
- 带一个 1 秒后更新界面的协程 Demo
- 带 `Compose Preview`

## 这次重构最重要的变化

如果你是零基础，请重点记住这 3 件事：

1. **Kotlin 不再只讲一点点，而是拆成完整章节了**
2. **函数现在是重点中的重点，已经拆成两章并配了真实 demo**
3. **首页本身就是 HorizontalPager 教材，你不是在看目录，而是在看可运行的 Compose 示例**

## 学习时你要重点盯住的 5 个词

1. **Composable**：声明界面的函数
2. **Modifier**：控制大小、间距、背景、点击等行为
3. **State**：决定界面显示什么的数据
4. **Navigation**：页面切换
5. **Theme**：统一页面风格

## 每学完一课，建议你做这 3 件事

1. 改一个颜色 / 数字 / 文案，观察页面变化。
2. 自己用中文解释一遍：这一课到底在解决什么问题？
3. 想一下：如果我要把这个能力放进真实 App，会用在哪？

## 推荐的小练习

- 给 `lessons/kotlin/KotlinChapter1_Variables.kt` 里的变量名改一个你自己的名字。
- 给 `lessons/kotlin/KotlinChapter6_NullSafety.kt` 自己再写一个 `?:` 默认值例子。
- 对照 `PreLesson3_JavaBasics.kt`，试着把一段 Java 变量声明翻成 Kotlin。
- 打开 `lessons/compose/Lesson9_Coroutines.kt`，把 `delay(1000)` 改成 `delay(3000)`。
- 把 `lessons/compose/Lesson1_Text.kt` 里的颜色改掉。
- 给 `lessons/compose/Lesson2_Layout.kt` 多加两个 `Box`。
- 给 `lessons/compose/Lesson3_State.kt` 增加“+10”按钮。
- 给 `lessons/compose/Lesson5_Input.kt` 增加一个“职业”输入框。
- 在 `lessons/shared/LessonCatalog.kt` 新增一门你自己的课程。

学 Android 不怕慢，怕的是“看懂了但没自己改”。每课你都亲手改一点，进步会非常快。

