package com.learning.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @Package: com.learning.backtracking
 * @Description: 78. Subsets
 * @Author: Sammy
 * @Date: 2020/11/14 17:32
 */

public class Subsets {
	public static void main(String[] args) {
		int[] nums = {1,2,3};
		List<List<Integer>> subsets = new Subsets().subsetsV2(nums);
		System.out.println(subsets);
	}

	public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
		List<Integer> tempResult = new ArrayList<>();
		helper(0,nums,tempResult,result);
		return result;
    }

    public void helper(int position,int[] nums,List<Integer> tempResult,List<List<Integer>> result){
		result.add(new ArrayList<>(tempResult));
		for (int i = position; i < nums.length; i++) {
			tempResult.add(nums[i]);
			helper(i+1,nums,tempResult,result);
			tempResult.remove(tempResult.size() - 1);
		}






	}

	/**
	 * 在写一遍 0310
	 * Input: nums = [1,2,3]
	 * Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
	 * @param nums
	 * @return
	 */
	public List<List<Integer>> subsetsV2(int[] nums) {
		// List<List<Integer>> result = new ArrayList<>();
		// List<Integer> tempResult = new ArrayList<>();
		// helper2(result,tempResult,nums,0);
		// return result;
		 List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for(int n : nums){
            int size = result.size();
            for(int i=0; i<size; i++){
                List<Integer> subset = new ArrayList<>(result.get(i));
                subset.add(n);
                result.add(subset);
            }
        }
        return result;
	}

	/**
	 * 还需要理解
	 * @param result
	 * @param tempResult
	 * @param nums
	 * @param start
	 */
	private void helper2(List<List<Integer>> result, List<Integer> tempResult, int[] nums, int start) {
		result.add(new ArrayList<>(tempResult));
		for (int i = start; i < nums.length; i++) {
			tempResult.add(nums[i]);
			helper2(result,tempResult,nums,i+1);
			tempResult.remove(tempResult.size() - 1);
		}
	}
}
