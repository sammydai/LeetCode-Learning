package com.learning.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 40. Combination Sum II
 *
 * @author Sammy
 * @date 2023/05/06
 */
public class CombinationSum2 {
	public static void main(String[] args) {
		System.out.println(new CombinationSum2().combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
	}

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Arrays.sort(candidates);
		System.out.println(Arrays.toString(candidates));
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> tempResult = new ArrayList<>();
		boolean[] used = new boolean[candidates.length];
		Arrays.fill(used, false);
		backtracking(result, tempResult, candidates, target, 0, used);
		return result;
	}

	public void backtracking(List<List<Integer>> result, List<Integer> tempResult, int[] candidates, int target, int startIndex, boolean[] used) {
		if (target == 0) {
			result.add(new ArrayList<>(tempResult));
			return;
		}
		if (target < 0) {
			return;
		}
		for (int i = startIndex; i < candidates.length; i++) {
			// if (i > 0 && candidates[i] == candidates[i - 1] && used[i - 1] == false) {
			// 	continue;
			// }
			used[i] = true;
			tempResult.add(candidates[i]);
			backtracking(result, tempResult, candidates, target - candidates[i], i + 1, used);
			used[i] = false;
			tempResult.remove(tempResult.size() - 1);
		}
	}
}
