package com.io.hello;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class io2 {
    public static void main(String[] args) throws UnsupportedEncodingException {
        System.out.println("1 字符集");
        // ASCII 使用一个字节存储，首位是0，共可以代表128个字符；美国信息交换标准代码，包括了英文、符号
        // GBK 使用两个字节存储，首位是1，共可以代表2万多个字符；汉字编码字符集，包涵2万多个汉字等字符； 并且兼容ASCII
        // Unicode（utf-32） 万国码 是国际组织制定的，可以容纳世界上所有文字、符号的字符集 4个字节；兼容ASCII（前面补24个0）、GBK（前面补16个0）

        // utf-8 是Unicode字符集的一种编码方案，采取可变长编码方案，共分4个长度区：1个字节、2个字节、3个字节、4个字节
        //     英文字符、数字等只占1个字节（兼容ASCII），中文字符占3个字节
        //     0xxxxxxx（ASXII）
        //     110xxxxx 10xxxxxx
        //     1110xxxx 10xxxxxx 10xxxxxx
        //     11110xxx 10xxxxxx 10xxxxxx 10xxxxxx

        // 注意：技术人员在开发时都应该使用utf-8字符集
        //      字符编码时使用的字符集，和解码时使用的字符集必须一致，否则会出现乱码
        //      英文，数字一般不会乱码，因为很多字符集都兼容了ASCII

        System.out.println();
        System.out.println("2 字符编码解码");
        // 编码：把字符按照指定的字符集编码成字节
        // 解码：把字节按照指定的字符集解码成字符

        String data = "a我b";
        byte[] bytes = data.getBytes(); // 默认按照平台字符集（utf-8）进行编码
        System.out.println(bytes.length);
        System.out.println(Arrays.toString(bytes));

        byte[] bytes1 = data.getBytes("GBK"); // 指定字符集进行编码，处理异常
        System.out.println(bytes1.length);
        System.out.println(Arrays.toString(bytes1));

        String s = new String(bytes); // 默认按照平台字符集（utf-8）进行解码
        System.out.println(s);

        String s1 = new String(bytes1); // 会乱码
        System.out.println(s1);

        String s2 = new String(bytes1, "GBK"); // 指定字符集进行解码，处理异常
        System.out.println(s2);

    }
}
