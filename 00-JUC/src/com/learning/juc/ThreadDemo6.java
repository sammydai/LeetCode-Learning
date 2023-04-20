package com.learning.juc;

/**
 * @Package: com.learning.juc
 * @Description: 编写10个线程，第一个线程从1加到10，
 * 第二个线程从11加20…第十个线程从91加到100，
 * 最后再把10个线程结果相加。
 * @Author: Sammy
 * @Date: 2023/3/31 23:26
 */

public class ThreadDemo6 {

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			ThreadAdd threadAdd = new ThreadAdd(i);
			new Thread(threadAdd, "thread-" + i).start();
		}
	}
}

class ThreadAdd implements Runnable {

	private static int sum = 0;

	private static Object lock = new Object();

	private int time;

	public ThreadAdd(int time) {
		this.time = time;
	}

	@Override
	public void run() {
		int tempSum = 0;
		for (int i1 = 1; i1 <= 10; i1++) {
			tempSum += time * 10 + i1;
		}
		sum += tempSum;
		System.out.println(Thread.currentThread().getName() + " : " + tempSum);
		if (time == 9) {
			System.out.println(sum);
		}
		// while (true) {
		// 	if () {
		// 	} else {
		// 		break;
		// 	}
		// }
	}
}
