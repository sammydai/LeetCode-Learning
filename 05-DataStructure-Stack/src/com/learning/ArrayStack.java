package com.learning;

import java.util.ArrayList;

/**
 * @Package: com.learning
 * @Description: ArrayStack
 * @Author: Sammy
 * @Date: 2020/11/14 10:53
 */

public class ArrayStack {
	private String[] items;
	private int count;
	private int n;

	public ArrayStack(int n) {
		this.n = n;
		this.items = new String[n];
		this.count = 0;
	}

	public String pop() {
		if (count==0) {
			System.out.println("stack is empty");
			return null;
		}
		String temp = items[count-1];
		count--;
		return temp;
	}

	public boolean push(String item) {
		if (count==n) {
			System.out.println("stack is full");
			return false;
		}
		items[count] = item;
		count++;
		return true;
	}

	public static void main(String[] args) {
		ArrayStack arrayStack = new ArrayStack(5);
		arrayStack.push("todo");
		arrayStack.push("mackbook pro");
		arrayStack.push("abcde");
		System.out.println(arrayStack.pop());
	}
}
