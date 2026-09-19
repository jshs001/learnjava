package com.multithreading.hello;

import com.multithreading.mt3.MyCallable;
import com.multithreading.mt3.MyRunnable;

import java.util.concurrent.*;

public class mt3 {
    public static void main(String[] args) throws Exception {
        System.out.println("1 线程池和创建");
        // 线程池：就是一个可以复用线程的技术
        // 不用线程池问题：用户每发起一个请求，后台就要创建一个新的线程来处理，下次新任务来了肯定又要创建新线程处理的。而创建新线程
        //     的开销是很大的，并且请求过多时，肯定会产生大量的线程出来，这样会严重影响系统性能

        // 工作原理：维护一定数量的线程，和任务队列，当有任务来时，先检查线程池中是否有空闲线程，如果有则分配一个线程执行任务，
        //      如果没有则将任务放入任务队列中，等待线程池中的线程空闲时再执行。
        //      任务队列和工作线程都是有一定数量限制的，不会无限增长，所以避免了系统资源耗尽


        // 线程池创建方式1 ： ExecutorService线程池接口的实现类ThreadPoolExecutor 的有参构造器自创建一个线程池对象

        // public ThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit,
        // BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory, RejectedExecutionHandler handler)
        // 7个参数的作用：
                // 核心线程数
                // 最大线程数
                // 临时线程存活时间
                // 临时线程存活时间单位
                // 指定线程池的任务队列
                // 指定线程池的线程工厂
                // 指定线程池的任务拒绝策略

//        ExecutorService pool = new ThreadPoolExecutor(
//                3, // 核心线程数
//                5, // 最大线程数
//                8, // 临时线程存活时间
//                TimeUnit.SECONDS, // 临时线程存活时间单位
//                new ArrayBlockingQueue<>(4) ,// 指定线程池的任务队列
//                Executors.defaultThreadFactory(), // 指定线程池的线程工厂
//                new ThreadPoolExecutor.AbortPolicy() // 指定线程池的任务拒绝策略
//        );
        // 注意：
        //   新任务提交时候发现核心线程都在忙，任务队列也满了，并且还可以创建临时线程，此时才会创建临时线程。
        //   核心线程和临时线程都在忙，任务队列也满了，新任务过来时候才会开始拒绝任务


        System.out.println();
        System.out.println("2 线程池处理Runnable任务");
//        Runnable target = new MyRunnable();
//        pool.execute(target); // 线程池自动创建3个线程处理问题 后面两个任务会放入队列等待工作线程空闲后处理
//        pool.execute(target);
//        pool.execute(target);
//        pool.execute(target);
//        pool.execute(target);
//
//        // 模拟临时线程创建 此时三个核心线程被占满了，任务队列也满了，开始创建临时线程
////        pool.execute(target);
////        pool.execute(target);
////        pool.execute(target);
////        pool.execute(target);
////        pool.execute(target);
////        pool.execute(target);
////        pool.execute(target);
////        // 开始创建临时线程
////        pool.execute(target);
////        pool.execute(target);
////        // 拒绝任务
////        pool.execute(target);
//
//        pool.shutdown(); // 等待线程池的任务全部执行完毕后，再关闭线程池
//        // pool.shutdownNow(); // 线程池立即关闭，正在执行的任务会继续执行，但不再接受新任务
//
//        // 任务拒绝有四种策略
//        // 1. AbortPolicy 默认策略，丢弃任务并直接抛出异常
//        // 2. DiscardPolicy 丢弃任务但不抛出异常 不推荐使用
//        // 3. DiscardOldestPolicy 抛弃队列中等待最久的任务 然后把当前任务加入队列中
//        // 4. CallerRunsPolicy 由主线程负责调用任务的run方法 从而绕过线程池直接执行

        System.out.println();
        System.out.println("3 线程池处理Callable任务");

//        Future<String> f1 = pool.submit(new MyCallable(100));
//        Future<String> f2 = pool.submit(new MyCallable(200));
//        Future<String> f3 = pool.submit(new MyCallable(300));
//        Future<String> f4 = pool.submit(new MyCallable(400));
//
//        System.out.println(f1.get());
//        System.out.println(f2.get());
//        System.out.println(f3.get());
//        System.out.println(f4.get());

        System.out.println();
        System.out.println("4 Executor创建线程池");
        // Executors是线程池的工具类，提供了很多静态方法用于返回不同特点的线程池对象
        // 1 newFixedThreadPool 创建一个固定大小的线程池 如果某个线程执行异常结束了，那么线程池会补充一个新的线程替代它
        // 2 newSingleThreadExecutor 创建一个单线程的线程池 如果某个线程执行异常结束了，那么线程池会补充一个新的线程替代它
        // 3 newCachedThreadPool 线程数量随着任务增加而增加，如果线程任务执行完毕且空闲了60s则会被回收掉
        // 4 newScheduledThreadPool 创建一个线程池，可以实现在给定的延迟后运行任务或者定期执行任务。
        // 注意：这些方法的底层，都是通过线程池的实现类ThreadPoolExecutor来创建线程池对象

        ExecutorService pool2 = Executors.newFixedThreadPool(3);


        Future<String> f1 = pool2.submit(new MyCallable(100));
        Future<String> f2 = pool2.submit(new MyCallable(200));
        Future<String> f3 = pool2.submit(new MyCallable(300));
        Future<String> f4 = pool2.submit(new MyCallable(400));

        System.out.println(f1.get());
        System.out.println(f2.get());
        System.out.println(f3.get());
        System.out.println(f4.get());

        // 核心线程到底配置多少合适？
        //      计算密集型任务：核心线程数量 = 逻辑cpu核数+1
        //      IO密集型任务：核心线程数量 = 逻辑cpu核数*2     （如读取数据等）

        // Executors使用可能存在的陷阱
        //     大型并发系统环境中使用Executors如果不注意可能会出现系统风险
        //     1. 创建的线程数量过多，会耗尽系统资源
        //     2. 请求队列可能大量堆积，导致系统资源耗尽



    }
}
