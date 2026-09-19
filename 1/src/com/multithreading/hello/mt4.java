package com.multithreading.hello;

public class mt4 {
    public static void main(String[] args) {
        System.out.println("1 并发、并行");
        // 进程： 正在运行的程序（软件），就是一个独立的进程；线程是属于进程的，一个进程可以有多个线程。
        // 进程中的多个线程是并发和并行执行的

        // 并发含义：
        //     进程中线程是由cpu负责调度执行的，但cpu能同时处理线程的数量有限，为了保证全部线程都往前执行，cpu会轮询为系统的每个线程服务，
        //     由于cpu切换的速度很快，给我们感觉这些线程在同时执行，这就是并发

        // 并行含义：
        //     在同一个时刻上，同时由多个线程在被cpu调度执行

        // 多线程到底是怎么在执行的？：并发和并行同时进行的。

        System.out.println();
        System.out.println("2 线程的生命周期");
        // 线程的生命周期：线程从生到死的过程中，经历的各种状态及状态转换。

        // java线程的状态： 6种 Thread.State; 枚举ctrl + click 进去能看到
        // NEW（新建）：线程刚被创建，但是并未启动
        // RUNNABLE（可运行）：线程已经调用了start()方法，等待cpu调度
        // BLOCKED（锁阻塞）：线程在执行的时候未竞争到锁对象，而进入阻塞状态
        // WAITING（等待）：一个线程进入Waiting状态，另一个线程调用notify或者notifyAll方法才能唤醒
        // TIMED_WAITING（计时等待）：同waiting状态，有几个方法（sleep,wait）有超时参数，调用他们将进入Timed Waiting状态
        // TERMINATED（被终止）：因为run方法正常退出而死亡，或者因为没有捕获的异常终止了run方法而死亡

        // 状态转换：
        // NEW （start()）-> RUNNABLE (执行完毕、出现异常)-> TERMINATED
        // RUNNABLE （未获得锁对象）-> BLOCKED (获得锁对象)-> RUNNABLE
        // RUNNABLE (获得锁对象调用了wait())-> WAITING (被其他线程notify()并获得锁对象)-> RUNNABLE
        // RUNNABLE （sleep、wait）-> TIMED_WAITING (sleep时间到了；wait时间到了并获得锁对象；wait时间没到，被其他线程notify()并获得锁对象)-> RUNNABLE
        // WAITING (被其他线程notify()但未获得锁对象)-> BLOCKED
        // TIMED_WAITING (wait时间到但未获得锁对象；wait时间没到，被其他线程notify()但未获得锁对象)-> BLOCKED
    }
}
