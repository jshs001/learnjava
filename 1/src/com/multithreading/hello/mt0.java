package com.multithreading.hello;

import com.multithreading.mt0.MyCallable;
import com.multithreading.mt0.MyRunnable;
import com.multithreading.mt0.MyThread;
import com.multithreading.mt0.MyThread1;

import java.lang.management.ThreadInfo;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class mt0 {
    public static void main(String[] args) throws Exception {
        System.out.println("1 线程概述");
        // 概述：线程是程序内部的一条执行流程
        // 多线程：同时有多条执行流程（由逻辑cpu负责调度执行）

        // 如果一门 Java 课要把“进程”彻底讲透，老师就必须停下来，花至少 10 个课时去讲大学《操作系统》里那些晦涩难懂的理论：
        // 什么是进程控制块（PCB）？管道、信号量、共享内存的 IPC 通信原理是什么？僵尸进程、孤儿进程怎么处理？
        // 这些理论对于新手写出第一个网页、开发第一个增删改查系统没有任何直接帮助，反而极易劝退新手。
        // 课程为了让你快速上手、顺利找工作，自然会选择“战略性跳过”，把精力集中在面试高频、天天要写的多线程并发、线程锁、死锁、线程池上。

        // 多进程依然无处不在，只是它不再需要你用 Java 代码去亲手创建了。
        // 操作系统/运维工具（管进程）：利用 Docker、K8s、Nginx 或者浏览器内核，在外部把多个进程搭建好，提供一个安全的“公司外壳”。
        // Java 程序员（管线程）：进入这间特定的“公司进程”内部后，用代码去精细地控制里面的员工（线程）怎么高效干活。
        // 多进程负责系统和系统之间的“大隔离”（防崩溃、高可用），多线程负责进程内部的“小并发”（高性能、压榨 CPU）。两者结合，才构成了现在稳定的互联网世界。

        System.out.println();
        System.out.println("2 线程创建三种方式");
        // Thread类 创建线程对象
        // 方式1 ： 定义MyThread类继承Thread类并重写run方法，创建MyThread类对象，调用MyThread类对象的start方法启动线程（启动后还是执行run方法的）
//        Thread t = new MyThread(); // 创建ThreadTest1线程对象 代表一个线程
//        t.start(); // 注意main方法是主线程，t.start()是启动t线程
//
//        for (int i = 0; i < 5; i++) {
//            System.out.println("主线程main方式1 输出：" + i );
//        }
        // 优点：编码简单
        // 缺点：线程类已经继承了Thread类，无法继承其他类，不利于功能扩展

        // 注意：
        // 启动线程必须是调用start()方法，不能调用run()方法; run()方法只是线程执行的代码块。
        // 不要把主线程任务放在启动子线程之前，否则会失去多线程的意义



        // 方式2 ：定义MyRunnable类实现Runnable接口并重写run方法，创建MyRunnable类对象并交给线程对象，调用线程对象的start方法启动
//        Runnable target = new MyRunnable();
//        new Thread(target).start(); // 注意任务对象没有start方法 ，所以必须交给线程对象的有参构造器
//
//        for (int i = 0; i < 5; i++) {
//            System.out.println("主线程main方式2 输出：" + i );
//        }
        // 优点：任务类只是实现接口，可以继续继承其他类、实现其他接口，扩展性强
        // 缺点：需要多创建一个任务类

        // 方式2 的匿名内部类写法
        // 创建Runnable接口的匿名内部类对象并交给线程对象，调用线程对象的start方法启动
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 5; i++) {
//                    System.out.println("主线程main方式2匿名内部类 输出：" + i );
//                }
//            }
//        }).start();
//
//        new Thread(() ->  {
//                for (int i = 0; i < 5; i++) {
//                    System.out.println("主线程main方式2匿名内部类lambda方式 输出：" + i );
//                }
//            }
//        ).start();
//
//        for (int i = 0; i < 5; i++) {
//            System.out.println("主线程main方式2 输出：" + i );
//        }


        // 方式3：
        // 前面两种多线程重写run方法后均不能直接返回结果，run方法的返回是void

        // 定义MyCallable类实现Callable接口并重写call方法（可返回结果），
        // 创建MyCallable类对象封装成FutureTask对象（线程任务对象 此处往后等同方式2了）
        // 创建Thread对象并传入FutureTask对象，调用Thread对象的start方法启动
        // 线程执行完毕后，通过FutureTask对象的get方法取获取线程任务的执行结果
//        Callable<String> call = new MyCallable(100);
//        FutureTask<String> f1 = new FutureTask<>(call); // 为了任务对象作用：是一个任务对象，实现了Runnable接口;线程执行完毕后可用get方法获取线程任务的执行结果
//        new Thread(f1).start();
//        Callable<String> call2 = new MyCallable(200);
//        FutureTask<String> f2 = new FutureTask<>(call2); // 为了任务对象作用：是一个任务对象，实现了Runnable接口;线程执行完毕后可用get方法获取线程任务的执行结果
//        new Thread(f2).start();
//
//        try {
//            String result1 = f1.get(); // get方法会等待上线程执行完毕后 再获取线程任务的执行结果
//            String result2 = f2.get();
//            System.out.println("f1线程执行结果：" + result1  );
//            System.out.println("f2线程执行结果：" + result2  );
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        // 优点：线程任务类只是实现接口，可以继续继承类和实现接口，扩展性强；可以在线程执行完毕后去获取线程执行的结果
        // 缺点：编码复杂一点

        // 三种线程方式需要自己评估 和使用

        System.out.println();
        System.out.println("3 线程常用方法");
////        Thread t31 = new MyThread();
////        t31.setName("t31");
//        Thread t31 = new Thread("t31");  // 通过线程的有参构造器命名 需要实现类实现有参构造器方法
//        t31.start();
//        System.out.println("t31线程名：" + t31.getName()); // 获取线程名
//
////        Thread t32 = new MyThread();
////        t32.setName("t32");
//        Thread t32 = new Thread("t32");
//        t32.start();
//        System.out.println("t32线程名：" + t32  .getName()); // 获取线程名
//
//        // 主线程名
//        Thread m = Thread.currentThread();
//        m.setName("main");
//        System.out.println("主线程名：" + Thread.currentThread().getName());
//        for (int i = 0; i < 5; i++) {
//            System.out.println("主线程输出：" + i ); // 这里可以加 getName() 获取线程名  但最好是另外两个线程也加这个方法 要不然会出现不是随机顺序的情况
//        }

//        for (int i = 0; i < 5; i++) {
//            System.out.println("主线程输出：" + i );
//            try {
//                if (i == 3){
//                    Thread.sleep(5000);
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//
//        }

        Thread t1 = new MyThread1("t1");
        t1.start();
        t1.join(); // join 方法是保证调用这个方法的线程先执行完

        Thread t2 = new MyThread1("t2");
        t2.start();
        t2.join();

        Thread t3 = new MyThread1("t3");
        t3.start();
        t3.join();



























    }
}
