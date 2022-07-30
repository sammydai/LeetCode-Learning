package com.learning.array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Package: com.learning.array
 * @Description: 435. Non-overlapping Intervals
 * @Author: Sammy
 * @Date: 2022/7/31 01:14
 */

public class EraseOverlapIntervals {
	public int eraseOverlapIntervals(int[][] intervals) {
		if (intervals.length == 0)  return 0;
		Arrays.sort(intervals, new Comparator<int[]>() {
			@Override
			public int compare(int[] arr1, int[] arr2) {
				return Integer.compare(arr1[0], arr2[0]);
			}
		});
		int count = 0;
		for (int i = 0; i < intervals.length-1; i++) {
			//此时第一个一维数组第一个数字肯定小于或等于第二个一位数组的第一个数字(刚排序了的)
			//此时我们分为三种情况：
			//1.第一个一维数组第二个数字小于或等于第二个一维数组第一个数字
			//比如：[1,2][2,3]。这种情况题目是允许的，不操作，直接进入下一次循环。

			//2.第一个一维数组第二个数字小于或等于第二个一维数组第二个数字
			//比如:[1,2],[1,3]或[1,3],[1,3]。此时要排除第二个数组(排除大的,那么和之后的数组区间重合的几率就要小)
			//直接将count++,将第一个数组赋值给第二个数组

			//3.第一个一维数组第二个数字大于第二个一维数组第二个数字
			//直接将count++,此时移除第一个数组(因为我们是递增的不需要操作)，而且2,3的count++可以合并
			if (intervals[i][1] <= intervals[i + 1][0]) {
				continue;
			} else if (intervals[i][1] <= intervals[i + 1][1]) {
				intervals[i+1][0]=intervals[i][0];
				intervals[i+1][1]=intervals[i][1];
			}
			count++;
		}
		return count;
	}


	public static void main(String[] args) {
		int[][] testcase = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
		int i = new EraseOverlapIntervals().eraseOverlapIntervals(testcase);
	}
}
