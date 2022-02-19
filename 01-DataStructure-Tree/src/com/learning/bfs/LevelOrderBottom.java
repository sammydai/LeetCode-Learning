package com.learning.bfs;

import com.learning.tree.TreeNode;

import java.util.*;

import static java.util.Collections.*;

/**
 * @Package: com.learning.bfs
 * @Description: 107. Binary Tree Level Order Traversal II
 * @Description: 102. Binary Tree Level Order Traversal
 * @Author: Sammy
 * @Date: 2020/11/7 20:20
 */

public class LevelOrderBottom {
	public static List<List<Integer>> levelOrderBottom(TreeNode root){
		if (root ==null) return null;
		List<List<Integer>> result = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			List<Integer> tempResult = new ArrayList<>();
			for (int i = queue.size(); i > 0; i--) {
				TreeNode treeNode = queue.poll();
				tempResult.add(treeNode.val);
				if (treeNode.left != null) {
					queue.offer(treeNode.left);
				}
				if (treeNode.right != null) {
					queue.offer(treeNode.right);
				}
			}
			result.add(tempResult);
		}
		reverse(result);
		return result;
	}
}
