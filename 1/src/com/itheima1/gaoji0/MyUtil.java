package com.itheima1.gaoji0;

public class MyUtil {
    private MyUtil() {
    }

    public static String createCode(int n ) {
        // 生成4位随机验证码 包含数字 和英文大小写
        String code = "";
        String data = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        for (int i = 0; i < n; i++) {
            int index = (int) (Math.random() * data.length());
            char ch = data.charAt(index);
            code += ch;
        }
        return code;
    }
}
