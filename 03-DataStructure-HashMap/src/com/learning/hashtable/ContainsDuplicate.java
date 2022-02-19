package com.learning.hashtable;

import sun.jvm.hotspot.debugger.posix.elf.ELFSectionHeader;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Package: com.learning.hashtable
 * @Description: 217. Contains Duplicate
 * @Author: Sammy
 * @Date: 2022/1/27 10:12
 */

public class ContainsDuplicate {
	public boolean containsDuplicate(int[] nums) {
		Map<Integer, Integer> hashMap = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (hashMap.containsKey(nums[i])) return true;
			hashMap.put(nums[i], 0);
		}
		return false;
	}

	public boolean containsDuplicateNew(int[] nums) {
		Set<Integer> hashSet = new HashSet<>();
		for (int num : nums) {
			hashSet.add(num);
		}
		return !(hashSet.size() == nums.length);
	}

	public boolean containsNearbyDuplicate(int[] nums, int k) {
		Map<Integer, Integer> hashMap = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			Integer old = hashMap.put(nums[i], i);
			if (old!=null&& i-old<=k) {
				return true;
			}
		}
		return false;
	}


}
