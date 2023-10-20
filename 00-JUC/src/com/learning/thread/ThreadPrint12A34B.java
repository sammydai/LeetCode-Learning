package com.learning.thread;

/**
 * @Package: com.learning.juc
 * @Description: 写两个线程，一个线程打印1~ 52，另一个线程打印A~Z，打印顺序是12A34B...5152Z
 * @Author: Sammy
 * @Date: 2023/3/31 22:49
 */

public class ThreadPrint12A34B {

	public static Object lock = new Object();

	public static void main(String[] args) {
		Thread thread1 = new Thread(new PrintNub(), "nub");
		Thread thread2 = new Thread(new PrintChar(), "char");
		thread1.start();
		thread2.start();
	}


	static class PrintNub implements Runnable {
		private static int i = 1;

		@Override
		public void run() {
			while (true) {
				if (i <= 52) {
					synchronized (lock) {
						System.out.println(i + " " + (i + 1));
						i += 2;
						lock.notifyAll();
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

	static class PrintChar implements Runnable {

		private static char c = 'A';

		@Override
		public void run() {
			while (true) {
				if (c <= 'Z') {
					synchronized (lock) {
						System.out.println(c);
						c++;
						lock.notifyAll();
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

class ThreadDemo4 {
	private static Object object = new Object();

	private volatile int number = 1;

	private volatile char alp = 'A';

	private Thread threadNum = new Thread(() -> {
		while (true) {
			if (number <= 52) {
				synchronized (object) {
					object.notifyAll();
					System.out.println(number + " " + (number + 1));
					number += 2;
					try {
						object.wait();
					} catch (InterruptedException e) {
						throw new RuntimeException(e);
					}
				}
			}
		}
	});

	private Thread threadAlp = new Thread(() -> {
		while (true) {
			if (alp <= 'Z') {
				synchronized (object) {
					object.notifyAll();
					System.out.println(alp);
					alp++;
					try {
						object.wait();
					} catch (InterruptedException e) {
						throw new RuntimeException(e);
					}
				}

			}
		}
	});

	public static void main(String[] args) {
		new ThreadDemo4().threadNum.start();
		new ThreadDemo4().threadAlp.start();
	}
}
