package com.learning.greedy;

import java.util.Arrays;

/**
 * @Package: com.learning.greedy
 * @Description: 455. Assign Cookies
 * @Author: Sammy
 * @Date: 2020/11/24 21:17
 */

public class FindContentChildren {

	/**
	 * 分糖果饼干，贪婪算法
	 * @param g 想要吃的饼干数量
	 * @param s 饼干
	 * @return
	 */
	public int findContentChildren(int[] g, int[] s) {
		if (g.length < 1 || s.length < 1) {
			return 0;
		}
		Arrays.sort(g);
		Arrays.sort(s);
		int result = 0;
		int i = 0;
		int j = 0;
		while (i < g.length && j < s.length) {
			if (g[i] <= s[j]) {
				i++;
				j++;
				result++;
			} else {
				j++;
			}
		}
		return result;
    }

}
