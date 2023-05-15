package com.learning.monotone;

import java.util.Arrays;
import java.util.Stack;

/**
 * 739. Daily Temperatures
 *
 * @author : [Sammy]
 * @version : [v1.0]
 * @createTime : [2023/5/15 09:35]
 */
public class DailyTemperature {
	public int[] dailyTemperatures(int[] temperatures) {
		int[] res = new int[temperatures.length];
		Arrays.fill(res, 0);
		Stack<Integer> stack = new Stack<>();
		stack.push(0);
		for (int i = 1; i < temperatures.length; i++) {
			// Integer topNum = stack.peek();
			if (temperatures[i] <= temperatures[stack.peek()]) {
				stack.push(i);
			} else {
				while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
					res[stack.peek()] = i - stack.peek();
					stack.pop();
				}
				stack.push(i);
			}
		}
		return res;
	}
}
