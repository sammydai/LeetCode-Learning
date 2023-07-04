package com.learning.thread;

/**
 * [一句话描述该类的功能]
 *
 * @author : [Sammy]
 * @version : [v1.0]
 * @createTime : [2023/6/1 16:40]
 */
public class ThreadLocalDemo {

	public static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();

	public static ThreadLocal<Integer> seqNum = new ThreadLocal<Integer>() {
		@Override
		protected Integer initialValue() {
			return 0;
		}
	};

	public static Integer getNexNum() {
		seqNum.set(seqNum.get() + 1);
		return (Integer) seqNum.get();
	}

	public static void main(String[] args) {
		Thread threadA = new Thread(() -> {
			threadLocal.set(20);
			System.out.println(Thread.currentThread().getName() + " : " + threadLocal.get());
		});
		threadA.start();
		Thread threadB = new Thread(() -> {
			threadLocal.set(76);
			System.out.println(Thread.currentThread().getName() + " : " + threadLocal.get());
		});
		threadB.start();
	}
}
