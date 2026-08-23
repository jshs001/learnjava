package com.changyongapi.cy4;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class CyLocalDateTime {
    public static void main(String[] args) {
        // 3 LocalDateTime
        // 获取当前日期时间对象 （不可变对象）
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);
        System.out.println();

        // 获取日期时间信息
        int year1 = ldt.getYear();
        int month1 = ldt.getMonthValue();
        int day1 = ldt.getDayOfMonth();
        int hour1 = ldt.getHour();
        int minute1 = ldt.getMinute();
        int second1 = ldt.getSecond();
        int nano1 = ldt.getNano();
        System.out.println(year1 + " " + month1 + " " + day1 + " " + hour1 + " " + minute1 + " " + second1 + " " + nano1);
        System.out.println();

        // 修改日期时间信息 返回一个新的日期时间对象
        LocalDateTime ldt1 = ldt.withYear(2020);
        System.out.println(ldt1);
        LocalDateTime ldt2 = ldt.withMonth(12);
        System.out.println(ldt2);
        LocalDateTime ldt3 = ldt.withDayOfMonth(12);
        System.out.println(ldt3);
        LocalDateTime ldt4 = ldt.withHour(12);
        System.out.println(ldt4);
        LocalDateTime ldt5 = ldt.withMinute(12);
        System.out.println(ldt5);
        LocalDateTime ldt6 = ldt.withSecond(12);
        System.out.println(ldt6);
        LocalDateTime ldt7 = ldt.withNano(12);
        System.out.println(ldt7);
        System.out.println();

        // 加多少
        LocalDateTime ldt8 = ldt.plusYears(1);
        System.out.println(ldt8);
        LocalDateTime ldt9 = ldt.plusMonths(1);
        System.out.println(ldt9);
        LocalDateTime ldt10 = ldt.plusDays(1);
        System.out.println(ldt10);
        LocalDateTime ldt11 = ldt.plusHours(1);
        System.out.println(ldt11);
        LocalDateTime ldt12 = ldt.plusMinutes(1);
        System.out.println(ldt12);
        LocalDateTime ldt13 = ldt.plusSeconds(1);
        System.out.println(ldt13);
        LocalDateTime ldt14 = ldt.plusNanos(1);
        System.out.println(ldt14);
        System.out.println();

        // 减多少
        LocalDateTime ldt15 = ldt.minusYears(1);
        System.out.println(ldt15);
        LocalDateTime ldt16 = ldt.minusMonths(1);
        System.out.println(ldt16);
        LocalDateTime ldt17 = ldt.minusDays(1);
        System.out.println(ldt17);
        LocalDateTime ldt18 = ldt.minusHours(1);
        System.out.println(ldt18);
        LocalDateTime ldt19 = ldt.minusMinutes(1);
        System.out.println(ldt19);
        LocalDateTime ldt20 = ldt.minusSeconds(1);
        System.out.println(ldt20);
        LocalDateTime ldt21 = ldt.minusNanos(1);
        System.out.println(ldt21);
        System.out.println();

        // 获取指定日期时间的LocalDateTime对象
        LocalDateTime ldt22 = LocalDateTime.of(2020, 12, 12, 12, 12, 12, 12);
        LocalDateTime ldt23 = LocalDateTime.of(2020, 12, 12, 12, 12, 12, 12);
        System.out.println(ldt22);
        System.out.println(ldt23);
        System.out.println();

        // 判断
        System.out.println(ldt22.equals(ldt23));
        System.out.println(ldt22.isAfter(ldt23));
        System.out.println(ldt22.isBefore(ldt23));
        System.out.println();

        // 转换 LocatDateTime是包含了日期和时间的 因此 可以转换成日期和时间对象 ;日期和时间对象 也能转回来
        LocalDate ld = ldt.toLocalDate();
        LocalTime lt = ldt.toLocalTime();
        System.out.println(ld);
        System.out.println(lt);

        LocalDateTime ldt24 = LocalDateTime.of(ld, lt); // 日期和时间对象 也能转回来
        System.out.println(ldt24);
        System.out.println();

    }
}
