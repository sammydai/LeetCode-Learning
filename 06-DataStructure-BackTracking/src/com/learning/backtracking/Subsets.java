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
		List<List<Integer>> subsets = new Subsets().subsets(nums);
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
}
