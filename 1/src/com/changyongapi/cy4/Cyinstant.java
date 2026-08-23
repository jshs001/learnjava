package com.changyongapi.cy4;

import java.time.Instant;

public class Cyinstant {
    public static void main(String[] args) {
        // 1 创建Instant对象 （不可变对象）
        Instant instant = Instant.now();

        // 2 获取总秒数
        long seconds = instant.getEpochSecond();
        System.out.println("总秒数：" + seconds);

        // 3 获取纳秒数
        int nanos = instant.getNano();
        System.out.println("纳秒数：" + nanos);

        System.out.println("Instant对象：" + instant);

        // 也有加减法操作 这里就简单测试一下加减秒
        Instant instant1 = instant.plusSeconds(10);
        System.out.println("加10秒：" + instant1);

        Instant instant2 = instant.minusSeconds(10);
        System.out.println("减10秒：" + instant2);

        // 作用：通常做代码的性能分析、执行时间统计；或者记录用户的操作时间点














    }
}
