package com.learning.backtracking;

import java.util.ArrayList;
import java.util.List;


/**
 * 结合
 * 77. Combinations
 *
 * @author Sammy
 * @date 2023/05/06
 */
public class Combine {
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> tempResult = new ArrayList<>();
		//n =1,2,3,4,....n 所以从1开始
		helper(result,tempResult,n,k,1);
		return result;
    }

	private void helper(List<List<Integer>> result, List<Integer> tempResult, int n, int k,int startIndex) {
		if (tempResult.size() == k) {
			result.add(new ArrayList<>(tempResult));
		}
		for (int i = startIndex; i <= n; i++) {
			tempResult.add(i);
			helper(result,tempResult,n,k,i+1);
			tempResult.remove(tempResult.size() - 1);
		}
	}

	public static void main(String[] args) {
		List<List<Integer>> combine = new Combine().combine(4, 2);
		System.out.println(combine);
	}
}
