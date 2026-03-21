package com.motorola.studyandroid.lessons.java;

import java.util.ArrayList;
import java.util.List;

public final class JavaBasicsSamples {
    private JavaBasicsSamples() {
    }

    public static String variableDemo() {
        int age = 18;
        double price = 19.9;
        boolean isVip = true;
        String name = "Tom";

        return "name=" + name + "，age=" + age + "，price=" + price + "，isVip=" + isVip;
    }

    public static String ifDemo(int age) {
        if (age >= 18) {
            return "成年人";
        }
        return "未成年人";
    }

    public static List<String> forDemo() {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            result.add("for 循环第 " + i + " 次");
        }
        return result;
    }

    public static JavaStudent createDemoStudent() {
        return new JavaStudent("Java 初学者", 20, true);
    }
}

