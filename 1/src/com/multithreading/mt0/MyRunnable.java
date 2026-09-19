package com.multithreading.mt0;
// 定义MyRunnable类实现Runnable接口并重run方法
public class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("MyRunnable线程输出：" + i );
        }
    }
}
