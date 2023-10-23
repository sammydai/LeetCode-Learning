package com.learning.tree;

/**
 * @Package: com.learning.tree
 * @Description:
 * @Author: Sammy
 * @Date: 2020/11/7 19:41
 */

public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;
	TreeNode() {
	}

	public TreeNode(int val) {
		this.val = val;
	}

	public TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}
