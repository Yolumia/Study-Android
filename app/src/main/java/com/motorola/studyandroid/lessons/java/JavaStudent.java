package com.motorola.studyandroid.lessons.java;

public class JavaStudent {
    private final String name;
    private final int age;
    private final boolean beginner;

    public JavaStudent(String name, int age, boolean beginner) {
        this.name = name;
        this.age = age;
        this.beginner = beginner;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean isBeginner() {
        return beginner;
    }

    public String summary() {
        return name + "，今年 " + age + " 岁，当前状态：" + (beginner ? "Java 初学者" : "继续进阶中");
    }
}

