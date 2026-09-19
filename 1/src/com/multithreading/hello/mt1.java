package com.multithreading.hello;

import com.multithreading.mt1.Account;
import com.multithreading.mt1.DrawThread;

public class mt1 {
    public static void main(String[] args) {
        System.out.println("1 线程安全 ");
        // 概念：多个线程，同时操作同一个共享资源的时候，可能会出现业务安全问题，现象如下：小明小红同时取钱

//        Account acc = new Account("123456789", 100000);
//
//        new DrawThread(acc,"小明").start();
//        new DrawThread(acc,"小红").start();


        System.out.println();
        System.out.println("2 线程同步");
        // 线程同步：解决线程安全问题
        // 线程同步的思想：让多个线程实现先后依次访问共享资源，这样就解决了安全问题
        // 常见方案：
        //     加锁：每次只允许一个线程加锁，加锁后才能进入访问，访问完毕后自动解锁，然后其他线程才能再加锁进来

        // 加锁方式1：同步代码块
        // 把访问共享资源的核心代码给上锁，以此保证线程安全
        // 原理：每次只允许一个线程加锁后进入，执行完毕后自动解锁，其他线程才可以进来执行
        // 格式：synchronized(同步锁){
        //      // 访问共享资源的核心代码
        // }

        // 同步锁注意事项：对于当前同时执行的线程来说，同步锁必须是同一把（同一个对象），否则会出bug

//        Account acc = new Account("123456789", 100000);
//
//        new DrawThread(acc,"小明").start();
//        new DrawThread(acc,"小红").start();
//
//        Account acc1 = new Account("132456769", 100000);
//
//        new DrawThread(acc1,"小黑").start();
//        new DrawThread(acc1,"小白").start();

        // 直接用黑马锁不好 因为此时这个锁会锁住所有账户，导致所有账户都得依次取钱
        // 直接用账户类this锁 好处是每个账户都有自己的锁，不会锁住其他账户 也就是 小明小红一把锁 小黑小白一把锁
        // 如果是静态方法就用 类名.class锁

        // 锁对象随便选择一个唯一对象好不好：不好，会影响其他无关线程的执行
        // 锁的使用规范：
        //     建议使用共享资源作为锁对象，对于实例方法建议使用this作为锁对象
        //     对于静态方法建议使用字节码（类名.class）对象作为锁对象



        // 加锁方式2：同步方法
        // 作用：把访问共享资源的核心方法给上锁，以此保证线程安全
        // 格式：public synchronized void 方法名(参数列表){
        //      // 访问共享资源的核心代码
        // }
        // 原理：每次只允许一个线程加锁后进入，执行完毕后自动解锁，其他线程才可以进来执行

//        Account acc = new Account("123456789", 100000);
//
//        new DrawThread(acc,"小明").start();
//        new DrawThread(acc,"小红").start();
//
//        Account acc1 = new Account("132456769", 100000);
//
//        new DrawThread(acc1,"小黑").start();
//        new DrawThread(acc1,"小白").start();

        // 同步方法的底层原理:
        // 同步方法其实底层也是有隐式锁对象的，只是锁的范围是整个方法代码。
        //      如果方法是实例方法:同步方法默认用this作为的锁对象。
        //      如果方法是静态方法:同步方法默认用类名.class作为的锁对象。

        // 其实锁的范围越小 代码性能越好；同步代码块比同步方法好
        // 对于现在计算机来说这点性能损耗可以忽略不计 同步方法可读性更好




        // 加锁方式3：lock锁
        // Lock锁是JDK5开始提供的一个新的锁定操作，通过它可以创建出锁对象进行加锁和解锁，更灵活、方便、强大
        // Lock是接口，不能直接实例化，可以采用它的实现类ReentrantLock来构建Lock锁对象

        Account acc = new Account("123456789", 100000);

        new DrawThread(acc,"小明").start();
        new DrawThread(acc,"小红").start();

        Account acc1 = new Account("132456769", 100000);

        new DrawThread(acc1,"小黑").start();
        new DrawThread(acc1,"小白").start();
































    }
}
