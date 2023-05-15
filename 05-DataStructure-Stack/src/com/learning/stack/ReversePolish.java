package com.learning.stack;

import java.util.Stack;

/**
 * 逆波兰表达式
 * 150. Evaluate Reverse Polish Notation
 *
 * @author : [Sammy]
 * @version : [v1.0]
 * @createTime : [2023/5/12 10:53]
 */
public class ReversePolish {
	public int evalRPN(String[] tokens) {
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < tokens.length; i++) {
			String str = tokens[i];
			if (str.equals("+")) {
				stack.push(stack.pop() + stack.pop());
			} else if (str.equals("-")) {
				stack.push(-stack.pop() + stack.pop());
			} else if (str.equals("*")) {
				stack.push(stack.pop() * stack.pop());
			} else if (str.equals("/")) {
				int temp1 = stack.pop();
				int temp2 = stack.pop();
				stack.push(temp2 / temp1);
			} else {
				stack.push(Integer.valueOf(str));
			}
		}
		return stack.pop();
	}
}
