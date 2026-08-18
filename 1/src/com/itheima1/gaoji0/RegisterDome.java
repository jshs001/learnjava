package com.itheima1.gaoji0;


public class RegisterDome {
    public static void main(String[] args) {
//        // 生成6位随机验证码 包含数字 和英文大小写
//        String code = "";
//        String data = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
//        for (int i = 0; i < 6; i++) {
//            int index = (int) (Math.random() * data.length());
//            char ch = data.charAt(index);
//            code += ch;
//        }
//        System.out.println(code);
        System.out.println(MyUtil.createCode(6));
    }
}
