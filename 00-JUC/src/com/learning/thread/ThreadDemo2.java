package com.learning.thread;


/**
 * @Package: com.learning.thread
 * @Description: 2个线程分别打印1-100
 * @Author: Sammy
 * @Date: 2023/4/13 10:55
 */

public class ThreadDemo2 {

	public static void main(String[] args) {
		ThreadTest threadTarget = new ThreadTest();
		Thread threadA = new Thread(threadTarget, "threadA");
		Thread threadB = new Thread(threadTarget, "threadB");
		threadA.start();
		threadB.start();
		PrintMode printNum = new PrintMode();
		Thread t1 = new Thread(printNum);
		Thread t2 = new Thread(printNum);
		t1.start();
		t2.start();
	}

	static class ThreadTest implements Runnable {
		private Object lock = new Object();

		@Override
		public void run() {
			synchronized (lock) {
				for (int i = 0; i <= 100; i++) {
					System.out.println(Thread.currentThread().getName() + " --> " + i);
				}
			}
		}
	}
}

class PrintMode implements Runnable {

	@Override
	public void run() {
		//进入资源临界区，使用加锁功能
		synchronized (this) {
			for (int i = 0; i < 10; i++) {
				System.out.println(Thread.currentThread().getName() + " " + i);
			}
		}
	}
}
