package com.changyongapi.cy4;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class CyDuration {
    public static void main(String[] args) {
        // Duration类:计算两个时间之间的间隔（LocalTime对象 LocalDateTime对象 Instant对象）
        LocalDateTime startTime = LocalDateTime.of(2023, 1, 1, 10, 30, 0);
        LocalDateTime endTime = LocalDateTime.of(2023, 1, 1, 14, 45, 0);

        // 1 创建一个Duration对象
        Duration duration = Duration.between(startTime, endTime);

        // 2 通过duration对象获取两个时间对象相差的信息
        long days = duration.toDays(); // 获取两个时间对象相差的天数
        long hours = duration.toHours(); // 获取两个时间对象相差的小时数
        long minutes = duration.toMinutes(); // 获取两个时间对象相差的分钟数
        long seconds = duration.getSeconds(); // 获取两个时间对象相差的秒数
        long milliseconds = duration.toMillis(); // 获取两个时间对象相差的毫秒数
        long nanoseconds = duration.toNanos(); // 获取两个时间对象相差的纳秒数

        System.out.println("\n Days: " +  days + ",\n Hours: " + hours + ",\n Minutes: " + minutes + ",\n Seconds: " + seconds + ",\n Milliseconds: " + milliseconds + ",\n Nanoseconds: " + nanoseconds);

    }
}
