package com.changyongapi.cy4;

import java.time.LocalDate;
import java.time.Period;

public class CyPeriod {
    public static void main(String[] args) {
        // Period类:计算两个日期（LocalDate对象）之间的间隔
        LocalDate start = LocalDate.of(2023, 1, 1);
        LocalDate end = LocalDate.of(2023, 12, 31);

        // 1 创建一个周期对象
        Period period = Period.between(start, end);

        // 2 通过period对象获取两个日期对象相差的信息
        int years = period.getYears();
        int months = period.getMonths();
        int days = period.getDays();
        System.out.println("Years: " + years + ", Months: " + months + ", Days: " + days);  // 输出结果：Years: 0, Months: 11, Days: 30















    }
}
