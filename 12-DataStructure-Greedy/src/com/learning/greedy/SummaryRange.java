package com.learning.greedy;

import java.util.ArrayList;
import java.util.List;

/**
 * 228. Summary Ranges
 *
 * @author : [Sammy]
 * @version : [v1.0]
 * @createTime : [2023/5/15 23:26]
 */
public class SummaryRange {
	public List<String> summaryRanges(int[] nums) {
		List<String> res = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			int init = nums[i];
			while (i + 1 < nums.length && nums[i + 1] == nums[i] + 1) {
				i++;
			}
			if (init != nums[i]) {
				res.add(String.valueOf(init + "->" + nums[i]));
			} else {
				res.add(String.valueOf(nums[i]));
			}
		}
		return res;
	}
}
