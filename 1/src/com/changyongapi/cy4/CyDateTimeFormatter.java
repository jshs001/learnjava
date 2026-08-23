package com.changyongapi.cy4;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CyDateTimeFormatter {
    public static void main(String[] args) {
        // 1 创建一个日期时间格式化对象
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        // 2 对时间进行格式化
        LocalDateTime now = LocalDateTime.now();
        System.out.println("当前时间: " + now);

        String formattedDateTime = formatter.format(now);
        System.out.println("格式化后的时间: " + formattedDateTime);

        System.out.println();

        // 3 格式化时间还有一种方案
        String formattedDateTime1 = now.format(formatter);
        System.out.println("格式化后的时间1: " + formattedDateTime1);
        System.out.println();

        // 4 解析时间：一般使用LocalDateTime提供的解析方法类解析
        String dateStr = "2023-04-01 12:34:56";
        LocalDateTime parsedDateTime = LocalDateTime.parse(dateStr, formatter);
        System.out.println("解析后的时间: " + parsedDateTime);










    }

}
