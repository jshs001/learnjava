package com.changyongapi.hello;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class cy9 {
    public static void main(String[] args) {
        System.out.println("1 正则表达式体验");
        // 概念：由一组特定的字符组成，代表的是一个规则。
        // 可用来校验一组数据格式是否合法 或在一段文本中查找满足要求的内容

        System.out.println(checkQQ("999999999"));
        System.out.println(checkQQ1("999999999"));

        System.out.println();
        System.out.println("2 正则表达式书写规则");
        // api接口文档 输入Pattern
        // 如 \\d 表示一个数字     这里java的\表示转义 所以要写\\d， 让\\表示一个普通的\
        // 如 \\d{5,11} 表示5-11位数字

        System.out.println();
        System.out.println("3 正则表达式应用");
//        checkPhone();
//        checkEmail();
//        method();
        String s1 = "古力娜扎啊u88888123890asd迪丽热巴asdfuoiuio808那儿哈扎1413keerbazh";
        System.out.println(s1.replaceAll("\\w+", "-"));

        String s2 = "我我我我喜欢编编编程程";
        System.out.println(s2.replaceAll("(.)\\1+", "$1"));

        String s3 = "古力娜扎啊u88888123890asd迪丽热巴asdfuoiuio808那儿哈扎1413keerbazh";
        String[] names = s1.split("\\w+");
        System.out.println(Arrays.toString(names));

    }

    // 不用正则 自己写程序判断qq号码
    public static boolean checkQQ(String qq) {
        if (qq != null && qq.length() >= 5 && qq.length() <= 11) {
            for (int i = 0; i < qq.length(); i++) {
                if (qq.charAt(i) < '0' || qq.charAt(i) > '9') {
//                    System.out.println("qq号码必须是数字");
                    return false;
                }
            }
//            System.out.println("qq号码合法");
        } else {
//            System.out.println("qq号码长度必须在5-11之间");
        }
        return true ;
    }

    // 正则
    public static boolean checkQQ1(String qq) {
        return qq != null && qq.matches("\\d{5,11}");
    }

    public static void checkPhone() {
        while (true) {
            System.out.println("请输入你的电话号码(手机|座机)");
            Scanner sc = new Scanner(System.in);
            String phoneNum = sc.nextLine();

            if(phoneNum.matches("(1[3-9]\\d{9})|(0\\d{2,7}-?[1-9]\\d{4,19})")){
                System.out.println("您输入的号码格式正确");
            }else{
                System.out.println("您输入的号码格式不正确");
            }
        }
    }

    public static void checkEmail() {
        while (true) {
            System.out.println("请输入你的邮箱");
            Scanner sc = new Scanner(System.in);
            String phoneNum = sc.nextLine();

            if(phoneNum.matches("\\w{2,}@\\w{2,20}(\\.\\w{2,10}){1,2}")){
                System.out.println("您输入的邮箱格式正确");
            }else{
                System.out.println("您输入的邮箱格式不正确");
            }
        }
    }

    public static void method() {
        String data="来黑马程序员学习Java，\n"+
                "电话:1866668888，18699997777\n"+
                "或者联系邮箱:bonivGitcast.cn，\n"+
                "座机电话:01036517895，010-98951256\n"+
                "邮箱:bozai@itcast.cn，\n"+
                "邮箱:dlei0009@163.com，\n"+
                "热线电话:400-618-9090，400-618-4000，4006184000，4006189090";
        // 1、定义爬取规则
        String regex = "(1[3-9]\\d{9})|(0\\d{2,7}-?[1-9]\\d{4,19})|(\\w{2,}@\\w{2,20}(\\.\\w{2,10}){1,2})"+"|(400-?\\d{3,7}-?\\d{3,7})";
        //2、把正则表达式封装成一个Pattern对象
        Pattern pattern= Pattern.compile(regex);
        //3、通过pattern对象去获取查找内容的匹配器对象，
        Matcher matcher =pattern.matcher(data);
        //4、定义一个循环开始爬取信息
        while (matcher.find()) {
            String rs = matcher.group();//获取到了找到的内容了
            System.out.println(rs);
        }
    }
}
