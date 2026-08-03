package com.itheima.hello;

import java.util.Random;
import java.util.Scanner;

public class rumen3 {
    public static void main(String[] args) {
        System.out.println("1 数组:就是一个容器 用来存储一批同类型的数据");
        // 有变量为啥还用数组 因为处理批量数据 显然数组更加方便

        System.out.println("2 静态初始化数组");
        // 静态初始化数组 写法： 数据类型[] 数组名 = new 数据类型[] {数据1,数据2,数据3,数据4,数据5};
        int[] a = new int[]{1,2,3,4,5};
        double [] a1 = new double[]{1.1,2.2,3.3,4.4,5.5};

        // 静态初始化数组 简化写法：数据类型[] 数组名 = {数据1,数据2,数据3,数据4,数据5};
        int[] a2 = {1,2,3,4,5};
        double [] a3 = {1.1,2.2,3.3,4.4,5.5};

        // 数组存的是数组对象的地址 所以下面打印的是地址信息
        // 数组就是引用数据类型
        System.out.println(a);
        System.out.println(a1);

        System.out.println("3 数据操作");

        // 数据访问：  数组名[索引]
        int[] a4 = {1,2,3,4,5};
        System.out.println(a4[0]);
        System.out.println(a4[1]);
        System.out.println(a4.length); // 数组长度

        // 数组修改 ： 数组名[索引] = 新数据
        a4[0] = 10;
        System.out.println(a4[0]);

        System.out.println(a4.length-1); // 数组的最大索引 前提是数据的元素个数大于0

        System.out.println("-----------------");
        // 数组遍历
        for (int i = 0; i < a4.length; i++) { //数组名.fori 就能快速构建循环体
            System.out.println(a4[i]);
        }

        // 数组求和小案例
        int sum = 0;
        for (int i = 0; i < a4.length; i++) {
            sum += a4[i];
        }
        System.out.println("和为"+ sum);

        System.out.println("4 动态初始化数组：定义数组时先不存入具体的元素值，只确定类型和长度");
        // 动态初始化数组 数据类型[] 数组名 = new 数据类型[长度];
        int[] a5 = new int[3]; // 创建一个长度为5的数组 默认元素都是0
        System.out.println(a5[0]);
        System.out.println(a5[1]);
        System.out.println(a5[2]);
        a5[0] = 10;
        a5[1] = 20;
        a5[2] = 30;
        System.out.println(a5[0]);
        System.out.println(a5[1]);
        System.out.println(a5[2]);

        // 基本类型数据默认值
        // byte short int char long 类型的动态数组 元素默认值是0
        // float double 类型的动态数组 元素默认值是0.0
        // boolean 类型的动态数组 元素默认值是false

        // 引用类型数组默认值
        // 类 接口 数组 String 类型的动态数组 默认值是null

        // 动态初始化数组：适合开始不确定具体元素值，只知道元素个数的业务场景
        // 静态初始化数组：适合开始就知道要存入哪些元素值的业务场景

        // 动态初始化数组 评委打分案例
//        double[] scores = new double[6];
//
//        Scanner sc = new Scanner(System.in);
//
//        for (int i = 0; i < scores.length; i++) {
//            System.out.println("请输入第" + (i+1) + "位评委打分：");
//            scores[i] = sc.nextDouble();
//            if (scores[i] < 0 || scores[i] > 100) {
//                System.out.println("打分范围0-100");
//                i--;
//                continue;
//            }
//        }
//
//        double sum1 = 0;
//        for (int i = 0; i < scores.length; i++) {
//            sum1 += scores[i];
//        }
//        System.out.println("平均分是：" + sum1 / scores.length);

        // 多个变量 指向同一个数组的形式 大家相当于指向了同一个数组对象 其中一个变量修改了数据内容 那么其他变量也会修改
        int[] a6 = {1,2,3,4,5};
        int[] a7 = a6;
        System.out.println(a6);
        System.out.println(a7);
        System.out.println(a6 == a7);

        a7[0] = 10;
        System.out.println(a6[0]);

        // 如果某个数组变量存储的地址是null，那么该变量将不再指向任何数组对象。
        int[] a8 = {1,2,3,4,5};
        a8 = null;
        System.out.println(a8);

        System.out.println("5 场景案例");
        // 数组元素求最大值
        int[] a9 = {1000,1322,345456,21341345,1234,5143};
        int max = a9[0];
        for (int i = 0; i < a9.length; i++) {
            if (a9[i] > max) {
                max = a9[i];
            }
        }
        System.out.println("最大值是：" + max);

        // 数组元素反转
        int[] a10 = {1,2,3,4,5};
        for (int i =0 ,j = a10.length-1; i < j; i++,j--){
            int temp = a10[i];
            a10[i] = a10[j];
            a10[j] = temp;
            System.out.println(a10[i]);
        }
        System.out.println("反转后的数组是：");
        for (int i = 0; i < a10.length; i++) {
            System.out.println(a10[i]);
        }

        // 员工工号随机排名
        int[] codes = new int[5];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < codes.length; i++) {
            System.out.println("请输入第" + (i+1) + "位员工的工号：");
            codes[i] = sc.nextInt();
        }

        Random random = new Random();
        for (int i = 0; i < codes.length; i++) {
            int index = random.nextInt(codes.length);
            int temp = codes[i];
            codes[i] = codes[index];
            codes[index] = temp;
        }

        for (int i = 0; i < codes.length; i++) {
            System.out.println("打乱后的第" + (i+1) + "位员工的工号是：" + codes[i]);
        }


    }
}
































