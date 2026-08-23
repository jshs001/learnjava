package com.changyongapi.hello;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.SimpleFormatter;

public class cy3 {
    public static void main(String[] args) throws ParseException {
        System.out.println("1 Date");
        // Date:日期时间类
        Date d = new Date();  // 无参构造器 返回一个时间对象
        System.out.println(d);

        long time = d.getTime(); // 获取时间戳
        System.out.println(time);

        // 2s 之后的时间是多少
        time += 2000;
        System.out.println("2s 之后的时间是：\n" + new Date(time)); // 有参构造器 传入时间戳

        Date d1 = new Date();
        d1.setTime(time); // 设置时间戳
        System.out.println(d1);

        System.out.println();
        System.out.println("2 SimpleDateFormat");
        // SimpleDateFormat:简单日期格式化类 可以  格式化日期时间  解析日期时间

        // 1 格式化日期时间
        // 它本身的格式化方法太麻烦
        // 它的父类 父类有个format Date对象的方法； 它的父类的父类 有format Object对象的方法 （可以传入时间戳）
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sf.format(d));
        System.out.println(sf.format(time));

        // 2 解析日期时间
        String datestr = "2023-04-01 12:34";
        SimpleDateFormat sf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date d2 = sf1.parse(datestr); // 解析日期时间
        System.out.println(d2);

        System.out.println();
        System.out.println("3 案例");
        // 秒杀活动 时间计算
        String start = "2023-11-11 0:0:0";
        String end = "2023-11-11 0:10:0";
        String xj = "2023-11-11 0:01:18";
        String xp = "2023-11-11 0:10:57";

        SimpleDateFormat sf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date startDt = sf2.parse(start);
        Date endDt = sf2.parse(end);
        Date xjDt = sf2.parse(xj);
        Date xpDt = sf2.parse(xp);

        long startTime = startDt.getTime();
        long endTime = endDt.getTime();
        long xjTime = xjDt.getTime();
        long xpTime = xpDt.getTime();

        if (xjTime >= startTime && xjTime <= endTime) {
            System.out.println("小贾秒杀成功了");
        } else {
            System.out.println("小贾秒杀失败了");
        }

        if (xpTime >= startTime && xpTime <= endTime) {
            System.out.println("小皮秒杀成功了");
        } else {
            System.out.println("小皮秒杀失败了");
        }

        System.out.println();
        System.out.println("4 Calendar");
        // Calendar:日历类 系统此时的时间对应的日历；通过它可以单独获取、修改时间中的年、月、日、时、分、秒等
        // Calendar 是抽象类 不能实例 已知的直接子类是 GregorianCalendar

        Calendar c = Calendar.getInstance(); // 获取日历对象
        System.out.println(c);
        System.out.println("年：" + c.get(Calendar.YEAR)); // 获取年
        System.out.println("月：" + (c.get(Calendar.MONTH) + 1)); // 获取月
        System.out.println("日：" + c.get(Calendar.DAY_OF_MONTH)); // 获取日
        System.out.println("时：" + c.get(Calendar.HOUR_OF_DAY)); // 获取时
        System.out.println("分：" + c.get(Calendar.MINUTE)); // 获取分
        System.out.println("秒：" + c.get(Calendar.SECOND)); // 获取秒

        Date d3 = c.getTime(); // 获取日期对象
        System.out.println(d3);

        long time1 = c.getTimeInMillis(); // 获取时间戳
        System.out.println(time1);

        c.set(Calendar.YEAR, 2023); // 设置年
        c.set(Calendar.MONTH, 10); // 设置月
        c.set(Calendar.DAY_OF_MONTH, 1); // 设置日
        c.set(Calendar.HOUR_OF_DAY, 12); // 设置时
        c.set(Calendar.MINUTE, 30); // 设置分
        c.set(Calendar.SECOND, 45); // 设置秒

        System.out.println(c.getTime());

        c.add(Calendar.DAY_OF_MONTH, 1); // 增加一天
        System.out.println(c.getTime());    // 输出增加一天后的时间
        c.add(Calendar.DAY_OF_MONTH, -1); // 减少一天
        System.out.println(c.getTime());    // 输出减少一天后的时间

        // 注意：Calendar是可变对象，一旦修改后其对象本身表示的时间将发生改变。











    }
}
