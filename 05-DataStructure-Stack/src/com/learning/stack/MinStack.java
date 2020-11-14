package com.learning.stack;

import java.util.Stack;

/**
 * @Package: com.learning.stack
 * @Description: 155. Min Stack
 * @Author: Sammy
 * @Date: 2020/11/14 15:27
 */

public class MinStack {

	private Stack<Integer> stack = new Stack<>();
	private Stack<Integer> minStack = new Stack<>();

	/** initialize your data structure here. */
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
