package com.learning.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Package: com.learning.backtracking
 * @Description: 46. Permutations
 * @Author: Sammy
 * @Date: 2020/11/14 18:38
 */

public class Permutations {
	public static void main(String[] args) {
		int[] nums = {1,1,3};
		// System.out.println(new Permutations().permute(nums));
		System.out.println(new Permutations().permuteUnique(nums));
	}

	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> tempResult = new ArrayList<>();
		helper(nums,tempResult,result);
		return result;
	}

	private void helper(int[] nums, List<Integer> tempResult, List<List<Integer>> result) {
		if (tempResult.size()==nums.length) {
			result.add(new ArrayList<>(tempResult));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (tempResult.contains(nums[i])) continue;
			tempResult.add(nums[i]);
			helper(nums,tempResult,result);
			tempResult.remove(tempResult.size() - 1);
		}
	}

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

	/**
	 * 再写亿遍
	 * Input: nums = [1,2,3]
	 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
	 * @param nums
	 * @return
	 */
	public List<List<Integer>> permuteV2(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> tempResult = new ArrayList<>();
		helper2(nums, result,tempResult);
		return result;
	}

	private void helper2(int[] nums, List<List<Integer>> result, List<Integer> tempResult) {
		if (tempResult.size()==nums.length) {
			result.add(new ArrayList<>(tempResult));
			return;
		}
		// for (int i = 0; i < nums.length; i++) {
		// 	if (tempResult.contains(nums[i])) continue;
		// 	tempResult.add(nums[i]);
		// 	helper2(nums,result,tempResult);
		// 	tempResult.remove(tempResult.size() - 1);
		// }
		// if (tempResult.size()==nums.length) {
		// 	result.add(new ArrayList<>(tempResult));
		// 	return;
		// }

		for (int i = 0; i < nums.length; i++) {
			if (tempResult.contains(nums[i])) continue;
			tempResult.add(nums[i]);
			helper2(nums,result,tempResult);
			//cuz java "pass by reference", after you pass "tempList" in the recursion, the "tempList" are changed, when go back we must undo the change.
			// For example, [] -> [1],
			// we have to remove to undo the add behavior [1] -> [].
			// Then we can [] -> [2]. Without remove, it will be [1] -> [1, 2]
			tempResult.remove(tempResult.size() - 1);
		}
	}

	public List<List<Integer>> permuteUniqueV2(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> tempResult = new ArrayList<>();
		if(nums.length == 0) return result;
		Arrays.sort(nums);
		helper3(nums, result,tempResult,new boolean[nums.length]);
		return result;
	}

	private void helper3(int[] nums, List<List<Integer>> result, List<Integer> tempResult, boolean[] numsb) {
		if (tempResult.size()==nums.length) {
			result.add(new ArrayList<>(tempResult));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (i>0&& nums[i]==nums[i-1]&& numsb[i-1]) continue;
			if (!numsb[i]) {
				tempResult.add(nums[i]);
				numsb[i] = true;
				helper3(nums,result,tempResult,numsb);
				numsb[i] = false;
				tempResult.remove(tempResult.size() - 1);
			}
		}

	}


}
