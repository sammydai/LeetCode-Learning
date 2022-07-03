package com.learning.binarysearch;

/**
 * @Package: com.learning.binarysearch
 * @Description: 69. Sqrt(x)
 * @Author: Sammy
 * @Date: 2022/7/3 15:58
 */

public class MySqrt {
	public int mySqrt(int x) {
		if (x==0) return 0;
		int low = 0;
		int high = 46340;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			int target = mid * mid;
			if (target<x){
				low = mid + 1;
			} else if (target > x) {
				high = mid - 1;
			} else {
				return mid;
			}
		}
		//有疑问，为什么返回high？
		return high;
    }
}
