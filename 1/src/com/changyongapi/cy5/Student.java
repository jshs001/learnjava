package com.changyongapi.cy5;

public class Student implements Comparable<Student>{
    private String name;
    private double height;
    private int age;

    public Student() {
    }

    public Student(String name,double height,int age) {
        this.name = name;
        this.height = height;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHeight() {
        return height;
    }
    public int getAge() {
        return age;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    // 指定比较规则 是两两比较 this和 o
    // 返回值：0 表示相等
    // 正数 表示（this大于o） 左边大于右边
    // 负数 表示（this小于o） 左边小于右边
    public int compareTo(Student o) {
//        if (this.age > o.age) {
//            return 1;
//        } else if (this.age < o.age) {
//            return -1;
//        }
//        return 0;
        // return this.age - o.age; // 简化写法 升序
        return o.age - this.age; // 降序

    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", height=" + height +
                ", age=" + age +
                '}';
    }
}
