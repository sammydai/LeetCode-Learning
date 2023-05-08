package com.learning.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 90. Subsets II
 *
 * @author Sammy
 * @date 2023/05/06
 */
public class SubsetsWithDup {
	public static void main(String[] args) {
		System.out.println(new SubsetsWithDup().subsetsWithDup(new int[]{1, 2, 2, 2, 3, 3, 4}));
	}

	public List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		//很重要，必须先排序，否则 [4,4,4,1,4]这种例子就会报错
		Arrays.sort(nums);
		boolean[] used = new boolean[nums.length];
		Arrays.fill(used, false);
		List<Integer> tempResult = new ArrayList<>();
		backtracking(0, nums, tempResult, result, used);
		return result;
	}

	public void backtracking(int start, int[] nums, List<Integer> tempResult, List<List<Integer>> result, boolean[] used) {
		result.add(new ArrayList<>(tempResult));
		for (int i = start; i < nums.length; i++) {
			if (i > 0 && used[i - 1] == false && nums[i] == nums[i - 1]) {
				continue;
			}
			used[i] = true;
			tempResult.add(nums[i]);
			backtracking(i + 1, nums, tempResult, result, used);
			used[i] = false;
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
