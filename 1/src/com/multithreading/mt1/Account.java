package com.multithreading.mt1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {
    private String cardId;
    private double money;
    private final Lock lk = new ReentrantLock(); // 实例锁对象 创建属于这个账户对象的唯一的锁 ;用final修饰更安全

    public Account() {
    }

    public Account(String cardId, double money) {
        this.cardId = cardId;
        this.money = money;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public static void test() {
        synchronized (Account.class) { // 静态方法 官方推荐用这个类名.class锁
        }
    }

//    public void drawMoney(double money) {
//
//        String name = Thread.currentThread().getName();
//
//        // 模拟线程安全问题
////        if(this.money >= money){
////            System.out.println(name + "取钱" + money + "成功");
////            this.money -= money;
////            System.out.println(name + "取钱后余额为" + this.money);
////        }else{
////            System.out.println(name + "取钱余额不足");
////        }
//
//        // 方式1 同步代码块 ctrl alt T选9
////        synchronized ("黑马") {  // ""号的字符串 只有常量池里的一份
//        synchronized (this) {
//            if(this.money >= money){
//                System.out.println(name + "取钱" + money + "成功");
//                this.money -= money;
//                System.out.println(name + "取钱后余额为" + this.money);
//            }else{
//                System.out.println(name + "取钱余额不足");
//            }
//        }
//
//    }

//    // 方式2 同步方法
//    public synchronized void drawMoney(double money) {
//
//        String name = Thread.currentThread().getName();
//        if(this.money >= money){
//            System.out.println(name + "取钱" + money + "成功");
//            this.money -= money;
//            System.out.println(name + "取钱后余额为" + this.money);
//        }else{
//            System.out.println(name + "取钱余额不足");
//        }
//    }

    // 方式3 lock锁
    public void drawMoney(double money) {

        String name = Thread.currentThread().getName();

        try {    // 加锁解锁用try catch finall更健壮  保证程序异常 也会正常解锁
            lk.lock(); // 加锁
            if(this.money >= money){
                System.out.println(name + "取钱" + money + "成功");
                this.money -= money;
                System.out.println(name + "取钱后余额为" + this.money);
            }else{
                System.out.println(name + "取钱余额不足");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            lk.unlock(); // 解锁
        }

    }


}
