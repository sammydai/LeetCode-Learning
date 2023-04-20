package com.learning.thread;

/**
 * @Package: com.learning.juc
 * @Description: A 1 B 1,2,3 A 2,A3
 * @Author: Sammy
 * @Date: 2023/4/3 23:50
 */

public class ThreadDemo5 {

	private static Object lock = new Object();

	public static void main(String[] args) {

		Thread threadA = new Thread(() -> {
			synchronized (lock) {
				lock.notifyAll();
				System.out.println(Thread.currentThread().getName() + "1");
				try {
					lock.wait();
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}
				System.out.println(Thread.currentThread().getName() + "2");
				System.out.println(Thread.currentThread().getName() + "3");
			}
		}, "thread-A");
		Thread threadB = new Thread(() -> {
			synchronized (lock) {
				lock.notifyAll();
				System.out.println(Thread.currentThread().getName() + "1");
				System.out.println(Thread.currentThread().getName() + "2");
				System.out.println(Thread.currentThread().getName() + "3");
			}
		}, "thread-B");
		threadA.start();
		threadB.start();
	}
}
