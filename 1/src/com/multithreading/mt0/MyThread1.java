package com.multithreading.mt0;
// 继承Thread类 并重写run方法
public class MyThread1 extends Thread {
    public MyThread1(String name) {
        super(name);
    }
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("MyThread线程"+ this.getName() + "输出：" + i );
        }
    }
}
