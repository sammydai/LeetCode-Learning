package com.learning.monotone;

import java.util.Stack;

/**
 * @Package: com.learning.monotone
 * @Description: 738. Monotone Increasing Digits
 * @Author: Sammy
 * @Date: 2020/11/25 11:11
 */

public class MonotoneIncreasingDigits {
	public static void main(String[] args) {

	}

	public static int monotoneIncreasingDigits(int N) {
		if (isMonotone(N)) {
			return N;
		} else {
			while (N-->0) {
				if (isMonotone(N)) {
					return N;
				}
			}
		}
		return 0;
    }

	public static boolean isMonotone(int n) {
		String ss = String.valueOf(n);
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < ss.length(); i++) {
			int i1 = Integer.parseInt(String.valueOf(ss.charAt(i)));
			if (stack.isEmpty() || stack.peek() <= i1) {
				stack.push(i1);
			} else {
				System.out.println();
				return false;
			}
		}
		return true;
	}
}
