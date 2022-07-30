package com.learning.backtracking;

import com.sun.tools.javah.Gen;

import java.util.ArrayList;
import java.util.List;

/**
 * @Package: com.learning.backtracking
 * @Description: 22. Generate Parentheses
 * @Author: Sammy
 * @Date: 2020/11/14 11:21
 */

public class GenerateParenthesis {
	public List<String> generateParenthesis(int n) {
		List<String> result = new ArrayList<>();
		helper(n, n, "", result);
		return result;
	}

	public void helper(int left,int right,String tempResult,List<String> result) {
		if (left > right || left < 0 || right < 0) {
			return;
		}
		// 注意撤出条件
		if (left == 0 && right == 0) {
			result.add(tempResult);
			return;
		}
		helper(left-1,right,tempResult+"(",result);
		helper(left,right-1,tempResult+")",result);
	}

	public static void main(String[] args) {
		List<String> result = new GenerateParenthesis().generateParenthesis(3);
		for (String s : result) {
			System.out.println(s);
		}
	}

	public List<String> generateParenthesisV2(int n) {
		List<String> result = new ArrayList<>();
		helper2(result, "", n, n);
		return result;
	}

	private void helper2(List<String> result, String tempResult, int left, int right) {
		if (left > right || left < 0 || right < 0) {
			return;
		}
		if (left == 0 && right == 0) {
			result.add(tempResult);
			return;
		}
		helper2(result,tempResult+"(",left-1,right);
		helper2(result,tempResult+")",left,right-1);
	}

}
