package com.multithreading.mt5;

import java.util.concurrent.atomic.AtomicInteger;

public class MyRunnable1 implements Runnable{
//    private int count;
    private AtomicInteger count = new AtomicInteger();
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("count --->" + (count.incrementAndGet()));
        };
    }
}
