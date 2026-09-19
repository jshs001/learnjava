package com.wjrz.wjrz2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogBackTest {
    // 创建一个Logger日志对象
    private static final Logger LOGGER = LoggerFactory.getLogger("LogBackTest");

    public static void main(String[] args) {
//        try {
//            LOGGER.info("开始执行");
//            LOGGER.info("执行chu方法");
//            chu(10, 0);
//            LOGGER.info("执行结束");
//        } catch (Exception e) {
////            e.printStackTrace();
//            LOGGER.error("执行出错,出现了bug");
//        }

        // 测试日志文件拆分
        while (true) {
            try {
                LOGGER.info("开始执行");
                LOGGER.info("执行chu方法");
                chu(10, 0);
                LOGGER.info("执行结束");
            } catch (Exception e) {
    //            e.printStackTrace();
                LOGGER.error("执行出错,出现了bug");
            }
        }
    }

    public static void chu(int a, int b) {
        LOGGER.debug("参数a:" + a);
        LOGGER.debug("参数b:" + b);
        int c = a / b;
//        System.out.println( "结果是：" + c);
        LOGGER.info("结果是：" + c);
    }
}
