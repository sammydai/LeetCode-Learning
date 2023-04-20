package com.learning.thread;

/**
 * @Package: com.learning.thread
 * @Description: 2个线程交替打印ABAB, 50次
 * @Author: Sammy
 * @Date: 2023/4/14 09:48
 */

public class ThreadDemo3 {

	private static Object lock = new Object();

	private static int count = 0;

	public static void main(String[] args) {
		Thread threadA = new Thread(new PrintCharA());
		Thread threadB = new Thread(new PrintCharB());
		threadA.start();
		threadB.start();
	}

	static class PrintCharA implements Runnable {

		@Override
		public void run() {
			while (true) {
				if (count <= 50) {
					synchronized (lock) {
						lock.notify();
						System.out.println(Thread.currentThread().getName() + " --> A");
						count++;
						try {
							lock.wait();
						} catch (InterruptedException e) {
							throw new RuntimeException(e);
						}
					}
				} else {
					break;
				}
			}
		}
	}

	static class PrintCharB implements Runnable {

		@Override
		public void run() {
			while (true) {
				if (count <= 50) {
					synchronized (lock) {
						lock.notify();
						System.out.println(Thread.currentThread().getName() + " --> B");
						count++;
						try {
							lock.wait();
						} catch (InterruptedException e) {
							throw new RuntimeException(e);
						}
					}
				} else {
					break;
				}
			}
		}
	}
}
