package com.learning.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 46. Permutations
 * 可以看出元素1在[1,2]中已经使用过了，
 * 但是在[2,1]中还要在使用一次1，所以处理排列问题就不用使用startIndex了。
 * 选择了2之后还要在[1,3]中选择，所以还需要从index=0 开始
 *
 * @author : [Sammy]
 * @version : [v1.0]
 * @createTime : [2023/5/6 15:22]
 */
public class Permutation {
	public static void main(String[] args) {
		System.out.println(new Permutation().permute(new int[]{1, 2, 3}));
	}

	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> track = new ArrayList<>();
		boolean[] used = new boolean[nums.length];
		backtracking(nums, res, track, used);
		return res;
	}

	private void backtracking(int[] nums, List<List<Integer>> res, List<Integer> track, boolean[] used) {
		if (track.size() == nums.length) {
			// res.add(new ArrayList<>(track));
			res.add(track);
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
