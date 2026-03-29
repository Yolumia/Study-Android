package com.motorola.studyandroid.lessons.java

import com.motorola.studyandroid.lessons.shared.*
import com.motorola.studyandroid.lessons.java.JavaBasicsSamples
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

private data class JavaBasicsSection(
    val title: String,
    val bullets: List<String>,
    val code: String? = null
)

@Composable
fun JavaLesson01BasicsScreen() {
    val sections = listOf(
        JavaBasicsSection(
            title = "1. 为什么还要学一点 Java？",
            bullets = listOf(
                "虽然现在 Android 主推 Kotlin，但很多旧项目、面试题、历史教程还是会用 Java。",
                "学一点 Java，可以帮助你看懂老代码，也能更容易理解 Kotlin 为什么更省事。",
                "你不用一开始就学得很深，先掌握最常见的基础语法就够了。"
            )
        ),
        JavaBasicsSection(
            title = "2. Java 里的变量和类型",
            bullets = listOf(
                "Java 变量写法通常更完整，要把类型写在前面。",
                "和 Kotlin 一样，也有 int、double、boolean、String 这些常见类型。",
                "Java 语法看起来更“啰嗦”，但逻辑上并不难。"
            ),
            code = "int age = 18;\ndouble price = 19.9;\nboolean isVip = true;\nString name = \"Tom\";"
        ),
        JavaBasicsSection(
            title = "3. Java 方法和类",
            bullets = listOf(
                "方法就是 Java 里的函数。",
                "类是把数据和行为组织在一起的模板。",
                "Android 传统开发里，经常会见到 Activity、Adapter、Model 这些类。",
                "这一课下面的演示，已经改成直接调用真实的 Java 文件：`JavaStudent.java`。"
            ),
            code = "public class JavaStudent {\n    private final String name;\n    private final int age;\n\n    public JavaStudent(String name, int age, boolean beginner) {\n        this.name = name;\n        this.age = age;\n    }\n\n    public String getName() {\n        return name;\n    }\n\n    public String summary() {\n        return name + \"，今年 \" + age + \" 岁\";\n    }\n}"
        ),
        JavaBasicsSection(
            title = "4. if、for、对象创建",
            bullets = listOf(
                "控制流程和 Kotlin 很像，只是写法略不同。",
                "Java 里创建对象通常要写 new。",
                "你以后看老 Android 教程时会非常常见。",
                "这一课下面的页面，也会直接显示真实 Java `if` 和 `for` 示例运行后的结果。"
            ),
            code = "public static String ifDemo(int age) {\n    if (age >= 18) {\n        return \"成年人\";\n    }\n    return \"未成年人\";\n}\n\npublic static List<String> forDemo() {\n    List<String> result = new ArrayList<>();\n    for (int i = 0; i < 3; i++) {\n        result.add(\"for 循环第 \" + i + \" 次\");\n    }\n    return result;\n}"
        ),
        JavaBasicsSection(
            title = "5. 先建立 Java 和 Kotlin 的对应关系",
            bullets = listOf(
                "Java 的 public class，大致对应 Kotlin 的 class。",
                "Java 的方法 method，大致对应 Kotlin 的 fun。",
                "Java 的 getter / setter 很多场景在 Kotlin 里会被简化。"
            )
        )
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        contentPadding = PaddingValues(vertical = 16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        item {
            LessonHeader(
                title = "预备课 3：Java 基础语法",
                subtitle = "这节课的目标不是把 Java 学得很深，而是让你以后看到老 Android 代码时不会发怵。"
            )
        }

        items(sections) { section ->
            LessonSectionCard(title = section.title) {
                section.bullets.forEach { BulletLine(it) }
                section.code?.let { CodeBlock(it) }
            }
        }

        item {
            LessonSectionCard(title = "课后小练习") {
                BulletLine("对照 Kotlin，试着看懂上面的 Java class 和 method。")
                BulletLine("自己写一段 Java 变量声明，包含 int、boolean、String。")
                BulletLine("记住一个核心感受：Java 能做的事，Kotlin 通常能写得更简洁。")
            }
        }

        item {
            LessonSectionCard(title = "动手看效果：把 Java 概念翻译成实际页面") {
                BulletLine("这次不是 Kotlin 假装 Java，而是真的调用 `JavaStudent.java` 和 `JavaBasicsSamples.java`。")
                BulletLine("你现在屏幕上看到的数据，来自真实 Java class、真实 Java method、真实 Java for/if 代码。")
                JavaObjectDemo()
            }
        }
    }
}

@Composable
private fun JavaObjectDemo() {
    val student = JavaBasicsSamples.createDemoStudent()
    val variableResult = JavaBasicsSamples.variableDemo()
    val adultResult = JavaBasicsSamples.ifDemo(student.age)
    val loopResults = JavaBasicsSamples.forDemo()

    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "对象名：student（来自 JavaStudent.java）",
            style = MaterialTheme.typography.titleMedium
        )
        Text(
            text = "字段 field：name = ${student.name}",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(top = 8.dp)
        )
        Text(
            text = "字段 field：age = ${student.age}",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(top = 4.dp)
        )
        Text(
            text = "字段 field：beginner = ${student.isBeginner}",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(top = 4.dp)
        )
        Text(
            text = "方法 method：summary() -> ${student.summary()}",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(top = 8.dp)
        )
        Text(
            text = "Java 变量 demo：$variableResult",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(top = 8.dp)
        )
        Text(
            text = "Java if demo：$adultResult",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(top = 8.dp)
        )
        for (line in loopResults) {
            Text(
                text = "Java for demo：$line",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(top = 4.dp)
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun PreLesson3JavaBasicsPreview() {
    LessonPreviewContainer {
        JavaLesson01BasicsScreen()
    }
}

