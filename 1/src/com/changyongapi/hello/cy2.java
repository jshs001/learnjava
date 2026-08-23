package com.changyongapi.hello;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class cy2 {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("1 Math");
        // Math:数据工具类 提供对数据进行操作的一些静态方法
        System.out.println("绝对值" + Math.abs(-10)); // 绝对值
        System.out.println("向上取整" + Math.ceil(10.1)); // 向上取整
        System.out.println("向下取整" + Math.floor(10.1)); // 向下取整
        System.out.println("四舍五入" + Math.round(10.5)); // 四舍五入
        System.out.println("最大值" + Math.max(10, 20));
        System.out.println("最小值" + Math.min(10, 20));
        System.out.println("取次方" + Math.pow(2, 3));
        System.out.println("取随机数" + Math.random()); // 0.0-1.0 包前不包后

        System.out.println();
        System.out.println("2 System");
        // System:系统工具类 提供对系统进行操作的一些静态方法
        // System.exit(0);  //  终止java虚拟机 退出程序 类似删库跑路 不要用啊
        System.out.println("当前时间" + System.currentTimeMillis()); // 获取当前时间戳 单位毫秒 （ 1970年1月1日 00:00:00 至今的毫米值）；通常用来计算程序运行时间

        long startTime = System.currentTimeMillis();
        String str = "";
        for (int i = 0; i < 10000; i++) {
            str += i;
        }
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间" + (endTime - startTime) + "毫秒");

        System.out.println();
        System.out.println("3 Runtime");
        // Runtime:运行时工具类 代表程序运行环境 是个单例类 提供对运行时进行操作的一些静态方法
        Runtime runtime = Runtime.getRuntime();
        // runtime.exit(0); // 终止java虚拟机 退出程序 千万不要用；  System.exit(0);源码就是调用的此代码；
        System.out.println("总内存" + runtime.totalMemory()); // 1024=1k
        System.out.println("空闲内存" + runtime.freeMemory());
        System.out.println("可用处理器" + runtime.availableProcessors()); // 可用处理器线程数量
        // Process p = runtime.exec("notepad.exe"); // 这里需要抛出异常 参数命令最好写绝对路径除非已添加环境变量
        // Thread.sleep(5000); // 线程休眠5秒
        // p.destroy(); // 销毁 关闭程序
        // // Java 的 p.destroy() 只能杀掉它直接创建的那个“空壳”子进程。但在 Windows 上，记事本窗口在启动后，其控制权已经被移交或创建了独立的子线程/窗口进程。
        // Runtime.getRuntime().exec("taskkill /F /IM notepad.exe"); //上面的代码无法销毁程序 这里用cmd 强制杀掉记事本进程

        System.out.println();
        System.out.println("4 BigDecimal");
        // BigDecimal:大数字工具类 提供对大数字进行操作的一些方法； 用于解决浮点型运算结果失真的问题，比如0.1+0.2!=0.3
        BigDecimal bd1 = new java.math.BigDecimal("0.1");  // 构造时候一定传入字符串 要不然double类型会失真
        BigDecimal bd2 = BigDecimal.valueOf(0.2); // 传入double类型要用BigDecimal.valueOf()  底层会先转字符串再转BigDecimal ;这个也是推荐方式
        BigDecimal bd3 = BigDecimal.valueOf(0.3); //  加法
        System.out.println("0.1+0.2=" + (0.1+0.2));
        System.out.println("BigDecimal 0.1+0.2=" + bd1.add(bd2));

        System.out.println("BigDecimal 0.1-0.2=" + bd1.subtract(bd2));
        System.out.println("BigDecimal 0.1*0.2=" + bd1.multiply(bd2));
        System.out.println("BigDecimal 0.1/0.2=" + bd1.divide(bd2));

        // System.out.println("BigDecimal 0.1/0.3=" + bd1.divide(bd3)); // 这里无法做到精确运算 执行会报错
        System.out.println("BigDecimal 0.1/0.3=" + bd1.divide(bd3, 2,RoundingMode.HALF_UP)); // 精确运算 保留两位小数 四舍五入


    }
}







































