package com.learning.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * k numbers sum up to n
 * 216. Combination Sum III
 *
 * @author : [Sammy]
 * @version : [v1.0]
 * @createTime : [2023/5/6 18:39]
 */
public class CombinationSum3 {
	public List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> track = new ArrayList<>();
		backtracking(res, track, 1, k, n, 0);
		return res;
	}

	public void backtracking(List<List<Integer>> res, List<Integer> track, int startIndex, int k, int targetSum, int tempSum) {
		if (track.size() == k) {
			if (tempSum == targetSum) {
				res.add(new ArrayList<>(track));
			}
			return;
		}

		if (tempSum > targetSum) {
			return;
		}

		for (int i = startIndex; i <= 9; i++) {
			track.add(i);
			tempSum += i;
			backtracking(res, track, i + 1, k, targetSum, tempSum);
			tempSum -= i;
			track.remove(track.size() - 1);
		}
	}
}
