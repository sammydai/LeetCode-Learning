package com.learning;

/**
 * @Package: com.learning
 * @Description: 268. Missing Number
 * @Author: Sammy
 * @Date: 2020/11/22 16:27
 */

public class MissingNumber {
	public int missingNumber(int[] nums) {
		int i = 0;
		while (i < nums.length) {
			int cur = nums[i];
			if (nums[i] != nums.length && nums[i] != i) {
				int temp = nums[cur];
				nums[cur] = nums[i];
				nums[i] = temp;
			} else {
				i++;
			}
		}
		for (int i1 = 0; i1 < nums.length; i1++) {
			if (nums[i1]!=i1) return i1;
		}
		return nums.length;
    }

     public int missingNumberNew(int[] nums) {

		 int i = 0;
		 while (i < nums.length) {
			 int cur = nums[i];
			 if (nums[i] != i && nums[i] != nums.length) {
				 int temp = nums[cur];
				 nums[cur] = nums[i];
				 nums[i] = temp;
			 } else {
				 i++;
			 } 
		 }
		 for (int j = 0; j < nums.length; j++) {
			 if (j!=nums[j]) return j;
		 }
		 return nums.length;
    }
}
