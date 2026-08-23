package com.changyongapi.hello;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

public class cy4 {
    public static void main(String[] args) {
        System.out.println("1 jdk8为啥新增了 日期和时间对象");
        // 1 老的日期和时间对象设计不合理 使用不方便 很多都被淘汰了
        // Date d = new Date();
        // System.out.println(d.getYear()); // 126 是参照1900开始的

        // 2 都是可变对象 修改后会丢失最开始的时间信息
        // jdk8 Date对象修改后 会形成一个新的时间对象 不会丢失最开始的时间信息

        // 3 线程不安全
        // 如：很多人一起使用SimpleDateFormat对象时候会出问题 ,否则就得每个人创建一个新的SimpleDateFormat对象

        // 4 只能精确到毫秒
        // jdk8 精确到毫秒和纳秒

        // 注意新的项目 一定要用新的时间 日期api

        System.out.println();
        System.out.println("2 jdk8新的日期和时间api");
        // 1 代替Calendar
        // LocalDate: 年 月 日
        // LocalTime: 时 分 秒
        // LocalDateTime: 年 月 日 时 分 秒
        // ZoneId: 时区
        // ZonedDateTime: 带时区的时间

        // 2 代替Date
        // Instant: 时间戳

        // 3 代替SimpleDateFormat
        // DateTimeFormatter: 用于时间的格式化和解析

        // 4 其他补充
        // Period : 计算日期间隔
        // Duration : 计算时间间隔

        // 相关代码样例见cy4包下的类









    }
}
