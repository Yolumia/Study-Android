# Android 学习路线图

这是一个给零基础同学准备的 Jetpack Compose 学习项目。目标不是一下子学会所有 Android 技术，而是先把最常见、最核心的一条学习路线走通。

## 这个项目怎么学最合适？

建议顺序：**Lesson 0 → Lesson 1 → Lesson 2 → Lesson 3 → Lesson 4 → Lesson 5 → Lesson 6 → Lesson 7 → Lesson 8**

原因是：
- Lesson 0 先补齐基础概念，避免你看到 `@Composable`、`Modifier`、`Scaffold` 时一脸懵。
- Lesson 1 ~ 5 先学界面基础和交互。
- Lesson 6 ~ 8 再学真实 App 常见能力：图片、网络、导航。

## 项目结构先认识一下

- **`MainActivity.kt`**
  - App 入口。
  - 负责 `setContent {}`、`Scaffold`、`NavHost` 和页面切换。
- **`lessons/`**
  - 每一课都是一个独立的 Compose 页面。
  - 你可以单独修改某一课，不容易把整个项目改坏。
- **`LessonCatalog.kt`**
  - 统一管理课程标题、路由和简介。
  - 这是一个很实用的项目整理思路：避免 route 字符串到处乱飞。
- **`ui/theme/`**
  - 管理主题、颜色、字体风格。

## 课程清单

### Lesson 0：先认识 Android 与 Compose（补课）
文件：`Lesson0_GettingStarted.kt`
- 什么是 `Activity`
- 什么是 `setContent {}`
- 什么是 `@Composable`
- 什么是 `Modifier`
- 什么是 `Scaffold`
- 什么是 `remember` / `mutableStateOf`
- 什么是 `Preview`、主题、资源目录

### Lesson 1：Text 文字基础
文件：`Lesson1_Text.kt`
- 显示文字
- 修改字号、颜色、粗细

### Lesson 2：布局基础
文件：`Lesson2_Layout.kt`
- `Row`：横向排列
- `Column`：纵向排列
- `Box`：叠层布局

### Lesson 3：State 状态
文件：`Lesson3_State.kt`
- `remember`
- `mutableStateOf`
- 点击按钮后界面为什么会更新

### Lesson 4：列表 LazyColumn
文件：`Lesson4_List.kt`
- 列表头部和底部
- `item {}` 和 `items {}`
- 为什么 LazyColumn 比一次性全部渲染更高效

### Lesson 5：用户输入
文件：`Lesson5_Input.kt`
- `OutlinedTextField`
- 输入内容绑定到状态
- 按钮点击后做简单逻辑处理

### Lesson 6：网络图片
文件：`Lesson6_Image.kt`
- `AsyncImage`
- 圆角裁剪
- 圆形头像
- `contentScale`

### Lesson 7：网络请求
文件：`Lesson7_Network.kt`
- Retrofit 基础用法
- 数据模型 `data class`
- 接口定义 `@GET`
- 加载中 / 成功 / 失败 三种状态

### Lesson 8：导航基础
文件：`Lesson8_Navigation.kt`
- 什么是 route
- `NavController`、`NavHost`、`composable`
- `navigate()` 和 `popBackStack()`
- 返回栈是什么

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

- 把 `Lesson1_Text.kt` 里的颜色改掉。
- 给 `Lesson2_Layout.kt` 多加两个 `Box`。
- 给 `Lesson3_State.kt` 增加“+10”按钮。
- 给 `Lesson5_Input.kt` 增加一个“职业”输入框。
- 在 `LessonCatalog.kt` 新增一门你自己的课程。

学 Android 不怕慢，怕的是“看懂了但没自己改”。每课你都亲手改一点，进步会非常快。

