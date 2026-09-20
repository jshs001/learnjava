package com.gjjs.hello;

import com.gjjs.gjjs1.Cat;
import com.gjjs.gjjs1.ObjectFrame;
import com.gjjs.gjjs1.Student;
import com.gjjs.gjjs1.Teacher;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class gjjs1 {
    public static void main(String[] args) throws Exception {
        System.out.println("1 反射");
        // 反射：就是加载类，并允许以编程的方式解剖类中的各种成分（成员变量、方法、构造器等）
        // 如idea中 Student s1 = new Student(); 后下一行 s1. 可以看到所有成员方法、成员变量等

        // 1 反射的第一步：加载类，获取类的字节码：Class对象
        // 2 获取类的构造器：Constructor对象
        // 3 获取类的方法：Method对象
        // 4 获取类的成员变量：Field对象

        System.out.println();
        System.out.println("2 获取Class对象的三种方式");

        // 获取Class对象的三种方式
        // 1 Class c1 = 类名.Class
        // 2 调用Class提供方法：public static Class forName(String package);
        // 3 Object提供的方法：public Class getClass(); Class c3 = 对象.getClass();

        Class c1 = Student.class;
        System.out.println(c1.getName());  // 全类名（包名+类名）
        System.out.println(c1.getSimpleName()); // 简名（类名）

        Class c2 = Class.forName("com.gjjs.gjjs1.Student");
        System.out.println(c1 == c2);

        Student s = new Student();
        Class c3 = s.getClass();
        System.out.println(c1 == c3);



        System.out.println();
        System.out.println("3 获取类的构造器");
        Class c4 = Cat.class;

        // Constructor[] constructors = c4.getConstructors(); // 获取所有构造器 只能拿public修饰的构造器
        Constructor[] constructors = c4.getDeclaredConstructors(); // 获取所有构造器 存在就能拿到
        for (Constructor constructor : constructors) {
            System.out.println(constructor.getName() + "--->" + constructor.getParameterCount());
        }

        Constructor constructor = c4.getDeclaredConstructor(); // 获取某个构造器 有就能拿到
        System.out.println(constructor.getName() + "--->" + constructor.getParameterCount());

        Constructor constructor1 = c4.getConstructor(String.class, int.class); // 获取某个构造器 只能拿到public修饰的构造器
        System.out.println(constructor1.getName() + "--->" + constructor1.getParameterCount());

        System.out.println();
        // 获取类的构造器 作用：
        // Cat cat = constructor.newInstance(); // 返回是一个object类型 所以这里报错

        Constructor<Cat> constructor2 = c4.getDeclaredConstructor(); // 这里用泛型
        constructor2.setAccessible(true); // 禁止检查访问控制 从而强制使用private构造器
        Cat cat = constructor2.newInstance(); // 这里就不报错了
        System.out.println(cat);

        Constructor<Cat>  constructor3 = c4.getConstructor(String.class, int.class);
        Cat cat1 = constructor3.newInstance("tom", 1);
        System.out.println(cat1);


        System.out.println();
        System.out.println("4 获取类的成员变量");
        Class c5 = Cat.class;

        // Field[] fields = c5.getFields(); // 获取所有成员变量 只能拿public修饰的成员变量
        Field[] fields = c5.getDeclaredFields(); // 获取所有成员变量 存在就能拿到
        for (Field field : fields) {
            System.out.println(field.getName() + "--->" + field.getType());
        }

        // Field field1 = c5.getField("a"); // 获取某个成员变量 只能拿public修饰的成员变量
        Field fname = c5.getDeclaredField("name"); // 获取某个成员变量 存在就能拿到
        System.out.println(fname.getName() + "--->" + fname.getType());

        System.out.println();
        // 获取类的成员变量 作用：
        // field.setAccessible(true); // 禁止检查访问控制 从而强制使用private成员变量 进行赋值
        // field.set(s, "tom"); // 设置成员变量的值
        // System.out.println(field.get(s)); // 获取成员变量的值

        Cat cat2 = new Cat("tom1", 1);
        System.out.println(cat2);
        fname.setAccessible(true);
        fname.set(cat2, "cafe");
        System.out.println(fname.get(cat2));

        System.out.println();
        System.out.println("5 获取类的方法");
        Class c6 = Cat.class;

        // Method[] methods = c6.getMethods(); // 获取所有方法 只能拿public修饰的方法
        Method[] methods = c6.getDeclaredMethods(); // 获取所有方法 存在就能拿到
        for (Method method : methods) {
            System.out.println(method.getName() + "--->" + method.getParameterCount() + "--->" + method.getReturnType());
        }

        System.out.println();
        // Method method = c6.getMethod("eat"); // 获取某个方法 只能拿public修饰的方法
        Method method = c6.getDeclaredMethod("eat", String.class); // 获取某个方法 存在就能拿到
        System.out.println(method.getName() + "--->" + method.getParameterCount() + "--->" + method.getReturnType());

        System.out.println();

        // 获取类的方法 作用：
        // method.setAccessible(true); // 禁止检查访问控制 从而强制使用private方法进行调用
        // method.invoke(s); // 调用方法

        Cat cat3 = new Cat("tt", 1);
        method.setAccessible(true);
        System.out.println(method.invoke(cat3, "fish"));

        System.out.println();
        System.out.println("6 反射的作用和场景");
        // 反射的作用：
        //      基本作用 可以得到一个类的全部成分 然后操作
        //      破坏封装性
        //      最重要的用途是 适合做框架开发 基本上 主流的框架都会基于反射设计出一些通用的功能

        // 案例：对于任意一个对象，该框架都可以把对象的字段名和对应的值 保存到文件中去
        Student stu = new Student("黑马吴彦祖", 45, '男', 1.75, "学习");
        Teacher tea = new Teacher("张三", 5000);

        ObjectFrame.saveObject(stu);
        ObjectFrame.saveObject(tea);















    }
}
