package com.learning.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 46. Permutations
 *
 * @author : [Sammy]
 * @version : [v1.0]
 * @createTime : [2023/5/6 15:22]
 */
public class Permutation {
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> track = new ArrayList<>();
		boolean[] used = new boolean[nums.length];
		backtracking(nums, res, track, used);
		return res;
	}

	private void backtracking(int[] nums, List<List<Integer>> res, List<Integer> track, boolean[] used) {
		if (track.size() == nums.length) {
			res.add(new ArrayList<>(track));
		}
		for (int i = 0; i < nums.length; i++) {
			if (used[i]) {
				continue;
			}
			track.add(nums[i]);
			used[i] = true;
			backtracking(nums, res, track, used);
			track.remove(track.size() - 1);
			used[i] = false;
		}
	}
}
