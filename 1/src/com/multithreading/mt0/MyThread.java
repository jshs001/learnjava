package com.multithreading.mt0;
// 继承Thread类 并重写run方法
public class MyThread extends Thread {
    public MyThread(String name) {
        super(name);
    }
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("MyThread线程输出：" + i );
        }
    }
}
