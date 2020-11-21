package com.learnig.heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * @Package: com.learnig.heap
 * @Description: 347. Top K Frequent Elements
 * @Author: Sammy
 * @Date: 2020/11/21 22:13
 */

public class TopKFrequent {
	public static void main(String[] args) {
		int[] nums1 = {3, 0, 0, 1};
		for (int i : topKFrequent(nums1, 1)) {
			System.out.println(i);
		}
	}

	/**
	 * 设置k个最小堆
	 * @param nums
	 * @param k
	 * @return
	 */
	public static int[] topKFrequent(int[] nums, int k) {
		HashMap<Integer,Integer> map = new HashMap();
		for(int num : nums){
			if (map.containsKey(num)) {
				map.put(num, map.get(num) + 1);
			} else {
				map.put(num, 1);
			}
		}
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer a, Integer b) {
				return map.get(a) - map.get(b);
			}
		});
		for (Integer key : map.keySet()) {
			if (pq.size() < k) {
				pq.add(key);
			} else if (map.get(key) > map.get(pq.peek())) {
				pq.remove();
				pq.add(key);
			}
		}
		// List<Integer> result = new ArrayList<>();
		int[] result = new int[k];
		for (int i = 0; i < result.length; i++) {
			result[i] = pq.remove();
		}
		return result;
	}
}
