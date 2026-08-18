package com.itheima1.gaoji0;

import java.util.Random;

public class LoginDemo {
    public static void main(String[] args) {

//        // 生成4位随机验证码 包含数字 和英文大小写
//        String code = "";
//        String data = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
//
//        Random random = new Random();
//        for (int i = 0; i < 4; i++) {
//            int index = random.nextInt(data.length());
//            char ch = data.charAt(index);
//            code += ch;
//        }
//        System.out.println(code);
        System.out.println(MyUtil.createCode(4));
    }
}
