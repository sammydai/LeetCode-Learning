package com.learning.greedy;

import java.util.Arrays;

/**
 * [10,16],[2,8],[1,6],[7,12]
 * 452. Minimum Number of Arrows to Burst Balloons
 *
 * @author : [Sammy]
 * @version : [v1.0]
 * @createTime : [2023/5/15 19:00]
 */
public class Balloon {
	public static void main(String[] args) {
		int[][] test = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
		System.out.println(test[0][1]);
		System.out.println(test[1][0]);
		new Balloon().findMinArrowShots(test);

	}

	public int findMinArrowShots(int[][] points) {
		Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
		int count = 1;
		for (int i = 1; i < points.length; i++) {
			if (points[i][0] > points[i - 1][1]) { //两个气球完全不挨着 [1,2] [3,4]
				count++;
			} else {
				points[i][1] = Math.min(points[i][1], points[i - 1][1]); //两个气球有交集
			}
		}
		return count;
	}
}
