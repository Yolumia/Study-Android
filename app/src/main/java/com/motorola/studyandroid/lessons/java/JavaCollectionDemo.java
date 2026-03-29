package com.motorola.studyandroid.lessons.java;

import java.util.ArrayList;
import java.util.List;

public class JavaCollectionDemo {
    private List<String> studentList;

    public JavaCollectionDemo() {
        // 大多时候我们用 ArrayList（基于数组，查找快）
        // List 是接口，ArrayList 是具体实现
        studentList = new ArrayList<>();
    }

    public void addStudent(String name) {
        studentList.add(name);
    }

    public void removeStudent(String name) {
        studentList.remove(name);
    }

    public List<String> getStudents() {
        return studentList;
    }

    public int getCount() {
        return studentList.size();
    }

    public String getFirst() {
        if (studentList.isEmpty()) {
            return "空";
        }
        return studentList.get(0);
    }
}
