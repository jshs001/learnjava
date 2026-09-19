package com.multithreading.mt2;

import java.util.ArrayList;
import java.util.List;

public class Desk
{
    private List<String> list = new ArrayList<>();

    public synchronized void put() { // 实例方法默认this锁 桌子对象只有一个 所以这个锁能锁5个线程
        try {
            String name = Thread.currentThread().getName();
            if(list.size() == 0){
                list.add(name + "做的肉包子");
                System.out.println(name + "做了一个肉包子~~");
                Thread.sleep(2000);

                // 等待自己 唤醒别人
                this.notifyAll();  // 一定要用锁对象 进行唤醒和等待操作
                this.wait(); // 要先唤醒再等待 要不然 自己下线了 就调用不了notifyAll方法了
            }else{
                this.notifyAll();  // 有包子不做了 唤醒别人 等待自己
                this.wait();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public synchronized void get() {
        try {
            String name = Thread.currentThread().getName();
            if(list.size() == 1){
                System.out.println(name + "吃了" + list.get(0));
                list.clear();
                Thread.sleep(1000);
                this.notifyAll();
                this.wait();
            }else{
                this.notifyAll();
                this.wait();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
