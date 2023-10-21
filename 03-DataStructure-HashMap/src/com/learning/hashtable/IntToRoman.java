package com.learning.hashtable;

import java.util.HashMap;

/**
 * @Package: com.learning.hashtable
 * @Description: 12. Integer to Roman
 * 13. Roman to Integer
 * @Author: Sammy
 * @Date: 2022/2/7 09:29
 */

public class IntToRoman {
	public String intToRoman(int num) {
		//关键是这个数组的生成，是个位数/十位数/百位数分别枚举出来值
		String M[] = {"", "M", "MM", "MMM"};
		String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
		String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
		String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
		return M[num / 1000] + C[(num % 1000) / 100] + X[(num % 100) / 10] + I[(num % 10)];
	}

	public static void main(String[] args) {
		int aa = 1234;
		System.out.println(aa % 100 / 10);
	}

	public int romanToInt(String s) {
		if (s == null || s.length() == 0) return -1;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
		int len = s.length();
		int result = map.get(s.charAt(len - 1));
		for (int i = s.length() - 2; i >= 0; i--) {
			//比较大小，如果前者比后者数字小，是要相减的，比如IV = 5-1
			if (map.get(s.charAt(i)) >= map.get(s.charAt(i + 1))) {
				result += map.get(s.charAt(i));
			} else {
				result -= map.get(s.charAt(i));
			}
		}
		return result;
	}
}
