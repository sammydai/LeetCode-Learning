package com.learning.juc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @Package: com.learning.juc
 * @Description:
 * @Author: Sammy
 * @Date: 2023/4/4 00:15
 */

public class CountDownLatchDemo {
	public static void main(String[] args) throws InterruptedException {
		CountDownLatch countDownLatch = new CountDownLatch(3);
		List<Integer> list = new ArrayList<>();
		Thread threadA = new Thread(() -> {
			System.out.println(Thread.currentThread().getName() + " 在执行..");
			try {
				Thread.sleep(1000);
				countDownLatch.countDown();
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}, "thread-A");
		Thread threadB = new Thread(() -> {
			System.out.println(Thread.currentThread().getName() + " 在执行..");
			try {
				Thread.sleep(1000);
				countDownLatch.countDown();
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}, "thread-B");
		Thread threadC = new Thread(() -> {
			System.out.println(Thread.currentThread().getName() + " 在执行..");
			try {
				Thread.sleep(1000);
				countDownLatch.countDown();
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}, "thread-C");
		Thread threadD = new Thread(() -> {
			System.out.println(Thread.currentThread().getName() + " 等待其他线程执行完毕");
			try {
				countDownLatch.await();
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
			System.out.println(Thread.currentThread().getName() + "执行自己的线程工作");
		}, "thread-D");

		threadA.start();
		threadD.start();
		threadB.start();
		threadC.start();

	}
}
