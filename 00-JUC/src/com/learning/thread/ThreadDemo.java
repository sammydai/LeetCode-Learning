package com.learning.thread;

/**
 * @Package: com.learning.juc
 * @Description: 打印 ABCABCABC
 * @Author: Sammy
 * @Date: 2023/3/31 23:47
 */

public class ThreadDemo {

	private static volatile int COUNT = 0;

	private static Object lock = new Object();

	/**
	 * 编写一个程序，启动三个线程，三个线程的ID分别是A，B，C；，
	 * 每个线程将自己的ID值在屏幕上打印5遍，打印顺序是ABCABC...
	 */
	public static void main(String[] args) {

		Thread threadA = new Thread(() -> {
			for (int i = 0; i < 5; i++) {
				synchronized (lock) {
					while (COUNT % 3 != 0) {
						try {
							lock.wait();
						} catch (InterruptedException e) {
							throw new RuntimeException(e);
						}
					}
					System.out.println(Thread.currentThread().getName());
					COUNT++;
					lock.notifyAll();
				}
			}
		}, "A");
		Thread threadB = new Thread(() -> {
			for (int i = 0; i < 5; i++) {
				synchronized (lock) {
					while (COUNT % 3 != 1) {
						try {
							lock.wait();
						} catch (InterruptedException e) {
							throw new RuntimeException(e);
						}
					}
					System.out.println(Thread.currentThread().getName());
					COUNT++;
					lock.notifyAll();
				}
			}
		}, "B");
		Thread threadC = new Thread(() -> {
			for (int i = 0; i < 5; i++) {
				synchronized (lock) {
					while (COUNT % 3 != 2) {
						try {
							lock.wait();
						} catch (InterruptedException e) {
							throw new RuntimeException(e);
						}
					}
					System.out.println(Thread.currentThread().getName());
					COUNT++;
					lock.notifyAll();
				}
			}
		}, "C");
		threadA.start();
		threadB.start();
		threadC.start();
	}
}



