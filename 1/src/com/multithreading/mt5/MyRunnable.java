package com.multithreading.mt5;

public class MyRunnable implements Runnable{
    private int count;
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
//            System.out.println(this);

            // 悲观锁
            synchronized (this) { // 这里this表示当前MyRunnable对象 用来上锁没问题
                System.out.println("count --->" + (++count));
            }
        }
    }
}
