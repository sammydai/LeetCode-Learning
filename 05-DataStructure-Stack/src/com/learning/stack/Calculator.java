package com.learning.stack;

import java.util.Stack;

/**
 * 224. Basic Calculator
 *
 * @author : [Sammy]
 * @version : [v1.0]
 * @createTime : [2023/5/12 15:15]
 */
public class Calculator {
	public static void main(String[] args) {

		System.out.println(new Calculator().calculate("(1+(4+5+2)-3)+(6+8) "));
	}

	public int calculate(String s) {
		Stack<Integer> nums = new Stack<Integer>();
		s = s.replaceAll(" ", "");
		int res = 0;
		int sign = 1;
		char[] cs = s.toCharArray();
		int len = s.length();
		for (int i = 0; i < len; i++) {
			char c = cs[i];
			if (c == '(') {
				// 需要先计算括号离得数字直到遇到)
				// 所以在遇到)之前需要把计算好的结果存储起来再计算
				// 先把(之前的结果入栈
				nums.push(res);
				// 重新初始化res
				res = 0;
				// 把(左边的操作符入栈
				nums.push(sign);
				sign = 1;
			} else if (c == ')') {
				int formerSign = nums.peek();
				nums.pop();
				int formerRes = nums.peek();
				nums.pop();
				res = formerRes + res * formerSign;
				// res= nums.pop()*res+nums.pop();
			} else if (Character.isDigit(c)) {
				int temp = c - '0';
				while (i + 1 < len && Character.isDigit(cs[i + 1])) {
					temp = temp * 10 + Integer.valueOf(cs[i + 1] - '0');
					i++;
				}
				res = res + sign * temp;
			} else if (c == '+') {
				sign = 1;
			} else if (c == '-') {
				sign = -1;
			}
		}
		return res;
	}

}
