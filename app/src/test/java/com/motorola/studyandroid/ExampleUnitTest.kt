package com.motorola.studyandroid

import com.motorola.studyandroid.lessons.java.JavaBasicsSamples
import com.motorola.studyandroid.lessons.java.JavaStudent
import com.motorola.studyandroid.lessons.shared.LessonCatalog
import com.motorola.studyandroid.lessons.shared.applyTransformation
import com.motorola.studyandroid.lessons.shared.formatProfile
import com.motorola.studyandroid.lessons.shared.multiply
import com.motorola.studyandroid.lessons.shared.nullableDisplayName
import com.motorola.studyandroid.lessons.shared.safeNameLength
import com.motorola.studyandroid.lessons.shared.sumAll
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun lessonCatalog_contains_reconstructed_parts_and_routes() {
        val routes = LessonCatalog.allLessons.map { it.route }

        assertTrue(routes.contains("Kotlin1"))
        assertTrue(routes.contains("Kotlin4"))
        assertTrue(routes.contains("Kotlin7"))
        assertTrue(routes.contains("PreLesson3"))
        assertTrue(routes.contains("PreLesson4"))
        assertTrue(routes.contains("Lesson9"))
        assertTrue(routes.contains("Lesson10"))
        assertEquals("Kotlin1", LessonCatalog.allLessons.first().route)
        assertEquals(4, LessonCatalog.parts.size)
        assertEquals("Part 1：Kotlin 编程基础", LessonCatalog.kotlinVariables.partTitle)
        assertEquals("Part 4：Compose 实战与异步", LessonCatalog.coroutines.partTitle)
        assertEquals(routes.size, routes.distinct().size)
    }

    @Test
    fun java_demo_classes_work_from_kotlin_tests() {
        val student = JavaStudent("测试同学", 18, true)

        assertEquals("测试同学", student.name)
        assertEquals(18, student.age)
        assertTrue(student.isBeginner)
        assertTrue(student.summary().contains("测试同学"))

        assertTrue(JavaBasicsSamples.variableDemo().contains("name=Tom"))
        assertEquals("成年人", JavaBasicsSamples.ifDemo(18))
        assertEquals("未成年人", JavaBasicsSamples.ifDemo(12))
        assertEquals(3, JavaBasicsSamples.forDemo().size)
    }

    @Test
    fun kotlin_function_samples_behave_correctly() {
        assertEquals(42, multiply(6, 7))
        assertEquals("函数学习者，来自 深圳，年龄未填写", formatProfile("函数学习者", city = "深圳"))
        assertEquals(10, sumAll(1, 2, 3, 4))
        assertEquals(30, applyTransformation(15) { it * 2 })
        assertEquals("游客", nullableDisplayName(null))
        assertEquals(0, safeNameLength(null))
    }
}