package com.multithreading.mt3;

public class MyRunnable implements Runnable{
	public void run() {
		System.out.println( Thread.currentThread().getName() + "--> 输出666");
		try {
			Thread.sleep(1000);
			// Thread.sleep(Integer.MAX_VALUE); // 模拟临时线程创建
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
