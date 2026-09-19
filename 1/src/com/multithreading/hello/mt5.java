package com.multithreading.hello;

import com.multithreading.mt5.MyRunnable;
import com.multithreading.mt5.MyRunnable1;

public class mt5 {
    public static void main(String[] args) {
        System.out.println("1 乐观锁");
        // 悲观锁，乐观锁原理：
        //     悲观锁：一上来就加锁，没有安全感。每次只能一个线程进入访问完毕后，再解锁。线程安全，性能较差。
        //     乐观锁：一开始不上锁，认为是没有问题的，大家一起跑，等要出现线程安全问题的时候才开始控制。线程安全，性能较好。

        // 需求：1个静态变量，100个线程，每个线程对其加100次
        // 线程安全问题 不是每次出现 多执行几次才会出现

        // 悲观锁
//        Runnable staget = new MyRunnable();
//
//        for (int i = 0; i < 100; i++) {
//           new Thread(staget).start();
//        }

        // 乐观锁
        // CAS算法： 每次修改都记住修改前的值 当修改后准备更新时 如果发现修改前的值没有被其他线程修改过 则更新成功
        //          如果发现修改前的值被其他线程修改过 则更新作废重新来一遍
        // 整数修改的乐观锁：原子类实现AtomicInteger


        Runnable staget1 = new MyRunnable1();
        for (int i = 0; i < 100; i++) {
           new Thread(staget1).start();
        }


    }
}
