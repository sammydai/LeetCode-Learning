package com.learning.dfs;

import com.learning.tree.TreeNode;

/**
 * 230. Kth Smallest Element in a BST
 *
 * @author : [Sammy]
 * @version : [v1.0]
 * @createTime : [2023/10/30 22:44]
 */
public class KthSmallest {
	int res;
	int count;

	public void dfs(TreeNode root, int k) {
		if (root == null) return;
		dfs(root.left, k);
		if (++count == k) {
			res = root.val;
			return;
		}
		dfs(root.right, k);
	}

	public int kthSmallest(TreeNode root, int k) {
		dfs(root, k);
		return res;
	}
}
