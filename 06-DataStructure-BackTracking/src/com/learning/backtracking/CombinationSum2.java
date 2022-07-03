package com.learning.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Package: com.learning.backtracking
 * @Description: 40. Combination Sum II
 * @Author: Sammy
 * @Date: 2022/7/3 20:29
 */

public class CombinationSum2 {
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
		List<Integer> tempResult = new ArrayList<>();
		helper(result,tempResult,candidates,target,0);
		return result;
    }

    private void helper(List<List<Integer>> result, List<Integer> tempResult, int[] candidates, int target, int start) {
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
				helper(result,tempResult,candidates,target-candidates[i],i+1);
				tempResult.remove(tempResult.size() - 1);
			}
		}
	}
}
