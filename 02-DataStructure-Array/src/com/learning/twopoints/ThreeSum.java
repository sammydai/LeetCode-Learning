package com.learning.twopoints;

import com.sun.tools.corba.se.idl.constExpr.ShiftRight;
import sun.jvm.hotspot.runtime.ResultTypeFinder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Package: com.learning.twopoints
 * @Description: 15. 3Sum
 * @Author: Sammy
 * @Date: 2022/2/15 17:08
 */

public class ThreeSum {
 	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		if (nums == null || nums.length <= 2) {
			return result;
		}
		//排序
		Arrays.sort(nums);
		int sum, left, right;
		for (int i = 0; i < nums.length - 2; i++) {
			if (i != 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			left = i + 1;
			right = nums.length - 1;
			while (left < right) {
				sum = nums[left] + nums[right];
				if (sum + nums[i] == 0) {
					List<Integer> tempResult = new ArrayList<>();
					tempResult.add(nums[left]);
					tempResult.add(nums[right]);
					tempResult.add(nums[i]);
					result.add(tempResult);
					left++;
					right--;
					while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
				} else if (sum + nums[i] < 0) {
					left++;
				} else {
					right--;
				}
			}
		}
		return result;
	}
}
