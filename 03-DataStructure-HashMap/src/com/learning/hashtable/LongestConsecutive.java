package com.learning.hashtable;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 移除关联的数字
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

class Solution {
	public int longestConsecutive(int[] nums) {
		int len = nums.length;
		if (len <= 1) return len;
		int count = 1;
		int maxLen = 1;
		Arrays.sort(nums);
		for (int right = 1; right < len; right++) {
			if (nums[right] == nums[right - 1]) {
				continue;
			} else if (nums[right] == nums[right - 1] + 1) {
				count++;
				maxLen = Math.max(maxLen, count);
			} else {
				count = 1;
			}
		}
		return maxLen;
	}
}
