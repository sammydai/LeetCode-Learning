package com.learning.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 排列独特
 * 47. Permutations II
 *
 * @author Sammy
 * @date 2023/05/06
 */
public class PermuteUnique {
	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		if (nums.length == 0) return result;
		Arrays.sort(nums);
		boolean[] used = new boolean[nums.length];
		Arrays.fill(used, false);
		List<Integer> tempResult = new ArrayList<>();
		helperUnique(nums, tempResult, result, used);
		return result;
	}

	private void helperUnique(int[] nums, List<Integer> tempResult, List<List<Integer>> result, boolean[] used) {
		if (tempResult.size() == nums.length) {
			result.add(new ArrayList<>(tempResult));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == false) {
				continue;
			}
			if (used[i] == false) {
				used[i] = true;
				tempResult.add(nums[i]);
				helperUnique(nums, tempResult, result, used);
				tempResult.remove(tempResult.size() - 1);
				used[i] = false;
			}
		}
	}
}
