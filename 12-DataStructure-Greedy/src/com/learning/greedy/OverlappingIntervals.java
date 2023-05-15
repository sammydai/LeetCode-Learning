package com.learning.greedy;

import java.util.Arrays;

/**
 * 类似打气球的题目，把没有交叠的区间计算出来=res，用总区间-没有交叠区间
 * 435. Non-overlapping Intervals
 *
 * @author : [Sammy]
 * @version : [v1.0]
 * @createTime : [2023/5/15 21:55]
 */
public class OverlappingIntervals {
	public int eraseOverlapIntervals(int[][] intervals) {
		Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
		//初始化res=1，默认第一个值是没有交叠的区间，从第二个区间开始计算
		int res = 1;
		for (int i = 1; i < intervals.length; i++) {
			if (intervals[i][0] >= intervals[i - 1][1]) {
				res++;
				continue;
			} else {
				intervals[i][1] = Math.min(intervals[i][1], intervals[i - 1][1]);
			}
		}
		return intervals.length - res;
	}
}
