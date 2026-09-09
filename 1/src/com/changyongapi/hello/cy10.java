package com.changyongapi.hello;

import com.changyongapi.cy10.AgeIllegalException;
import com.changyongapi.cy10.AgeIllegalRuntimeException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class cy10 {
    public static void main(String[] args) throws ParseException {
        System.out.println("1 异常");
        // 概念：代表程序出现的问题
        // 异常分类：
        // 1. 编译期异常：java.lang.Error
        // 2. 运行期异常：java.lang.Exception

        // 异常体系图
        // 1 java.lang.Throwable
        //      2.1 java.lang.Error
        //      2.2 java.lang.Exception
        //          2.2.1 java.lang.RuntimeException
        //          2.2.2 其他异常

        // error:代表系统级别错误（属于严重问题），系统一旦出现问题，sun公司会把这些问题封装成error对象出来，程序员无法处理。
        // exception:异常，代表程序可能出现的问题，程序员通常会用Exception以及它的孩子来封装程序出现的问题
        // RuntimeException:运行时异常，编译阶段不会出现错误提醒，程序运行时出现的问题（如空指针、数组越界、类型转换）
        // 其他异常：编译阶段会出现错误提醒，如文件不存在、网络连接问题等

        // Integer.valueOf("asd"); // 运行时异常，程序运行时出现的问题
//        int[] arr = {123,12,34};
//        System.out.println(arr[3]); // 运行时异常，数组越界

        // 异常的两种处理方式
        // 1. try catch 捕获异常
        // 2. 在方法上throws 抛出异常 可以将方法内部出现的异常抛出去给调用者处理
//        try {
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//            Date d = sdf.parse("2020-01-01 12:12:12"); // 编译时异常 try catch方法处理
//            System.out.println(d);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }

//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date d = sdf.parse("2020-01-01 12:12:12"); // 编译时异常 throws方法处理 10行
//        System.out.println(d);



        System.out.println();
        System.out.println("2 自定义异常");
        // 自定义异常
        // java无法为世界上全部的问题都提供异常类来代表，如果企业自己的某种问题想通过异常来表示，以便用异常管理该问题，就需要自己定义异常类
//        try {
//            savaAge(250);
//            System.out.println("年龄合法"); // 如果出现异常，下面的代码不会执行
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("底层出现了bug");
//        }
//
//        try {
//            savaAge1(250);
//            System.out.println("年龄合法"); // 如果出现异常，下面的代码不会执行
//        } catch (AgeIllegalException e) {
//            e.printStackTrace();
//            System.out.println("底层出现了bug1");
//        }

        System.out.println();
        System.out.println("3 异常处理");
        // 异常处理：try catch 和 throws 是代码层面的异常处理

        // 开发中对于异常的常见处理方式：
        // 方法a 调用方法b 方法b调用方法c；方法c中出现异常抛给方法b 方法b中出现异常抛给方法a，
        // 方法a理论上也可外抛，但是 1 建议在最外层的方法a捕获异常，记录异常并响应合适信息给用户。
//        try {
//            test1();
//        } catch (FileNotFoundException e) {
//            System.out.println("文件未找到");
//            e.printStackTrace(); // 打印出这个异常对象的信息
//        } catch (ParseException e) {
//            System.out.println("日期格式错误");
//            e.printStackTrace();
//        }

        // 使用Exception e 接收所有异常
//        try {
//            test1();
//        } catch (Exception e) {  // 使用Exception e 接收所有异常
//            System.out.println("您当前操作有问题");
//            e.printStackTrace();
//        }

        // 或2 方法a中捕获异常，尝试重新修复。
        while (true) {
            try {
                System.out.println(getMoney());
            } catch (Exception e) {
                System.out.println("请您输入合法的数字");
            }
        }

    }

    public static void savaAge(int age){
        if(age >0 && age < 150)
            System.out.println("年龄合法");
        else
            throw new AgeIllegalRuntimeException("年龄不合法");
        // 用一个异常对象来封装这个问题
        // throw 抛出异常对象
    }
    // 自定义运行时异常
    // 1 定义一个异常类继承RuntimeException
    // 2 重写构造器
    // 3 通过throw new 异常类（xxx）  来创建异常对象并抛出；  编译阶段不报错 提醒不强烈 运行时才可能出现

    public static void savaAge1(int age) throws AgeIllegalException {
        if(age >0 && age < 150)
            System.out.println("年龄合法");
        else
            throw new AgeIllegalException("年龄不合法");
        // 用一个异常对象来封装这个问题
        // throw 抛出异常对象
        // throws 用在方法上 抛出方法内部的异常
    }
    // 自定义编译时异常
    // 1 定义一个异常类继承RuntimeException
    // 2 重写构造器
    // 3 通过throw new 异常类（xxx）  来创建异常对象并抛出；  编译阶段不报错 提醒不强烈 运行时才可能出现

    // 需要特别强烈提醒的用编译时异常 否则用运行时异常



    public static void test1() throws FileNotFoundException, ParseException { // 这里可以直接抛出Exception
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d = sdf.parse("2020-01-01 12:12:12"); // 编译时异常 throws方法处理 10行
        System.out.println(d);

        test2();
    }

    public static void test2() throws FileNotFoundException {    // 这里可以直接抛出Exception
        InputStream is = new FileInputStream("a.txt");
    }


    public static double getMoney(){
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("请输入金额");
            double money = sc.nextDouble();
            if (money >= 0){
                return money;
            }else{
                System.out.println("金额不能为负数");
            }
        }
    }
}
