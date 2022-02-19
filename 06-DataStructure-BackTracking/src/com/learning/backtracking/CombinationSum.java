package com.learning.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Package: com.learning.backtracking
 * @Description: 39. Combination Sum
 * 40. Combination Sum II
 * @Author: Sammy
 * @Date: 2021/3/10 16:53
 */

public class CombinationSum {
	public static void main(String[] args) {
		int[] aa = {2,3,5};
		List<List<Integer>> lists = new CombinationSum().combinationSum(aa, 8);
		System.out.println(lists);
	}

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
		List<Integer> tempResult = new ArrayList<>();
		helper(result,tempResult,candidates,target,0);
		return result;
    }

	private void helper(List<List<Integer>> result, List<Integer> tempResult, int[] candidates, int target, int position) {
		if (target < 0) {
			return;
		} else if (target == 0) {
			result.add(new ArrayList<>(tempResult));
			return;
		} else {
			for (int i = position; i < candidates.length; i++) {
				tempResult.add(candidates[i]);
				helper(result, tempResult, candidates, target - candidates[i], i);
				tempResult.remove(tempResult.size() - 1);
			}
		}
	}

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
		List<Integer> tempResult = new ArrayList<>();
		helper2(result,tempResult,candidates,target,0);
		return result;
    }

	private void helper2(List<List<Integer>> result, List<Integer> tempResult, int[] candidates, int target, int start) {
		if (target==0) {
			result.add(new ArrayList<>(tempResult));
			return;
		} else if (target < 0) {
			return;
		} else {
			for (int i = start; i < candidates.length; i++) {
				if (i > start && candidates[i] == candidates[i - 1]) {
					continue;
				}
				tempResult.add(candidates[i]);
				helper2(result,tempResult,candidates,target-candidates[i],i+1);
				tempResult.remove(tempResult.size() - 1);
			}
		}
	}
}
