package com.motorola.studyandroid.lessons

data class KotlinHero(
    val name: String,
    val level: Int,
    val title: String
)

fun formatGreeting(name: String, score: Int = 0): String {
    return "你好，$name！当前积分：$score"
}

fun multiply(a: Int, b: Int): Int {
    return a * b
}

fun expressionSubtract(a: Int, b: Int): Int = a - b

fun formatProfile(name: String, city: String = "未知城市", age: Int? = null): String {
    val ageText = age?.toString() ?: "年龄未填写"
    return "$name，来自 $city，$ageText"
}

fun sumAll(vararg values: Int): Int {
    return values.sum()
}

fun applyTransformation(value: Int, transform: (Int) -> Int): Int {
    return transform(value)
}

fun createHero(name: String, level: Int): KotlinHero {
    val title = if (level >= 10) "进阶开发者" else "起步开发者"
    return KotlinHero(name = name, level = level, title = title)
}

fun buildTaskSummary(tasks: List<String>): String {
    return tasks.joinToString(separator = "、")
}

fun nullableDisplayName(name: String?): String {
    return name ?: "游客"
}

fun safeNameLength(name: String?): Int {
    return name?.length ?: 0
}

