package com.gjjs.hello;

import com.gjjs.gjjs2.Demo;
import com.gjjs.gjjs2.MyTest;
import com.gjjs.gjjs2.MyTest4;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class gjjs2 {
    public static void main(String[] args) throws Exception {
        System.out.println("1 注解");
        // 注解： 就是java代码里的特殊标记，比如：@Override @Test等 作用是:让其他程序根据注解信息来决定怎么执行该程序
        // 注意： 注解可以用在类上、构造器上、方法上、成员变量上、参数上、等位置处

        // 自定义注解：就是自己定义注解
        // public @interface 注解名称 {
        //    public 属性类型 属性名() default 默认值;
        //}

        // 特殊属性名： value
        // 如果注解中只有一个value属性，或者其他属性有默认值，使用注解时，value名称可以不屑

        // 注解的本质是接口，java中所有注解都继承了Annotation接口
        // @注解(...):其实就是一个实现类对象，实现了该注解以及Annotation接口

        System.out.println();
        System.out.println("2 元注解");
        // 元注解：修饰注解的注解
        // @Retention: 注解的保留策略 3个元素：源码级别、类级别、运行时级别
        // @Target: 注解的使用范围 类、成员方法、成员变量、参数、构造器、局部变量
        // @Documented: 注解是否生成文档
        // @Inherited: 注解是否继承

        // test.java里有注解和元注解的测试

        System.out.println();
        System.out.println("3 注解的解析");
        // 注解的解析：判断类上、方法上、成员变量上是否存在注解，并把注解里的内容给解析出来

        // 如何解析注解：
        // 指导思想：要解析谁上面的注解，就应该先拿到谁
        // 比如要解析类上面的注解，则应该先获取该类的Class对象，再通过Class对象解析其上面的注解
        // 比如要解析成员方法上面的注解，则应该先获取该方法的Method对象，再通过Method对象解析其上面的注解
        // Class Method Field Constructor 都实现了AnnotatedElement接口 它们都拥有解析注解的能力


        // 注解解析见Demo.java ,MyTest4 注解

        Class c =Demo.class;
        Method m = c.getDeclaredMethod("test1");

        if(c.isAnnotationPresent(MyTest4.class)) {  // isAnnotationPresent 判断类上是否存在某个注解
            MyTest4 myTest4  = (MyTest4)c.getDeclaredAnnotation(MyTest4.class);
            System.out.println(myTest4.value());
            System.out.println(myTest4.aaa());
            System.out.println(Arrays.toString(myTest4.bbb()));
        }
        System.out.println();
        if(m.isAnnotationPresent(MyTest4.class)) {  // isAnnotationPresent 判断类上是否存在某个注解
            MyTest4 myTest4  = (MyTest4)m.getDeclaredAnnotation(MyTest4.class);
            System.out.println(myTest4.value());
            System.out.println(myTest4.aaa());
            System.out.println(Arrays.toString(myTest4.bbb()));
        }

        System.out.println();
        System.out.println("4 注解的应用场景");
        // 其实就是配合反射来做应用框架的
        Class c1 = gjjs2.class; // 获取类的Class对象
        Method[] methods = c1.getDeclaredMethods(); // 获取所有方法

        gjjs2 gjjs2 = new gjjs2();

        for(Method method:methods) {
            if(method.isAnnotationPresent(MyTest.class)) { // 当前方法是否存在MyTest注解
                method.invoke(gjjs2); // 执行方法
            }
        }

        // 注解就是标记某个程序 然后让其他程序根据注解信息来做相应的处理


    }
    // 模拟Junit框架
    // 定义若干个方法，只要加了 MyTest注解 就会触发该方法执行
    // @MyTest
    public static void test1() {
        System.out.println("======test1======");
    }

    @MyTest
    public static void test2() {
        System.out.println("======test2======");
    }

    // @MyTest
    public static void test3() {
        System.out.println("======test3======");
    }

    @MyTest
    public static void test4() {
        System.out.println("======test4======");
    }









}
