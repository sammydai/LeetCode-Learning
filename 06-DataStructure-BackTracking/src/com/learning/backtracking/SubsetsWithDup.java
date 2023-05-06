package com.learning.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Package: com.learning.backtracking
 * @Description: 90. Subsets II
 * @Author: Sammy
 * @Date: 2022/7/3 18:22
 */

public class SubsetsWithDup {
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		//很重要，必须先排序，否则 [4,4,4,1,4]这种例子就会报错
		Arrays.sort(nums);
		List<Integer> tempResult = new ArrayList<>();
		backtracking(0, nums, tempResult, result);
		return result;
	}

	public void backtracking(int start, int[] nums, List<Integer> tempResult, List<List<Integer>> result) {
		result.add(new ArrayList<>(tempResult));
		for (int i = start; i < nums.length; i++) {
			if (nums[i] != nums[i - 1]) {
				continue;
			}
			tempResult.add(nums[i]);
			backtracking(i + 1, nums, tempResult, result);
			tempResult.remove(tempResult.size() - 1);
		}
	}

	private void helper(int startIndex, int[] nums, List<Integer> tempResult, List<List<Integer>> result) {
		result.add(new ArrayList<>(tempResult));
		for (int i = startIndex; i < nums.length; i++) {
			if (i > startIndex && nums[i] == nums[i - 1]) continue;
			tempResult.add(nums[i]);
			helper(i + 1, nums, tempResult, result);
			tempResult.remove(tempResult.size() - 1);
		}
	}

}
