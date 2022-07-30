package com.learning.test;

/**
 * @Package: com.learning.test
 * @Description: VariTest
 * @Author: Sammy
 * @Date: 2022/7/11 17:03
 */

public class VariTest {
	private static int a = 0;

	public void amethod() {
		this.a =22;
		System.out.println("method a:"+a);
	}

	public void bmethod() {
		this.a++;
		System.out.println("method b:"+a);
	}

	public static void main(String[] args) {
		VariTest testobject = new VariTest();
		testobject.amethod();
		VariTest testobject1 = new VariTest();

		testobject1.bmethod();
	}
}
