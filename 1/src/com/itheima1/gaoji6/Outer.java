package com.itheima1.gaoji6;

public class Outer {
    private int age;
    public static String name;

    // 成员内部类
    public class Inner {
        private String name;
        private int age;
        public static String schoolName; // JDK16开始支持定义静态成员

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public void setName(String name) {
            this.name = name;
        }

        // 静态变量访问
        public void test() {
            System.out.println("Inner test");
            System.out.println(Outer.this.age);
            System.out.println(Outer.name);
            System.out.println(Outer.Inner.schoolName);
            System.out.println(Inner.schoolName);
        }

        // 成员变量访问
        public void show() {
            System.out.println("Outer show age:" + Outer.this.age);
            System.out.println("Inner show age:" + this.age);
            int age = 2;
            System.out.println("jubu show age:" + age);

        }
    }

    public void test() {
        System.out.println("Outer test");
        System.out.println(age);
        System.out.println(name);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
