package com.learning.backtracking;

import javax.xml.bind.ValidationEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Package: com.learning.backtracking
 * @Description: 17. Letter Combinations of a Phone Number
 * @Author: Sammy
 * @Date: 2020/11/14 11:40
 */

public class LetterCombinations {
	public static void main(String[] args) {
		System.out.println(letterCombinations("245"));
	}
	public static List<String> letterCombinations(String digits) {
		List<String> result = new ArrayList<>();
		if (digits.length()==0||digits==null) {
			return result;
		}
		HashMap<Character, String> map = new HashMap<Character, String>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
		helper(digits,0,"",result,map);
		return result;
	}

	public static void helper(String digits,int currIndex,String tempResult,List<String> result,HashMap<Character, String> map){
		if (currIndex==digits.length()) {
			result.add(tempResult);
			return;
		}
		char c = digits.charAt(currIndex);
		if (c == 0 || c == 1) {
			helper(digits,currIndex+1,tempResult,result,map);
			return;
		}
		String value = map.get(c);
		for (int i = 0; i < value.length(); i++) {
			helper(digits,currIndex+1,tempResult+value.charAt(i),result,map);
		}
	}
}
