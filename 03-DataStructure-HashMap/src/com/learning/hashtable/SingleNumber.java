package com.learning.hashtable;

import java.util.HashSet;
import java.util.stream.Stream;

/**
 * @Package: com.learning.hashtable
 * @Description: 136. Single Number
 * @Author: Sammy
 * @Date: 2020/11/24 20:32
 */

public class SingleNumber {
	public static void main(String[] args) {
		int[] nums1 = {2,2,4,5,5,6,6,7,7};
		System.out.println(singleNumber(nums1));
	}
	 public static int singleNumber(int[] nums) {
		 if (nums.length==1) {
			 return nums[0];
		 }
		 HashSet<Integer> hashSet = new HashSet<>();
		 for (int num : nums) {
			 if (!hashSet.contains(num)) {
				 hashSet.add(num);
			 } else {
				 hashSet.remove(num);
			 }
		 }
		 return hashSet.iterator().next();
	 }
}
