package com.motorola.studyandroid.lessons.java

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.motorola.studyandroid.lessons.shared.*

@Composable
fun JavaChapter3ListScreen() {
    val sections = listOf(
        LearningSection(
            title = "1. 什么是 Java 的 List？",
            bullets = listOf(
                "List 是 Java 中最常用的集合容器之一，通俗点讲就是“动态数组”。",
                "你可以随时往里面加东西 (add)、删东西 (remove)、查长度 (size)。",
                "长度不用一开始就固定好，它在内部会自动扩容。"
            )
        ),
        LearningSection(
            title = "2. 常见的两种 List：ArrayList 和 LinkedList",
            bullets = listOf(
                "ArrayList：用得最多。底层是连续的数组。找第 i 个元素很快 get(i)，但在中间插入元素比较慢。",
                "LinkedList：底层是链表（像火车车厢串着）。在中间频繁插入/删除很快，但找第 i 个元素慢（要从头查过去）。"
            ),
            code = "List<String> list1 = new ArrayList<>();\nList<String> list2 = new LinkedList<>();"
        ),
        LearningSection(
            title = "3. 增删改查怎么写？",
            bullets = listOf(
                "增加：list.add(\"张三\");",
                "删除：list.remove(\"张三\"); 或 list.remove(0);",
                "查询：list.get(0); 获取指定位置元素",
                "大小：list.size(); 获取当前数量",
                "清空：list.clear(); 清空整个列表"
            )
        )
    )

    LessonPage(
        title = "Java 第 3 章：集合之 List",
        subtitle = "这一章我们会通过真实的 Java 文件，了解 Android 开发中最常用来存放列表数据的 ArrayList。"
    ) {
        renderLessonSections(sections)

        item {
            LessonSectionCard(title = "▶ Java List 真实交互演示") {
                BulletLine("我们在底层调用了一个纯 Java 写的 JavaCollectionDemo 类。")
                ListPlayground()
            }
        }

        renderPracticeSection(
            exercises = listOf(
                "尝试点击上面的按钮，观察底层 Java List 如何存储元素。",
                "你能发现如果多次添加相同的名字，List 会怎么处理吗？(提示: List 允许重复)",
                "去看看源码：app/src/.../lessons/java/JavaCollectionDemo.java 感受一下 Java 代码写法。"
            )
        )
    }
}

@Composable
private fun ListPlayground() {
    // 实例化刚刚写的纯 Java 类
    val javaDemo = remember { JavaCollectionDemo() }
    
    // 这里是为了让 Compose 能观测状态变化，我们用 state 包装一下读取结果
    var listContent by remember { mutableStateOf(javaDemo.students.toList()) }
    var listSize by remember { mutableIntStateOf(javaDemo.count) }

    fun refreshState() {
        listContent = javaDemo.students.toList()
        listSize = javaDemo.count
    }

    Column(modifier = Modifier.fillMaxWidth()) {
        Text("当前底层 Java List 内容：$listContent", style = MaterialTheme.typography.bodyLarge)
        Text("当前容量 (size)：$listSize")

        Spacer(modifier = Modifier.height(16.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Button(onClick = { 
                javaDemo.addStudent("新同学 ${listSize + 1}")
                refreshState()
            }) {
                Text("add() 加入同学")
            }

            Button(onClick = { 
                if (listSize > 0) {
                    javaDemo.removeStudent(javaDemo.students.last())
                    refreshState()
                }
            }) {
                Text("remove() 移出最后一个")
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun JavaChapter3Preview() {
    LessonPreviewContainer {
        JavaChapter3ListScreen()
    }
}
