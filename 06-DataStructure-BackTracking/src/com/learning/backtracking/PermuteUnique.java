package com.learning.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Package: com.learning.backtracking
 * @Description: 47. Permutations II
 * @Author: Sammy
 * @Date: 2022/7/3 20:39
 */

public class PermuteUnique {
	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		if(nums.length == 0) return result;
		Arrays.sort(nums);
		List<Integer> tempResult = new ArrayList<>();
		helperUnique(nums,tempResult,result,new boolean[nums.length]);
		return result;
	}

	private void helperUnique(int[] nums, List<Integer> tempResult, List<List<Integer>> result, boolean[] used) {
		if (tempResult.size()==nums.length) {
			result.add(new ArrayList<>(tempResult));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (i > 0 && nums[i] == nums[i - 1] && used[i - 1]) {
				continue;
			}
			if (!used[i]) {
				used[i] = true;
				tempResult.add(nums[i]);
				helperUnique(nums,tempResult,result,used);
				tempResult.remove(tempResult.size() - 1);
				used[i] = false;
			}
		}
	}
}
