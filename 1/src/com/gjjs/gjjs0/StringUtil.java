package com.gjjs.gjjs0;

public class StringUtil {
    public static void printNumber(String name) {
        if (name == null) {
            System.out.println("0");
            return;
        } //此为修正代码
        System.out.println("名字的长度是：" + name.length());
    }

    public static int getMaxIndex(String data){
        if(data == null){
            return -1;
        }
        return data.length() -1; // 此为修正代码
//        return data.length();
    }
}
