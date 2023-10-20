package com.learning.binarytree;

import com.learning.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 后序遍历二叉树
 *
 * @author : [Sammy]
 * @version : [v1.0]
 * @createTime : [2023/5/4 21:33]
 */
public class PostorderTraversal {
	List<Integer> res = new ArrayList<Integer>();

	public List<Integer> postorderTraversal(TreeNode root) {
		traverse(root);
		return res;
	}

	/**
	 * 递归方法
	 *
	 * @param root 根
	 */
	public void traverse(TreeNode root) {
		if (root == null) return;
		traverse(root.left);
		traverse(root.right);
		res.add(root.val);
	}
}
