package com.changyongapi.cy7;

import com.changyongapi.cy5.Student;

public class CompareByData {
    public static int compareByAge(Student o1, Student o2) {
        return o1.getAge() - o2.getAge();
    }
    public int compareByAge1(Student o1, Student o2) {
        return o2.getAge() - o1.getAge();
    }
}
