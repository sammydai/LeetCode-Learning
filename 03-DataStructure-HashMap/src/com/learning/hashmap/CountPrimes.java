package com.learning.hashmap;

import java.util.HashSet;

/**
 * @Package: com.learning.hashmap
 * @Description: 204. Count Primes
 * 				 202. Happy Number
 * @Author: Sammy
 * @Date: 2020/11/17 09:48
 */

public class CountPrimes {

    public boolean isHappy(int n) {
		if(n == 1)return true;
		int temp = n;
		int sum = 0;
		while (sum != 1) {
			sum = 0;
			while (temp != 0) {
				int i = temp % 10;
				sum += i * i;
				temp /= 10;
			}
			if (sum == n) {
				return false;
			}
			if (sum == 4) {
				return false;
			}
			temp = sum;
		}
		return true;
	}

	public boolean isHappySet(int n) {
		if(n == 1)return true;
		HashSet<Integer> hset = new HashSet<>();
		hset.add(n);
		int temp = n;
		int sum = 0;
		while (sum != 1) {
			sum = 0;
			while (temp != 0) {
				int i = temp % 10;
				sum += i * i;
				temp /= 10;
			}
			if (hset.contains(sum)) {
				return false;
			}
			hset.add(sum);
			temp = sum;
		}
		return true;
	}

	class Solution {
		public boolean isHappy(int n) {
			if (n == 1) return true;
			HashSet<Integer> hset = new HashSet<>();
			while (n != 1 && !hset.contains(n)) {
				hset.add(n);
				n = getNextNum(n);
			}
			return n == 1;
		}

		private int getNextNum(int n) {
			int res = 0;
			while (n != 0) {
				int temp = n % 10;
				res += temp * temp;
				n = n / 10;
			}
			return res;
		}
	}
}
