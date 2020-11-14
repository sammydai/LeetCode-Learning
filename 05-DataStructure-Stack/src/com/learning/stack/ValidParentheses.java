package com.learning.stack;

import java.util.HashMap;
import java.util.Stack;

/**
 * @Package: com.learning.stack
 * @Description: 20. Valid Parentheses
 * @Author: Sammy
 * @Date: 2020/11/14 11:01
 */

public class ValidParentheses {
	public boolean isValid(String s) {
		if (s == null || s.length() == 0 || s.length() % 2 != 0) {
			return false;
		}
		HashMap<Character,Character> set = new HashMap<>();
		set.put('(',')');
		set.put('{','}');
		set.put('[',']');
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			char compareCharacter = s.charAt(i);
			if (set.containsKey(compareCharacter)) {
				stack.push(compareCharacter);
			}else {
				if (stack.isEmpty()) {
					return false;
				} else {
					Character leftPair = stack.pop();
					if (set.get(leftPair) != compareCharacter) {
						return false;
					}
				}
			}
		}
		return stack.isEmpty();
    }
}
