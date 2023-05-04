package com.learning.binarytree;

import com.learning.tree.TreeNode;

/**
 * 反转二叉树
 * 1、遍历每一个节点
 * 2、对每一个节点做什么？互换左右节点的值
 * 3、在前序位置，中序位置，后序位置做？
 *
 * @author : [Sammy]
 * @version : [v1.0]
 * @createTime : [2023/5/4 09:41]
 */
public class InvertTree {
	public TreeNode invertTree(TreeNode root) {
		if (root == null) return null;
		//前序遍历的位置
		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;
		//递归
		invertTree(root.left);
		invertTree(root.right);

		return root;
	}
}
