package com.wjrz.hello;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.charset.StandardCharsets;
import java.util.Properties;
import java.util.Set;

public class wjrz0 {
    public static void main(String[] args) throws Exception {
        System.out.println("1 特殊文件");
        // 除了普通文件外开发中还有特殊文件如属性文件、xml文件等，这些文件的读写操作与普通文件有所不同

        // 为什么用特殊文件？：
        //  如存储多个用户名和密码，使用普通文件存储不方便，使用特殊文件存储方便，如 属性文件：key=value
        //  如果再存更多的信息如 用户名 密码 家乡 性别 等等，属性文件也不方便了 xml文件更合适

        // 特殊文件作用：存储有关系的数据，作为系统的配置文件； 作为信息进行传输。
        // 特殊文件的学习主要掌握它们的特点和作用，与读取和存储操作

        System.out.println();
        System.out.println("2 属性文件");
        // 特点：存的是键值对，且键不重复； 文件后缀一般是.properties结尾。

        // Properties：是一个Map集合实现类（键值对集合），但是我们一般不会当集合使用。
        // 核心作用：用来代表属性文件，读写属性文件里的内容。

        Properties properties = new Properties();
        System.out.println(properties);

        properties.load(new FileReader("1/src/com/wjrz/wjrz0/users.properties", StandardCharsets.UTF_8));
        System.out.println(properties);
        // 根据键取值
        System.out.println(properties.get("admin"));
        System.out.println(properties.get("张无忌")); // 如果这里报错找不到东西应该就是字符编码的问题
        // 文件-设置-文件编码-属性文件（改为UTF-8）同时勾选后面的复选框（自动将本地字符转换为ASCII码）  应用后ok

        // 遍历
        Set<String> keys = properties.stringPropertyNames();
//        for (String key : keys) {
//            System.out.println(key + " = " + properties.get(key));
//        }

        properties.forEach((key, value) -> System.out.println(key + " = " + value));


        System.out.println();
        Properties properties1 = new Properties();
        properties1.setProperty("张三","123");
        properties1.setProperty("丽丝","456");

        properties1.store(new FileWriter("1/src/com/wjrz/wjrz0/users1.properties"), "用户信息");

        System.out.println();
        System.out.println("3 案例");
        Properties properties2 = new Properties();
        properties2.load(new FileReader("1/src/com/wjrz/wjrz0/user.txt"));

        if (properties2.containsKey("张三")){
            properties2.setProperty("张三", "999");
        }

        properties2.store(new FileWriter("1/src/com/wjrz/wjrz0/user.txt"), "succesa");













    }
}
