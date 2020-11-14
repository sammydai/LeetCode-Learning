package com.learning.backtracking;

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
		if (left == 0 && right == 0) {
			result.add(tempResult);
			return;
		}
		helper(left-1,right,tempResult+"(",result);
		helper(left,right-1,tempResult+")",result);
	}
}
