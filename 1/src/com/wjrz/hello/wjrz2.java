package com.wjrz.hello;

public class wjrz2 {
    public static void main(String[] args) {
        System.out.println("1 日志技术");
        // 可以将系统执行信息，方便的记录到指定的位置（控制台、文件、数据库）
        // 方便启停

        System.out.println();
        System.out.println("2 日志框架");
        // 日志框架：log4j、logback、JUL（java.util.logging;java提供）、其他实现
        // 日志接口：设计日志框架的一套标准，日志框架需要实现这些接口 以降低框架的学习难度
        // 程序员只需要面向日志接口编程 框架可以随意挑选

        // 日志接口：simple logging facade for java（slf4j）、commons-logging（JCL）
        // Logback日志框架官方网站：https://logback.qos.ch/index.html
        // logback框架模块：logback-core（核心基础）、logback-classic（完整实现slf4j的api）、logback-access（提供http访问日志的功能）
        // 使用logback框架必须在项目中整合：slf4j + logback-classic + logback-core

        System.out.println();
        System.out.println("3 logback快速入门");

        // 非maven下载jar包方法：
        // 在浏览器地址栏输入官方中央仓库网址并打开：mvnrepository.com
        // 搜索slf4j-api、logback-classic、logback-core
        // 在版本列表中，找到并点击需要下载的版本，进入版本详情页面
        // 找到中间的 Files 这一行，点击蓝色的 jar 按钮

        // 1. 添加依赖：slf4j-api、logback-classic、logback-core 放到lib目录下后右击添加为库
        // 2. 配置文件：logback.xml 必须方法到src下面 这里放到了1/src/xml/logback.xml
        // 3. 使用创建Logback框架提供的Logger对象 然后用Logger对象调用其提供的方法就可以记录系统日志
        //     1/src/com/wjrz/wjrz2/LogBackTest.java 测试类：演示如何使用logback框架记录日志

        System.out.println();
        System.out.println("4 logback配置文件");
        // logback.xml 配置文件详解见：1/src/logback.xml

        System.out.println();
        System.out.println("5 日志级别");
        // 日志级别：TRACE < DEBUG < INFO < WARN < ERROR 代表日志的重要性





    }
}
