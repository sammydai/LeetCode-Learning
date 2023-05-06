package com.learning.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Package: com.learning.backtracking
 * @Description: 39. Combination Sum
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
		Arrays.sort(candidates);
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
				//单个值，可以重复使用，所以迭代到下一层级的时候，不需要i+1
				helper(result, tempResult, candidates, target - candidates[i], i);
				tempResult.remove(tempResult.size() - 1);
			}
		}
	}




}
