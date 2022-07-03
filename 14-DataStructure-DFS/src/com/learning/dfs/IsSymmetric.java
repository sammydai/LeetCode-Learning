package com.learning.dfs;

import com.learning.tree.TreeNode;

/**
 * @Package: com.learning.dfs
 * @Description: 101. Symmetric Tree
 * @Author: Sammy
 * @Date: 2022/7/3 14:22
 */

public class IsSymmetric {
	public boolean isSymmetric(TreeNode root) {
        if (root==null) return true;
		return isSymmetricHelper(root.left, root.right);
    }

    public boolean isSymmetricHelper(TreeNode p,TreeNode q) {
		if (p == null && q == null) {
			return true;
		}
		if (p == null || q == null) {
			return false;
		}
		return (p.val == q.val) && isSymmetricHelper(p.left, q.right) && isSymmetricHelper(p.right, q.left
		);
    }
}
