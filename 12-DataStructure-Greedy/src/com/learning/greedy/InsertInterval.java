package com.learning.greedy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Package: com.learning.array
 * @Description: 57. Insert Interval
 * @Author: Sammy
 * @Date: 2022/7/30 23:21
 */

public class InsertInterval {
	public int[][] insert(int[][] intervals, int[] newInterval) {
		List<int[]> ret = new ArrayList<>();
		int[] prev = newInterval;
		for (int[] inter : intervals) {
			if (prev[1]<inter[0]) {
				ret.add(prev);
				prev = inter;
			} else if (inter[1]<prev[0]) {
				ret.add(inter);
			} else {
				prev[0] = Math.min(prev[0],inter[0]);
				prev[1] = Math.max(prev[1],inter[1]);
			}
		}
		ret.add(prev);
		return ret.toArray(new int[ret.size()][2]);
	}


	public int[][] insertAnother(int[][] intervals, int[] newInterval) {
		List<int[]> result = new LinkedList<>();
		int i = 0;
		// add all the intervals ending before newInterval starts
		//现在看重叠的。我们反过来想，没重叠，就要满足：绿区间的左端，落在蓝区间的屁股的后面，反之就有重叠：绿区间的左端 <= 蓝区间的右端，极端的例子就是 [8,10]。

		while (i < intervals.length && intervals[i][1] < newInterval[0]) {
			result.add(intervals[i]);
			i++;
		}

		// merge all overlapping intervals to one considering newInterval
		while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
			// we could mutate newInterval here also
			newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
			newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
			i++;
		}

		// add the union of intervals we got
		result.add(newInterval);

		// add all the rest
		while (i < intervals.length) {
			result.add(intervals[i]);
			i++;
		}

		return result.toArray(new int[result.size()][]);
	}

	public static void main(String[] args) {
		int[] insert = {2, 5};
		int[][] valuetest = {{1, 3}, {6, 9}};
		int[][] result = new InsertInterval().insertAnother(valuetest, insert);
		for (int[] ints : result) {
			for (int anInt : ints) {
				System.out.println(anInt);
			}
		}
	}
}
