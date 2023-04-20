package com.learning.thread;

/**
 * @Package: com.learning.thread
 * @Description: 2个线程交替打印1-100
 * @Author: Sammy
 * @Date: 2023/4/13 10:54
 */

public class ThreadDemo1 {

	public static void main(String[] args) {
		ThreadDemo1.ThreadTest threadTarget = new ThreadDemo1.ThreadTest();
		Thread threadA = new Thread(threadTarget, "threadA");
		Thread threadB = new Thread(threadTarget, "threadB");
		threadA.start();
		threadB.start();
	}

	static class ThreadTest implements Runnable {
		private Object lock = new Object();

		private int count = 1;

		@Override
		public void run() {
			while (true) {
				if (count <= 100) {
					synchronized (lock) {
						lock.notify();
						System.out.println(Thread.currentThread().getName() + " --> " + count);
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
