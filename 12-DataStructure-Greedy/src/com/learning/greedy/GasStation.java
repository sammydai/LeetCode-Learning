package com.learning.greedy;

/**
 * 134. Gas Station
 *
 * @author : [Sammy]
 * @version : [v1.0]
 * @createTime : [2023/5/15 18:48]
 */
public class GasStation {
	public int canCompleteCircuit(int[] gas, int[] cost) {
		int curSum = 0;
		int totalSum = 0;
		int index = 0;
		for (int i = 0; i < gas.length; i++) {
			totalSum += (gas[i] - cost[i]);
			curSum += (gas[i] - cost[i]);
			if (curSum < 0) {
				index = i + 1;
				curSum = 0;
			}
		}
		if (totalSum < 0) return -1;
		return index;
	}
}
