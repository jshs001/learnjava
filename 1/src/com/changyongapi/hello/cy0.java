package com.changyongapi.hello;

import com.changyongapi.cy0.Student;
import com.changyongapi.cy0.User;

import java.util.ArrayList;
import java.util.Objects;

public class cy0 {
    public static void main(String[] args) throws CloneNotSupportedException {
        System.out.println("1 object类");
        // api： java帮忙写好的程序 如类 方法等，我们直接用。
        // javaapi文档里 我们也就主要用用java.base模块

        // Object类:是java中最顶层的类，所有类都继承自Object类，因此java中所有类的对象都可以直接使用Object类中定义的方法
        Student s1 = new Student("张三", 18);

        // Object类的toString方法默认返回对象地址
        // 在Student类中重写Object类的toString方法 以便返回对象的内容
        System.out.println(s1.toString());
        System.out.println(s1); // 这里打印s1和打印s1.toString()效果一样

        // Object类的equals方法默认比较对象地址
        // 在Student类中重写Object类的equals方法 以便比较对象的内容
        Student s2 = new Student("张三", 18);
        System.out.println(s1.equals(s2));
        System.out.println(s1 == s2); // 比较对象地址 用==即可 所以最好重写equals方法比较对象内容

        // tostring存在的意义:就是为了被子类重写，以便返回对象具体的内容。
        // equals存在的意义:直接比较两个对象的地址是否相同完全可以用“==”替代equals，equals存在就是为了被子类重写，以便子类自己来定制比较规则(比如比较对象内容)。

        // Object类的clone方法必须在子类中重写（因为有权限修饰符）且继承Cloneable接口才能使用
        User u1 = new User(1, "张三", "123456", new double[]{90.5, 80.0, 70.0});
        User u2 = (User) u1.clone();   // 克隆对象 必须alt+回车 抛出异常
        System.out.println(u1.getId());
        System.out.println(u2.getId());
        System.out.println(u1.getUsername());
        System.out.println(u2.getUsername());
        System.out.println(u1.getPassword());
        System.out.println(u2.getPassword());
        System.out.println(u1.getScores());
        System.out.println(u2.getScores());
        // 克隆有两种方式
        // 1.浅克隆：只克隆对象本身，不克隆对象引用的其他对象。（基本类型直接拷贝、字符串有常量池所以拷贝地址、对象包含其他对象也就是引用类型拷贝地址）
        // 2.深克隆：克隆对象本身，也克隆对象引用的其他对象。（基本类型直接拷贝、字符串有常量池所以拷贝地址、对象包含其他对象也就是引用类型拷贝地址，但对象引用的其他对象也拷贝一份 ）
        // 浅克隆 深克隆写法见User类

        System.out.println();
        System.out.println("2 Objects工具类");
        // Objects：是一个工具类 提供了很多操作对象的静态方法 给我们使用
        String s3 = "itheima";
        String s4 = "itheima";
        String s5 = null;
        System.out.println(s3.equals(s4));
        System.out.println(Objects.equals(s3, s4));  // 这里对象自己的equals方法和Objects.equals方法效果一样 但是Objects.equals方法更安全
        // 但是如果s3为null，s4不为null，s3.equals(s4)会报空指针异常，而Objects.equals(s3, s4)不会报空指针异常会返回false

        System.out.println("s4是否为空："+Objects.isNull(s4)); // 判断对象是否为空
        System.out.println("s4是否不为空："+Objects.nonNull(s4)); // 判断对象是否不为空
        System.out.println("s5是否为空："+Objects.isNull(s5)); // 判断对象是否为空
        System.out.println("s5是否不为空："+Objects.nonNull(s5)); // 判断对象是否不为空

        System.out.println();
        System.out.println("3 包装类");
        // 包装类：将基本数据类型封装成对象，方便进行对象的传递和操作
        // 基本数据类型  包装类
        // byte      Byte
        // short     Short
        // int       Integer
        // long      Long
        // float     Float
        // double    Double
        // char      Character
        // boolean   Boolean
        // 这些包装类在javaapi文档中都能搜到，详细信息请自行查看

        Integer a = Integer.valueOf("123"); // Integer的构造方法已过时 直接使用valueOf类静态方法
        System.out.println(a);

        // 自动装箱：将基本数据类型自动转换成包装类对象
        Integer a1 = 123; // 自动装箱
        System.out.println(a1);

        // 自动拆箱：将包装类对象自动转换成基本数据类型
        int a2 = a1; // 自动拆箱
        System.out.println(a2);

        // 泛型和集合不支持基本数据类型，只能支持引用数据类型（包装类）
        // ArrayList<int> list = new ArrayList<>(); // 这里会报错 解决方案是使用包装类Integer
        ArrayList<Integer> list = new ArrayList<>();
        list.add(123); // 自动装箱
        list.add(456); // 自动装箱
        int a3 = list.get(0); // 自动拆箱

        // 包装类的其他常见操作
        System.out.println();
        // 1 把基本数据类型转换成字符串
        String str = Integer.toString(a1);
        String str1 = a1.toString();
        String str2 = a1 + "";
        System.out.println(str.getClass());
        System.out.println(str1.getClass());
        System.out.println(str2.getClass());

        // 2 把字符串转换成基本数据类型
        String ageStr = "29";
//        int age = Integer.parseInt(ageStr);
        int age = Integer.valueOf(ageStr);  // valueOf方法转换效果一样 这里指需要记valueOf方法 ageStr必须是数字整数字符串才能正常 要不然报错
        System.out.println(age+1);

        String score = "95.5";
//        double score1 = Double.parseDouble(score);
        double score1 = Double.valueOf(score);  // valueOf方法转换效果一样 这里指需要记valueOf方法 score必须是数字浮点数字符串才能正常 要不然报错
        System.out.println(score1+1);



    }
}




























