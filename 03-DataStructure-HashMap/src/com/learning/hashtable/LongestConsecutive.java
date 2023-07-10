package com.learning.hashtable;

import java.util.HashSet;
import java.util.Set;

/**
 * [一句话描述该类的功能]
 *
 * @author : [Sammy]
 * @version : [v1.0]
 * @createTime : [2023/5/17 23:10]
 */
public class LongestConsecutive {
	public int longestConsecutive(int[] nums) {
		Set<Integer> hashset = new HashSet<Integer>();
		int res = 0;
		for (int num : nums) {
			hashset.add(num);
		}
		for (int num : nums) {
			if (hashset.remove(num)) {
				int tempRes = 1;
				int current = num;
				while (hashset.remove(current - 1)) {
					current--;
				}
				tempRes += (num - current);
				current = num;
				while (hashset.remove(current + 1)) {
					current++;
				}
				tempRes += (current - num);
				res = Math.max(res, tempRes);
			}
		}
		return res;
	}
}
