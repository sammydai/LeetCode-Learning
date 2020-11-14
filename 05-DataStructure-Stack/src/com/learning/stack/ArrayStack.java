package com.learning.stack;

import java.util.Stack;

/**
 * @Package: com.learning.stack
 * @Description: GeekTime:Stack ArrayStack
 * 				 946. Validate Stack Sequences
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

	public ArrayStack() {
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

	public boolean validateStackSequences(int[] pushed, int[] popped) {
		int left = 0;
		int right = 0;
		Stack<Integer> stack = new Stack<>();
		while (true) {
			if (left<pushed.length && stack.peek()!=popped[right]) {
				stack.push(pushed[left++]);
			}
			if (left == pushed.length) {
				break;
			}
			while (!stack.isEmpty() && stack.peek() == popped[right]) {
				stack.pop();
				right++;
			}
		}
		while (!stack.isEmpty() && stack.peek() == popped[right]) {
			stack.pop();
			right++;
		}
		return stack.isEmpty();
	}

	public boolean validateStackSequences2(int[] pushed, int[] popped) {
		int i = 0;
		Stack<Integer> stack = new Stack<>();
		for (int x : pushed) {
			stack.push(x);
			while (!stack.isEmpty() && stack.peek()==popped[i]) {
				stack.pop();
				i++;
			}
		}
		return stack.isEmpty();
	}

	public static void main(String[] args) {
		int[] pushed = {1, 2, 3, 4, 5};
		int[] popped = {4, 5, 3, 2, 1};
		new ArrayStack().validateStackSequences(pushed,popped);
	}
}
