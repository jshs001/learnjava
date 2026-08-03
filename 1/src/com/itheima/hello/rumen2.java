package com.itheima.hello;

import java.util.Random;
import java.util.Scanner;

public class rumen2 {
    public static void main(String[] args) {
        System.out.println("1 if 分支");
        double t = 38.9;
        if (t > 37){
            System.out.println("这个人发烧了");
        }

        double money= 99;
        if (money >= 90){
            System.out.println("发红包成功了");
        }else{
            System.out.println("余额不足");
        }

        int score = 78;
        if (score >= 0 && score < 60){
            System.out.println("不及格");
        }else if(score >= 60 && score < 90){
            System.out.println("良好");
        }else if(score >= 90 && score <= 100){
            System.out.println("优秀");
        }else{
            System.out.println("分数有问题");
        }

        System.out.println("2 switch 分支 是通过比较值 来决定执行哪个分支");
        // 执行流程： 表达式的结果跟 case的值匹配 成功则 执行case下的代码 遇到break则跳出分支结构 都匹配不到则执行default内容

        int day = 3;
        switch (day) {
            case 1:
                System.out.println("星期一");
                break;
            case 2:
                System.out.println("星期二");
                break;
            case 3:
                System.out.println("星期三");
                break;
            case 4:
                System.out.println("星期四");
                break;
            case 5:
                System.out.println("星期五");
                break;
            case 6:
                System.out.println("星期六");
                break;
            case 7:
                System.out.println("星期日");
                break;
            default:
                System.out.println("输入有误");
        }
        // if在功能上远远胜过switch，区间条件用if 值匹配用switch执行效率好

        // switch几点注意事项
        // 1. switch表达式的结果只能是byte short int char 枚举 ,不支持double float long
        // 2. case给出的值不允许重复 且必须为字面量 不能是变量
        // 3. break不能不写 否则会出现穿透现象 但是这个穿透性有时候可以简化代码

        int month = 8;
        switch (month) {
            case 3:
            case 4:
            case 5:
                System.out.println("春季");
                break;
            case 6:
            case 7:
            case 8:
                System.out.println("夏季");
                break;
            case 9:
            case 10:
            case 11:
                System.out.println("秋季");
                break;
            case 12:
            case 1:
            case 2:
                System.out.println("冬季");
                break;
            default:
                System.out.println("月份有误");
        }

        System.out.println("3 for循环");
        for (int i = 0; i < 5; i++) {
            System.out.println("i=" + i);
        }
        for (int i = 0; i < 5; i++) {
            System.out.println("i=" + i);
            if (i == 3){
                break;
            }
        }

        System.out.println("4 while循环");
        int i = 0;
        while (i < 5) {
            System.out.println("i=" + i);
            i++;
        }
        // 知道循环次数 用for;    不知道循环次数 用while

        System.out.println("案例 珠穆朗玛峰和纸张折叠");
        // 珠穆朗玛峰高度 8844.43米 = 8844430毫米
        // 纸张初始厚度 0.1毫米 每次折叠厚度翻倍
        double paper = 0.1;
        double zf = 8844430;
        int count = 0;
        while (paper < zf) {
            paper *= 2;
            count++;
        }
        System.out.println("折叠" + count + "次后，纸张厚度为" + paper / 1000 + "米");
        System.out.println("珠穆朗玛峰高度为" + zf / 1000 + "米");

        System.out.println("5 do...while循环");
        int j = 0;
        do {
            System.out.println("j=" + j);
            j++;
        } while (j < 5);
        // 先执行后判断
        // 使用场景 用户至少要先输入一次密码，才能判断对不对
        // 如果用 while，你得在循环前先写一遍输入代码，循环里再写一遍，代码重复
        // do-while 天然保证循环体至少执行一次，逻辑清晰不重复

        // 三种循环的区别小结
        // for循环 和 while循环(先判断后执行);do...while(先执行后判断)
        // for循环和while循环的执行流程是一模一样的，功能上无区别，for能做的while也能做，反之亦然。
        // 使用规范:如果已知循环次数建议使用for循环，如果不清楚要循环多少次建议使用while循环。
        // 其他区别:for循环中，控制循环的变量只在循环中使用。while循环中，控制循环的变量在循环后还可以继续使用

        System.out.println("6 死循环");
//        for (;;) {
//            System.out.println("死循环");
//        }
//        while (true) {
//            System.out.println("死循环");
//        }
//        do {
//            System.out.println("死循环");
//        } while (true);
        // 上面是死循环的三种写法 推荐用 while
        // 死循环一般用于服务器啊 游戏啊等等

        System.out.println("7 循环嵌套");
        for (int m= 0; m < 2; m++) {
            for (int n = 0; n < 2; n++) {
                System.out.println("m=" + m + "n=" + n);
            }
        }
        OUT: // 为外部循环指定标签
        for (int a = 1; a <= 100; a++) {
            for (int b = 2; b < a/2; b++) {
                if (a % b == 0){
                    continue OUT; // 这个是跳转语句 跳转到标签位置
                }
            }
            System.out.println(a);
        }

        System.out.println("8 break continue");

        for (int k = 0; k < 5; k++) {
            if (k == 2) {
                break;  // 跳出当前循环
//                continue; // 跳出当前循环的当次循环体，继续下一次循环
            }
            System.out.println("k=" + k);
        }

        // 注意： break只能用于结束所在循环 或者结束所在switch分支的执行
        // continue只能在循环中使用

        System.out.println("随机数 案例");

        Random r = new Random();

        for (int n = 0; n <= 20; n++) {
            int number = r.nextInt(10);// 生成0-9的随机数 可以加1 来生成1-10的随机数
            System.out.println("number=" + number);// ctrl alt T 生成for循环
        }

        System.out.println("猜数字大小游戏");

        Random r1 = new Random();
        int luckNumber = r1.nextInt(100) + 1;

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("请输入猜测的数字：");
            int number = sc.nextInt();
            if (number > luckNumber) {
                System.out.println("您输入的数字大了");
            } else if (number < luckNumber) {
                System.out.println("您输入的数字小了");
            } else {
                System.out.println("恭喜，您猜对了");
                break;
            }
        }


    }
}






























