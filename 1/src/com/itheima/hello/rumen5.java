package com.itheima.hello;

import java.util.Random;
import java.util.Scanner;

public class rumen5 {
    public static void main(String[] args) {
        // 买飞机票 案例验证
        double price = calculate(1000, 8, "头等舱");
        System.out.println("优惠价格是："+price);

        // 开发验证码
        String code = createCode(8);
        System.out.println("验证码是："+code);

        // 评委打分
//        System.out.println("当前选手得分是："+getAverageScore(6));

        // 数字加密
        System.out.println("加密后的密码是："+encrypt(1983));
        System.out.println("加密后的密码是："+encrypt(8346));

        // 数组拷贝
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        int[] newArr = copy(arr);
        printArray(newArr);
        System.out.println("原始数组地址："+ arr+";拷贝数组地址："+newArr);

        // 抢红包
        int[] moneys = {10,70,80,90,100};
//        start(moneys);

        // 找素数
        System.out.println("当前素数的个数是：" + findPrime(101, 200));

        // 打印99乘法表
        print99();

        // 打印三角形
        printTriangle();
    }
    // 买飞机票案例
    public static double calculate(double price, int month ,String type){
        if (month >= 5 && month <= 10) {
            switch (type) {
                case "经济舱":
                    price = price * 0.9;
                    break;
                case "头等舱":
                    price = price * 0.85;
                    break;
                default:   //这里可注释 正常前端不会传过来其他异常数据
                    System.out.println("没有这种舱位");
                    return -1;
            }
        }else{
            switch (type) {
                case "经济舱":
                    price = price * 0.7;
                    break;
                case "头等舱":
                    price = price * 0.65;
                    break;
                default:
                    System.out.println("没有这种舱位");
                    return -1;
            }
        }
        return price;
    }

    // 开发验证码
    public static String createCode(int n){
        Random r = new Random();
        String code = "";
        for (int i = 1; i <= n ; i++) {
            int type = r.nextInt(3);
            switch ( type){
                case 0:
                    int number = r.nextInt(10);
                    code += number;
                    break;
                case 1:
                    char ch = (char) (r.nextInt(26) + 'a');
                    code += ch;
                    break;
                case 2:
                    char ch1 = (char) (r.nextInt(26) + 'A');
                    code += ch1;
                    break;
            }
        }
        return code;
    }

    // 评委打分
    public static double getAverageScore(int number){
        int[] scores = new int[number];

        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < scores.length; i++) {
            System.out.println("请输入第" + (i+1) + "位评委打分：");
            scores[i] = sc.nextInt();
        }

        int sum = 0;
        int max = scores[0];
        int min = scores[0];
        for (int i = 0; i < scores.length; i++) {
            sum += scores[i];
            if (scores[i] > max) {
                max = scores[i];
            }
            if (scores[i] < min) {
                min = scores[i];
            }
        }

        return 1.0*(sum - max - min) / (scores.length - 2); // 1.0强制转换成double类型  保证取得的平均分准确
    }

    // 数字加密 对4位int密码每位数加5 对10求余 再反转顺序
    public static String encrypt(int number){
        int[] numbers = split(number);
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = (numbers[i] + 5) % 10;
        }
        reverse(numbers);
        String data = numbers[0] + "" + numbers[1] + "" + numbers[2] + "" + numbers[3];
        return data;
    }

    public static int[] split(int number) {
        int[] numbers = new int[4];
        numbers[0] = number / 1000;
        numbers[1] = number / 100 % 10;
        numbers[2] = number / 10 % 10;
        numbers[3] = number % 10;
        return numbers;
    }
    public static void reverse(int[] numbers) {
        for (int i = 0, j = numbers.length - 1; i < j; i++,j--) {
            int temp = numbers[j];
            numbers[j] = numbers[i];
            numbers[i] = temp;
        }
    }

    // 数组拷贝
    public static int[] copy(int[] arr){
        int[] newArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        return newArr;
    }
    public static void printArray(int[] arr){
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                System.out.print(arr[i]);
            }else{
                System.out.print(arr[i] + ", ");
            }
        }
        System.out.println("]");
    }

    // 抢红包
//    public static void start(int[] moneys){
//        Scanner sc = new Scanner(System.in);
//        Random r = new Random();
//
//        for (int i = 1; i <= 5; i++) {
//            System.out.println("请输入任意内容进行抽奖");
//            sc.next();
//
//            while (true) {
//                int index = r.nextInt(moneys.length); // 这里有性能问题
//                int money = moneys[index];
//
//                if (money != 0) {
//                    System.out.println("恭喜您中奖了，金额为：" + money);
//                    moneys[index] = 0;
//                    break;
//                }
//            }
//        }
//        System.out.println("活动结束");
//    }
    public static void start(int[] moneys){
        Scanner sc = new Scanner(System.in);
        Random r = new Random();

        int[] moneys1 = new int[moneys.length];
        for (int i = 0; i < moneys1.length; i++) {
            moneys1[i] = moneys[i];
        }

        for (int i = 0; i < moneys1.length; i++) {
            int index = r.nextInt(moneys1.length);
            int temp = moneys1[i];
            moneys1[i] = moneys1[index];
            moneys1[index] = temp;
        }

        for (int i = 0; i < moneys1.length; i++) {
            System.out.println("请输入任意内容进行抽奖");
            sc.next();
            System.out.println("恭喜您中奖了，金额为：" + moneys1[i]);
        }
        System.out.println("活动结束");
    }

    // 找素数 返回素数个数 这里同样补充了其他方法
//    public static int findPrime(int start, int end){
//
//        int count = 0;
//
//        if (start < 2 || end < 2 || start > end){
//            return -1;
//        }
//
//        for (int i = start; i <= end; i++) {
//
//            boolean flag = true;
//            for (int j = 2; j < i/2; j++) {
//                if (i % j == 0){
//                    flag = false;
//                    break;
//                }
//            }
//            if (flag){
//                System.out.println(i);
//                count++;
//            }
//        }
//        return count;
//
//    }
//    public static int findPrime(int start, int end){
//
//        int count = 0;
//
//        if (start < 2 || end < 2 || start > end){
//            return -1;
//        }
//
//        OUT: // 为外部循环指定标签
//        for (int i = start; i <= end; i++) {
//            for (int j = 2; j < i/2; j++) {
//                if (i % j == 0){
//                    continue OUT;
//                }
//            }
//            System.out.println(i);
//            count++;
//        }
//        return count;
//
//    }
    public static int findPrime(int start, int end){

        int count = 0;

        if (start < 2 || end < 2 || start > end){
            return -1;
        }

        for (int i = start; i <= end; i++) {
            if(check(i)){
                System.out.println(i);
                count++;
            }
        }
        return count;

    }
    public static boolean check(int data) {
        for (int i = 2; i < data/2; i++) {
            if (data % i == 0) {
                return false;
            }
        }
        return true;
    }

    // 打印99乘表
    public static void print99(){
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + "*" + i + "=" + i*j + "\t");
            }
            System.out.println();
        }
    }

    // 打印三角形
    public static void printTriangle(){
        int n = 5;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <=(n-i) ; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= (2*i-1); j++) {
//                System.out.print("*");  //星星铺满
                System.out.print(j%2==0?" ":"*"); //星星间隔
            }
            System.out.println();
        }
    }
}



































