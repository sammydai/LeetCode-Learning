package com.learning.demo;

/**
 * @Package: com.learning.demo
 * @Description:
 * @Author: Sammy
 * @Date: 2020/11/9 10:22
 */

public class BinarySearch {
	public static void main(String[] args) {
		int[] nums3 = {1,2,3,4,5,9};
		System.out.println("---------------");
		System.out.println(bsearch(nums3, 6, 4));
	}

	/**
	 * 注意简单二分法的三个关键点
	 *  循环条件low<=high
	 *  mid取值，不要溢出：mid = low +(high-low)/2
	 *  low,high变量取值 low=mid+1，high=mid-1, 如果直接写成low=mid会发生死循环
	 * @param a
	 * @param n
	 * @param value
	 * @return
	 */
	public static int bsearch(int[] a, int n, int value) {
		int low = 0;
		int high = n-1;
		while (low <= high) { //1. 循环退出条件
			int mid = (high+low)/2;  //2.mid 的取值
			if (a[mid] == value) {
				return mid;
			}else if (a[mid]<value){
				low = mid+1; //3.low 和 high 的更新
			}else {
				high = mid-1;
			}
		}
		return -1;
	}

	// 二分查找的递归实现
	private int bsearchInternally(int[] a, int low, int high, int value) {
		if (low > high) return -1;

		int mid =  low + ((high - low) >> 1);
		if (a[mid] == value) {
			return mid;
		} else if (a[mid] < value) {
			return bsearchInternally(a, mid+1, high, value);
		} else {
			return bsearchInternally(a, low, mid-1, value);
		}
	}
}
