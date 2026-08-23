package com.changyongapi.cy4;

import java.time.LocalDate;

public class CyLocalDate {
    public static void main(String[] args) {
        // 1 LocalDate
        // 获取当前日期对象 （不可变对象）
        LocalDate ld = LocalDate.now();
        System.out.println(ld);
        System.out.println();

        // 获取日期对象信息
        int year = ld.getYear();
        int month = ld.getMonthValue();
        int day = ld.getDayOfMonth();
        System.out.println(year + " " + month + " " + day);

        int dayOfYear = ld.getDayOfYear();
        int dayOfWeek = ld.getDayOfWeek().getValue();
        System.out.println(dayOfYear + " " + dayOfWeek);
        System.out.println();

        // 修改日期对象信息 返回一个新的日期对象
        LocalDate ld1 = ld.withYear(2020);
        System.out.println(ld1);
        LocalDate ld2 = ld.withMonth(12);
        System.out.println(ld2);
        System.out.println();

        // 把某个信息加多少
        LocalDate ld3 = ld.plusYears(1); // 加一年
        LocalDate ld4 = ld.plusMonths(1); // 加一月
        LocalDate ld5 = ld.plusDays(1); // 加一天
        LocalDate ld6 = ld.plusWeeks(1); // 加一周
        System.out.println(ld3);
        System.out.println(ld4);
        System.out.println(ld5);
        System.out.println(ld6);
        System.out.println();

        // 把某个信息减多少
        LocalDate ld7 = ld.minusYears(1);
        LocalDate ld8 = ld.minusMonths(1);
        LocalDate ld9 = ld.minusDays(1);
        LocalDate ld10 = ld.minusWeeks(1);
        System.out.println(ld7);
        System.out.println(ld8);
        System.out.println(ld9);
        System.out.println(ld10);
        System.out.println();

        // 获取指定日期的LocalDate对象
        LocalDate ld11 = LocalDate.of(2020, 12, 1);
        System.out.println(ld11);
        LocalDate ld12 = LocalDate.of(2020, 12, 1);
        System.out.println(ld12);
        System.out.println();

        // 判断
        System.out.println(ld11.equals(ld12));
        System.out.println(ld10.isAfter(ld9)); // 判断ld10是否在ld9之后
        System.out.println(ld10.isBefore(ld9)); // 判断ld10是否在ld9之前
        System.out.println();

    }
}
