package com.changyongapi.cy4;

import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.TimeZone;

public class CyZoneId {
    public static void main(String[] args) {
        // 时区：为了让全世界每个地方的人，都能在各自手表上的“中午 12 点”看到太阳升到最高处，而对地球进行的时间区域划分。
        // 中国的时区是：Asia/Shanghai； 东八区

        // 时区对象：ZoneId
        // 获取系统默认时区
        ZoneId zoneId = ZoneId.systemDefault(); // 获取系统默认时区
        System.out.println(zoneId.getId()); // 输出：Asia/Shanghai
        System.out.println(zoneId);
        System.out.println();

        // 获取java支持的全部时区id
        System.out.println(ZoneId.getAvailableZoneIds());
        System.out.println(ZoneId.getAvailableZoneIds().size());
        System.out.println();

        // 获取指定时区id的时区对象
        ZoneId zoneId1 = ZoneId.of("America/Cuiaba");
        System.out.println();

        // 扩展:
        // Calender对象 也是支持时区的
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone(zoneId1));
        // 创建格式化工具，并把时区同步给它
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z");
        sdf.setTimeZone(calendar.getTimeZone()); // 这一步非常关键！
        // 格式化打印
        System.out.println(sdf.format(calendar.getTime()));

        // ZonedDateTime : 时区日期时间
        ZonedDateTime zonedDateTime = ZonedDateTime.now(zoneId1); // 获取指定时区的当前时间
        System.out.println(zonedDateTime);







    }
}
