package com.learning.stack;

import java.util.Stack;

/**
 * @Package: com.learning.stack
 * @Description: 155. Min Stack
 * @Author: Sammy
 * @Date: 2020/11/14 15:27
 */

public class MinStack {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(5);
		stack.push(9);
		stack.push(11);
		Stack<Integer> minstack = new Stack<>();
		minstack.push(5);
		minstack.push(9);
		minstack.push(11);
		if (stack.peek() == minstack.peek()) {
			System.out.println("===============");
		}
	}

	private Stack<Integer> stack = new Stack<>();
	private Stack<Integer> minStack = new Stack<>();

	/**
	 * initialize your data structure here.
	 */
	public MinStack() {

	}

	/**
	 * 如果minStack为空或者minStack栈顶元素>要入栈元素
	 * 入栈元素取代minStack，在压栈进入普通栈stack
	 * 其他元素入栈进普通栈stack
	 * @param x
	 */
	public void push(int x) {
		if (minStack.isEmpty() || x <= minStack.peek()) {
			minStack.push(x);
		}
		stack.push(x);
    }

	/**
	 * 普通栈和最小栈同push,同pop
	 * 如果minStack栈顶和stack栈顶一致
	 * 则两边栈都返回
	 */
	public void pop() {
		if (stack.peek()==minStack.peek()) {
			minStack.pop();
		}
		stack.pop();
    }

    public int top() {
		return stack.peek();
	}

    public int getMin() {
		return minStack.peek();
	}


}
