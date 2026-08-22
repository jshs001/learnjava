package com.itheima1.gaoji6;

public class Outer1 {
    private int age;
    public static int a;

    // 静态内部类
    public static class Inner1 {
        private String name;
        public static int a;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void test() {
            System.out.println(Outer1.a);
            // System.out.println(age);
            // 像静态方法无法访问对象的属性一样，静态内部类无法直接访问外部类的实例属性。需要通过对象访问。
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
