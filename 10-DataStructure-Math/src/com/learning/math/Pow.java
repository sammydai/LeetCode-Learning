package com.learning.math;

/**
 * 50. Pow(x, n)
 * 递归方法，先计算出 x[n/2]
 * 如果n是偶数 就是y*y
 * 如果n是奇数 就是y*y*x
 *
 * @author : [Sammy]
 * @version : [v1.0]
 * @createTime : [2023/10/30 09:59]
 */
public class Pow {
	public static double myPow(double x, int n) {
		long N = n;
		return N >= 0 ? helper(x, N) : 1.0 / helper(x, -N);
	}

	public static double helper(double x, long n) {
		if (n == 0) {
			return 1.0;
		}
		double y = helper(x, n / 2);
		return n % 2 == 0 ? y * y : y * y * x;
	}

	public static void main(String[] args) {
		int a = 6;
		System.out.println(a / 2);
		System.out.println(a % 2);
	}
}
