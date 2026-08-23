package com.changyongapi.hello;

import java.util.StringJoiner;

public class cy1 {
    public static void main(String[] args) {
        System.out.println("1 StringBuilder");
        // StringBuilder: 代表可变字符串对象，相当于是一个容器，它里面装的字符串是可以改变的，就是用来操作字符串的。
        // 好处：比String更适合做字符串的修改操作，效率更高，代码更简洁。
//        StringBuilder sb = new StringBuilder();
        StringBuilder sb = new StringBuilder("itheima");
//        StringBuffer sb = new StringBuffer("itheima");
        sb.append("hello");
        sb.append("world");
        sb.append(123);
        sb.append(true);
        sb.append(3.14).append("abc"); // 此方法返回的对象自己所以支持链式编程
        System.out.println(sb.toString());

        System.out.println(sb.reverse());
        System.out.println(sb.length());
        System.out.println(sb.toString());  // 处理好后如果需要给到 String类型参数的方法 就需要转换类型

        System.out.println();
        System.out.println("2 StringBuilder的好处");
        // 拼接100万此 效率对比; StringBuilder 贼快
//        String rs = "";
//        for (int i = 0; i < 1000000; i++) {
//            rs += i;
//        }
//        System.out.println(rs);

//        StringBuilder sb2 = new StringBuilder();
//        for (int i = 0; i < 1000000; i++) {
//            sb2.append(i);
//        }
//        System.out.println(sb2.toString());

        // 对于字符串相关的操作，如频繁的拼接、修改等，建议用StringBuidler，效率更高!
        // 注意:如果操作字符串较少，或者不需要操作，以及定义字符串变量，还是建议用string。

        System.out.println();
        System.out.println("3 StringBuffer");
        // StringBuffer: 和StringBuilder功能用法一模一样，但是StringBuilder是线程不安全的，效率稍高，StringBuffer是线程安全的，效率稍低。
        // 9行的代码可以直接换StringBuffer sb = new StringBuffer("itheima");后面的方法一样

        System.out.println();
        System.out.println("4 案例");
        // 设计一个方法 用于返回任意整型数组的内容
        int[] array = {1, 2, 3, 4, 5};
        System.out.println(getArrayContent(array));
        // 这个案例 StringBuilder 贼快 但是代码写的麻烦; StringJoiner

        System.out.println();
        System.out.println("5 StringJoiner");
        // jdk 8 新增的类，跟StringBuidler一样，也是用来操作字符串的。也可看成一个容器，创建后里面的内容是可变的。
        // 好处：不仅能提高字符串的操作效率，并且在有些场景下使用它操作字符串，代码会更简洁。
//        StringJoiner sj = new StringJoiner(","); // 定义间隔符
        StringJoiner sj = new StringJoiner(",", "[", "]"); // 定义间隔符 开头和结尾符号
        sj.add("hello");
        sj.add("world");
        sj.add("java");
        System.out.println(sj.toString());
        System.out.println(sj.length());

        System.out.println(getArrayContent1(array));


    }

    public static String getArrayContent(int[] array) {
        if (array == null) return "null";

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            if (i < array.length - 1) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static String getArrayContent1(int[] array) {
        if (array == null) return "null";
        StringJoiner sb = new StringJoiner(",", "[", "]");
        for (int i = 0; i < array.length; i++) {
            sb.add(String.valueOf(array[i]));
        }
        return sb.toString();
    }
}
























