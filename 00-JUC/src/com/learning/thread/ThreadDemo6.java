package com.learning.thread;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.*;

/**
 * [一句话描述该类的功能]
 *
 * @author : [Sammy]
 * @version : [v1.0]
 * @createTime : [2023/6/19 09:44]
 */
public class ThreadDemo6 {
	public static void main(String[] args) throws ExecutionException, InterruptedException {
		method5();
	}

	public static void method1() {
		Thread threadA = new Thread(() -> {

			System.out.println(Thread.currentThread().getName() + "A");
		});

		Thread threadB = new Thread(() -> {
			try {
				System.out.println("waiting for A thread");
				threadA.join();
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
			System.out.println(Thread.currentThread().getName() + "B");
		});


		threadB.start();
		threadA.start();
	}

	public static void method2() {
		int worker = 3;
		CountDownLatch countDownLatch = new CountDownLatch(worker);
		Thread threadD = new Thread(() -> {
			try {
				System.out.println("D is waiting for other three threads");
				Thread.currentThread().setName("D");
				countDownLatch.await();
				System.out.println("All done, D starts working");
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
			System.out.println(Thread.currentThread().getName() + " be called");
		});
		threadD.start();

		for (char threadName = 'A'; threadName <= 'C'; threadName++) {
			char finalThreadName = threadName;
			Thread threadn = new Thread(() -> {
				Thread.currentThread().setName(String.valueOf(finalThreadName));
				System.out.println(Thread.currentThread().getName() + " is running");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}
				System.out.println(Thread.currentThread().getName() + " is finished");

				countDownLatch.countDown();
			});
			threadn.start();
		}
	}

	/**
	 * 比起CountDownLatch只能一个线程被唤醒，即ABC执行完唤醒D
	 * CyclicBarrier是能多个线程被同时唤醒
	 */
	public static void method3() {
		int worker = 3;
		CyclicBarrier cyclicBarrier = new CyclicBarrier(worker);
		for (char threadName = 'A'; threadName <= 'C'; threadName++) {
			char finalThreadName = threadName;
			Thread threadn = new Thread(() -> {
				Thread.currentThread().setName(String.valueOf(finalThreadName));
				System.out.println(Thread.currentThread().getName() + " is preparing");
				try {
					Thread.sleep(1000);
					cyclicBarrier.await();
					//等待其他BC线程执行完
					System.out.println(Thread.currentThread().getName() + " is finished");
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				} catch (BrokenBarrierException e) {
					throw new RuntimeException(e);
				}
			});
			threadn.start();
		}
	}

	public static void method4() throws ExecutionException, InterruptedException {
		Callable<Integer> threadX = new Callable<Integer>() {
			@Override
			public Integer call() throws Exception {
				int sum = 0;
				System.out.println("Task starts");
				Thread.sleep(1000);
				for (int i = 0; i <= 100; i++) {
					sum += i;
				}
				System.out.println("Task finished and return result");
				return sum;
			}
		};
		// Thread thread = new Thread((Runnable) threadX);
		// thread.start();
		//callabe是这样写的
		FutureTask<Integer> task = new FutureTask<>(threadX);
		new Thread(task).start();
		System.out.println("Before futureTask.get()");
		System.out.println("Result:" + task.get());
		System.out.println("After futureTask.get()");
	}

	public static void method5() {
		Map<String, Set> hashMap = new HashMap<>();
		Set<String> set = new HashSet<>();
		set.add("kitty");
		hashMap.put("boys", set);
		hashMap.computeIfAbsent("girls", key -> getSetInstance(key)).add("bob");
		System.out.println(hashMap.get("boys"));
		System.out.println(hashMap.get("girls"));

	}

	private static Set<String> getSetInstance(String key) {
		return new HashSet<>();
	}
}
