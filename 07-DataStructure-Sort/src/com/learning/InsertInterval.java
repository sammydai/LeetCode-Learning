package com.learning;

import java.util.ArrayList;
import java.util.List;

/**
 * @Package: com.learning
 * @Description: 57. Insert Interval
 * @Author: Sammy
 * @Date: 2020/11/22 15:44
 */

public class InsertInterval {
	/**
	 * 再读一遍
	 * @param intervals
	 * @param newInterval
	 * @return
	 */
	public int[][] insert(int[][] intervals, int[] newInterval) {
		List<int[]> result = new ArrayList<>();
		int index = 0;
		while (index < intervals.length && intervals[index][1] < newInterval[0]) {
			result.add(intervals[index++]);
		}
		while (index < intervals.length && intervals[index][0] <= newInterval[1]) {
			int newStart = Math.min(intervals[index][0],newInterval[0]);
			int newEnd = Math.max(intervals[index][1], newInterval[1]);
			newInterval = new int[]{newStart, newEnd};
			index++;
		}
		result.add(newInterval);
		while (index < intervals.length) {
			result.add(intervals[index++]);
		}
		return result.toArray(new int[result.size()][]);
    }
}
