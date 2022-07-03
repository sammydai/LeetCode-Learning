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
		//和combine题目类似，需要有startIndex
		//理由是当遍历第一个元素1，会把1的所有组合都遍历完全，得到[], [1], [1, 2], [1, 2, 3], [1, 3],
		//当遍历第二个元素2时，就会从第startIndex=2第二层开始，[2,3]所有的subsets
		result.add(new ArrayList<>(tempResult));
		for (int i = position; i < nums.length; i++) {
			tempResult.add(nums[i]);
			helper(i+1,nums,tempResult,result);
			tempResult.remove(tempResult.size() - 1);
		}
	}
}
