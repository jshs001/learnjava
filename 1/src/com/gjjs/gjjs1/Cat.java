package com.gjjs.gjjs1;

public class Cat {

    public static int a;
    public static final String COUNTRY = "China";

    private String name;
    private int age;

    private Cat() {
        System.out.println("Cat的无参构造器执行了");
    }

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private void run() {
        System.out.println("Cat在跑");
    }

    public void eat() {
        System.out.println("Cat在吃");
    }

    private String eat(String name) {
        return "Cat在吃" + name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
