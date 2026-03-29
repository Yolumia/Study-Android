package com.motorola.studyandroid.lessons.kotlin

import com.motorola.studyandroid.lessons.shared.*
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun KotlinChapter3_FunctionsBasics() {
    val sections = listOf(
        LearningSection(
            title = "1. 函数到底是什么？",
            bullets = listOf(
                "函数就是把一段逻辑起名字。这样你以后想重复使用时，直接调用它就行。",
                "函数有三个核心：函数名、参数、返回值。",
                "你以后写 Compose 页面时，@Composable fun Xxx() 本质上也还是函数。"
            ),
            code = "fun add(a: Int, b: Int): Int {\n    return a + b\n}"
        ),
        LearningSection(
            title = "2. 参数像输入口，返回值像输出口",
            bullets = listOf(
                "a、b 就是参数：函数需要外部把值传进来。",
                "Int 是返回值类型：表示函数最后会交出一个 Int。",
                "如果一个函数只做事情、不返回结果，返回类型可以是 Unit。"
            ),
            code = "fun sayHello(name: String) {\n    println(\"Hello ${'$'}name\")\n}\n\nfun multiply(a: Int, b: Int): Int {\n    return a * b\n}"
        ),
        LearningSection(
            title = "3. 表达式函数让短函数更简洁",
            bullets = listOf(
                "如果函数只有一行返回结果，可以写成 = 的形式。",
                "这在 Kotlin 里很常见。",
                "但新手阶段只要先会普通写法，就已经很好了。"
            ),
            code = "fun subtract(a: Int, b: Int): Int = a - b"
        ),
        LearningSection(
            title = "4. 为什么函数对 Android 开发特别重要？",
            bullets = listOf(
                "按钮点击后要做的逻辑，最好封装成函数。",
                "列表格式化、用户名显示、价格计算，也经常封装成函数。",
                "这样页面代码会更清晰，不会所有逻辑都堆在 onClick 里。"
            )
        ),
        LearningSection(
            title = "5. 函数作为『一等公民』：四大函数类型",
            bullets = listOf(
                "在 Kotlin 中，函数可以直接当成变量传递，这叫函数类型 (Function Type)。",
                "① 普通函数类型：如 (Int, Int) -> Int，表示接收两个 Int，返回一个 Int。",
                "② 带接收者的函数类型：如 String.() -> Int，调用时可以像扩展函数一样用 this。",
                "③ 挂起函数类型：如 suspend () -> Unit，专用于协程，处理网络请求等耗时任务。",
                "④ 可空函数类型：如 ((Int) -> Unit)?，表示这个回调函数可以不传（是 null）。"
            ),
            code = "val myAdd: (Int, Int) -> Int = { x, y -> x + y }\nval onClick: (() -> Unit)? = null"
        )
    )

    LessonPage(
        title = "Kotlin 第 3 章：函数基础（重点）",
        subtitle = "这一章非常重要。你要开始真正理解：函数不是抽象概念，而是你以后组织业务逻辑的最基础单位。"
    ) {
        renderLessonSections(sections)

        item {
            LessonSectionCard(title = "编程实验：自己给函数传参，观察返回值") {
                BulletLine("下面这个实验会把两个输入框里的数字传给函数。")
                BulletLine("按钮点击后，你会看到 multiply() 和 expressionSubtract() 的返回结果。")
                FunctionBasicsPlayground()
            }
        }

        renderPracticeSection(
            exercises = listOf(
                "自己新增一个 divide(a, b) 函数，并在页面上显示结果。",
                "把 subtract 的结果文案改得更清楚一点。",
                "试着说出：参数和返回值分别在这个 demo 里扮演什么角色。"
            )
        )
    }
}

@Composable
private fun FunctionBasicsPlayground() {
    var firstText by remember { mutableStateOf("6") }
    var secondText by remember { mutableStateOf("3") }
    var resultText by remember { mutableStateOf("先输入两个数字，再点击按钮") }

    Column(modifier = Modifier.fillMaxWidth()) {
        OutlinedTextField(
            value = firstText,
            onValueChange = { firstText = it },
            label = { Text("第一个数字") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = secondText,
            onValueChange = { secondText = it },
            label = { Text("第二个数字") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
        )
        Button(
            onClick = {
                val first = firstText.toIntOrNull() ?: 0
                val second = secondText.toIntOrNull() ?: 0
                val multiplyResult = multiply(first, second)
                val subtractResult = expressionSubtract(first, second)
                resultText = "multiply($first, $second) = $multiplyResult；subtract($first, $second) = $subtractResult"
            },
            modifier = Modifier.padding(top = 12.dp)
        ) {
            Text("调用函数计算")
        }
        Text(
            text = resultText,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(top = 12.dp)
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun KotlinChapter3Preview() {
    LessonPreviewContainer {
        KotlinChapter3_FunctionsBasics()
    }
}
