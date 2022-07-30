package com.learning.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Package: com.learning.array
 * @Description: 56. Merge Intervals
 * @Author: Sammy
 * @Date: 2022/7/30 22:39
 */

public class MergeIntervals {
	public int[][] merge(int[][] intervals) {
		if (intervals.length == 1) {
			return intervals;
		}
		Arrays.sort(intervals,(i1,i2)->Integer.compare(i1[0],i2[0]));
		List<int[]> res = new ArrayList<>();
		int start = intervals[0][0];
		int end = intervals[0][1];
		for (int[] i : intervals) {
			if (end >= i[0]) {
				end = Math.max(end, i[1]);
			} else {
				res.add(new int[]{start, end});
				start = i[0];
				end = i[1];
			}
		}
		res.add(new int[]{start, end});
		return res.toArray(new int[0][]);
	}

	public int[][] mergeRead(int[][] intervals) {
		Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
		List<int[]> ret = new ArrayList<>();
		int[] prev = null;
		for (int[] inter : intervals) {
			if (prev == null || inter[0] > prev[1]) {
				ret.add(inter);
				prev = inter;
			} else if (inter[1] > prev[1]) {
				prev[1] = inter[1];
			}
		}
		return ret.toArray(new int[ret.size()][2]);
	}
}
