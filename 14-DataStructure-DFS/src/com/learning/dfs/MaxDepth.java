package com.learning.dfs;

import com.learning.tree.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Package: com.learning.dfs
 * @Description: 104. Maximum Depth of Binary Tree
 * @Author: Sammy
 * @Date: 2022/7/3 14:31
 */

public class MaxDepth {
	public int maxDepth(TreeNode root) {
        if (root==null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		//这里不能写1，根节点的层次还没开始计算，要到循环内部开始计算
		int result = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode cur = queue.poll();
				if (cur.left!=null) queue.offer(cur.left);
				if (cur.right!=null) queue.offer(cur.right);
			}
			result++;
		}
		return result;
	}

	public int maxDepthiterative(TreeNode root) {
		if (root==null) return 0;
		return Math.max(maxDepthiterative(root.left), maxDepthiterative(root.right)) + 1;
	}
}
