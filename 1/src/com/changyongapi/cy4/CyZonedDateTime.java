package com.changyongapi.cy4;

import java.time.Clock;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class CyZonedDateTime {
    public static void main(String[] args) {
        // 获取指定时区id的时区对象
        ZoneId zoneId1 = ZoneId.of("America/Cuiaba");
        System.out.println();

        // ZonedDateTime : 时区日期时间
        ZonedDateTime zonedDateTime = ZonedDateTime.now(zoneId1); // 获取指定时区的当前时间
        System.out.println(zonedDateTime);

        ZonedDateTime zonedDateTime1 = ZonedDateTime.now(Clock.systemUTC()); // 获取UTC时区的当前时间 也就是世界标准时间
        System.out.println(zonedDateTime1);

        ZonedDateTime zonedDateTime2 = ZonedDateTime.now(); // 获取系统默认时区的当前时间
        System.out.println(zonedDateTime2);
        System.out.println();

        // ZonedDateTime 和 LocalDateTime 功能几乎一模一样
        // 获取日期时间信息
        int year = zonedDateTime.getYear();
        int month = zonedDateTime.getMonthValue();
        int day = zonedDateTime.getDayOfMonth();
        int hour = zonedDateTime.getHour();
        int minute = zonedDateTime.getMinute();
        int second = zonedDateTime.getSecond();
        int nano = zonedDateTime.getNano();
        System.out.println(year + "年" + month + "月" + day + "日" + hour + "时" + minute + "分" + second + "秒" + nano + "纳秒");
        System.out.println();

        // 修改日期时间信息 返回一个新的日期时间对象
        ZonedDateTime zonedDateTime3 = zonedDateTime.withYear(2020);
        System.out.println(zonedDateTime3);
        ZonedDateTime zonedDateTime4 = zonedDateTime3.withMonth(10);
        System.out.println(zonedDateTime4);
        ZonedDateTime zonedDateTime5 = zonedDateTime4.withDayOfMonth(1);
        System.out.println(zonedDateTime5);
        ZonedDateTime zonedDateTime6 = zonedDateTime5.withHour(12);
        System.out.println(zonedDateTime6);
        ZonedDateTime zonedDateTime7 = zonedDateTime6.withMinute(30);
        System.out.println(zonedDateTime7);
        ZonedDateTime zonedDateTime8 = zonedDateTime7.withSecond(45);
        System.out.println(zonedDateTime8);
        ZonedDateTime zonedDateTime9 = zonedDateTime8.withNano(999999999);
        System.out.println(zonedDateTime9);
        System.out.println();

        // 加多少
        ZonedDateTime zonedDateTime10 = zonedDateTime.plusYears(1);
        System.out.println(zonedDateTime10);
        ZonedDateTime zonedDateTime11 = zonedDateTime10.plusMonths(1);
        System.out.println(zonedDateTime11);
        ZonedDateTime zonedDateTime12 = zonedDateTime11.plusDays(1);
        System.out.println(zonedDateTime12);
        ZonedDateTime zonedDateTime13 = zonedDateTime12.plusHours(1);
        System.out.println(zonedDateTime13);
        ZonedDateTime zonedDateTime14 = zonedDateTime13.plusMinutes(1);
        System.out.println(zonedDateTime14);
        ZonedDateTime zonedDateTime15 = zonedDateTime14.plusSeconds(1);
        System.out.println(zonedDateTime15);
        ZonedDateTime zonedDateTime16 = zonedDateTime15.plusNanos(1);
        System.out.println(zonedDateTime16);
        System.out.println();

        // 减多少
        ZonedDateTime zonedDateTime17 = zonedDateTime16.minusYears(1);
        System.out.println(zonedDateTime17);
        ZonedDateTime zonedDateTime18 = zonedDateTime17.minusMonths(1);
        System.out.println(zonedDateTime18);
        ZonedDateTime zonedDateTime19 = zonedDateTime18.minusDays(1);
        System.out.println(zonedDateTime19);
        ZonedDateTime zonedDateTime20 = zonedDateTime19.minusHours(1);
        System.out.println(zonedDateTime20);
        ZonedDateTime zonedDateTime21 = zonedDateTime20.minusMinutes(1);
        System.out.println(zonedDateTime21);
        ZonedDateTime zonedDateTime22 = zonedDateTime21.minusSeconds(1);
        System.out.println(zonedDateTime22);
        ZonedDateTime zonedDateTime23 = zonedDateTime22.minusNanos(1);
        System.out.println(zonedDateTime23);
        System.out.println();

        // 判断
        System.out.println(zonedDateTime.isAfter(zonedDateTime1));
        System.out.println(zonedDateTime.isBefore(zonedDateTime1));
        System.out.println(zonedDateTime.isEqual(zonedDateTime1));
        System.out.println();

















    }
}
