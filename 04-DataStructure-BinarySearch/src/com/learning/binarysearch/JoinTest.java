package com.learning.binarysearch;

/**
 * [一句话描述该类的功能]
 *
 * @author : [Sammy]
 * @version : [v1.0]
 * @createTime : [2023/6/14 15:20]
 */
public class JoinTest {
	public static void main(String[] args) throws InterruptedException {

		Thread t1 = new Thread(() -> {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
			System.out.println(Thread.currentThread().getName() + "is running");
		});

		Thread t2 = new Thread(() -> {
			try {
				Thread.sleep(1000);
				t1.join();
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
			System.out.println(Thread.currentThread().getName() + "is running");
		});

		Thread t3 = new Thread(() -> {
			try {
				Thread.sleep(1000);
				t2.join();
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
			System.out.println(Thread.currentThread().getName() + "is running");
		});

		t1.start();
		t2.start();
		t3.start();


		// Thread previous = Thread.currentThread();
		// for (int i = 0; i < 10; i++) {
		// 	// 将前一个线程传给写一个线程
		// 	Thread thread = new Thread(new Domino(previous), i + "");
		// 	thread.start();
		// 	previous = thread;
		// }
		// TimeUnit.SECONDS.sleep(1);
		// System.out.println(Thread.currentThread().getName() + " terminate.");
	}

	static class Domino implements Runnable {
		private Thread thread;

		public Domino(Thread thread) {
			this.thread = thread;
		}

		@Override
		public void run() {
			try {
				// 确保前一个线程先运行
				thread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + " terminate");
		}
	}
}

