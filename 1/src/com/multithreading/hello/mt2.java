package com.multithreading.hello;

import com.multithreading.mt2.Desk;

public class mt2 {
    public static void main(String[] args) {
        System.out.println("1 线程通信");
        // 多个线程共同操作共享资源时，线程间通过某种方式互相告知自己的状态，以互相协调，并避免无效的资源争夺

        // 线程通信常见模型（生产者与消费者模型）
        //      生产者线程负责生产数据，消费者线程负责消费数据
        //      注意：生产者生产完数据应该等待自己，通知消费者消费；消费者消费完数据也应该等待自己，再通知生产者生产

        Desk desk = new Desk();

        new Thread(() ->{
            while (true) {
                desk.put();
            }
        } ,"厨师1").start();
        new Thread(() ->{
            while (true) {
            desk.put();
            }
        } ,"厨师2").start();
        new Thread(() ->{
            while (true) {
                desk.put();
            }
        } ,"厨师3").start();

        new Thread(() ->{
            while (true) {
                desk.get();
            }
        } ,"吃货1").start();
        new Thread(() ->{
            while (true) {
                desk.get();
            }
        } ,"吃货2").start();



































    }
}
