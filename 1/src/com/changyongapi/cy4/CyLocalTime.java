package com.changyongapi.cy4;

import java.time.LocalTime;

public class CyLocalTime {
    public static void main(String[] args) {
        // 2 LocalTime
        // 获取当前时间对象 （不可变对象）
        LocalTime lt = LocalTime.now();
        System.out.println(lt);
        System.out.println();

        // 获取时间对象信息
        int hour = lt.getHour();
        int minute = lt.getMinute();
        int second = lt.getSecond();
        int nano = lt.getNano();
        System.out.println(hour + " " + minute + " " + second + " " + nano);
        System.out.println();

        // 修改时间对象信息 返回一个新的时间对象
        LocalTime lt1 = lt.withHour(12);
        System.out.println(lt1);
        LocalTime lt2 = lt.withMinute(12);
        System.out.println(lt2);
        LocalTime lt3 = lt.withSecond(12);
        System.out.println(lt3);
        LocalTime lt4 = lt.withNano(12);
        System.out.println(lt4);
        System.out.println();

        // 加多少
        LocalTime lt5 = lt.plusHours(1);
        LocalTime lt6 = lt.plusMinutes(1);
        LocalTime lt7 = lt.plusSeconds(1);
        LocalTime lt8 = lt.plusNanos(1);
        System.out.println(lt5);
        System.out.println(lt6);
        System.out.println(lt7);
        System.out.println(lt8);
        System.out.println();

        // 减多少
        LocalTime lt9 = lt.minusHours(1);
        LocalTime lt10 = lt.minusMinutes(1);
        LocalTime lt11 = lt.minusSeconds(1);
        LocalTime lt12 = lt.minusNanos(1);
        System.out.println(lt9);
        System.out.println(lt10);
        System.out.println(lt11);
        System.out.println(lt12);
        System.out.println();

        // 获取指定时间的LocalTime对象
        LocalTime lt13 = LocalTime.of(12, 12, 12, 12);
        LocalTime lt14 = LocalTime.of(12, 12, 12, 12);
        System.out.println(lt13);
        System.out.println(lt14);
        System.out.println();

        // 判断
        System.out.println(lt13.equals(lt14));
        System.out.println(lt13.isAfter(lt14));
        System.out.println(lt13.isBefore(lt14));
        System.out.println();
    }
}
