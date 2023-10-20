package com.learning.thread;

/**
 * @Package: com.learning.thread
 * @Description: 2个线程交替打印ABAB, 50次
 * @Author: Sammy
 * @Date: 2023/4/14 09:48
 */

public class ThreadPrintABAB {

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

class ThreadDemo3 {
	private static Object object = new Object();

	private static volatile int number = 10;

	private Thread threadA = new Thread(() -> {
		while (true) {
			if (number > 0) {
				synchronized (object) {
					object.notifyAll();
					System.out.println("A");
					try {
						object.wait();
						number--;
					} catch (InterruptedException e) {
						throw new RuntimeException(e);
					}
				}
			} else {
				break;
			}
		}
	});

	private Thread threadB = new Thread(() -> {
		while (true) {
			if (number > 0) {
				synchronized (object) {
					object.notifyAll();
					System.out.println("B");
					try {
						object.wait();
						number--;
					} catch (InterruptedException e) {
						throw new RuntimeException(e);
					}
				}
			} else {
				break;
			}
		}
	});

	public static void main(String[] args) {
		ThreadDemo3 threadDemo3 = new ThreadDemo3();
		threadDemo3.threadA.start();
		threadDemo3.threadB.start();
	}
}
