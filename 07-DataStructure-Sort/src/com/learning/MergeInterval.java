package com.learning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Package: com.learning
 * @Description: 56. Merge Intervals
 * @Author: Sammy
 * @Date: 2020/11/22 15:08
 */

public class MergeInterval {
	public int[][] merge(int[][] intervals) {
		if (intervals.length <= 1)
			return intervals;
		List<int[]> result = new ArrayList<>();
		Arrays.sort(intervals, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] != o2[0]) {
					return o1[0] - o2[0];
				} else {
					return o1[1] - o2[1];
				}
			}
		});
		for (int i = 0; i < intervals.length; i++) {
			int[] now = intervals[i];
			if (i == 0) {
				result.add(now);
			}else {
				int[] last = result.get(result.size() - 1);
				if (last[1] < now[0]) {
					result.add(now);
				} else {
					result.remove(result.size() - 1);
					int newEnd = Math.max(last[1], now[1]);
					result.add(new int[]{last[0], newEnd});
				}
			}
		}
		return result.toArray(new int[result.size()][]);
    }
}
