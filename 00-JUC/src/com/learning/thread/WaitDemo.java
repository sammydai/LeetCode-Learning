package com.learning.thread;

/**
 * @Package: com.learning.juc
 * @Description: WaitDemo wait(),notify()
 * @Author: Sammy
 * @Date: 2023/3/31 22:29
 */

public class WaitDemo {
	public static void main(String[] args) {
		Object lock = new Object();
		Thread thread1 = new Thread(() -> {
			synchronized (lock) {
				try {
					lock.wait();
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}
				System.out.println(Thread.currentThread().getName() + "执行完了");
			}
		});
		Thread thread2 = new Thread(() -> {
			synchronized (lock) {
				try {
					lock.wait();
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}
				System.out.println(Thread.currentThread().getName() + "执行完了");
			}
		});
		Thread thread3 = new Thread(() -> {
			synchronized (lock) {
				try {
					lock.wait();
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}
				System.out.println(Thread.currentThread().getName() + "执行完了");
			}
		});
		Thread thread4 = new Thread(() -> {
			synchronized (lock) {
				lock.notifyAll();
				// lock.notify();
				System.out.println(Thread.currentThread().getName() + "执行notifyAll的效果");
			}
		});
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
	}
}
