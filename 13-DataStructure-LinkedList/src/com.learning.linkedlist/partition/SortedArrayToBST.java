package com.learning.linkedlist.partition;


/**
 * [一句话描述该类的功能]
 *
 * @author : [Sammy]
 * @version : [v1.0]
 * @createTime : [2023/10/26 15:19]
 */
public class SortedArrayToBST {
	public static TreeNode helper(int[] nums, int low, int high) {
		if (low > high) return null;
		int mid = low + (high - low) / 2;
		TreeNode head = new TreeNode(nums[mid]);
		head.left = helper(nums, low, mid - 1);
		head.right = helper(nums, mid + 1, high);
		return head;
	}

	public TreeNode sortedArrayToBST(int[] nums) {
		if (nums.length == 0) return null;
		TreeNode node = helper(nums, 0, nums.length);
		return node;
	}
}
