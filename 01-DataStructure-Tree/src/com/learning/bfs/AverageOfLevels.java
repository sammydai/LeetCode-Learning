package com.learning.bfs;

import com.learning.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 637. Average of Levels in Binary Tree
 *
 * @author : [Sammy]
 * @version : [v1.0]
 * @createTime : [2023/10/24 10:59]
 */
public class AverageOfLevels {
	public List<Double> averageOfLevels(TreeNode root) {
		List<Double> result = new ArrayList<Double>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		if (root == null) {
			return result;
		}
		queue.offer(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			Double tempResult = Double.valueOf(0);
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				tempResult += node.val;
				if (node.left != null) {
					queue.offer(node.left);
				}
				if (node.right != null) {
					queue.offer(node.right);
				}
			}
			result.add(tempResult / size);
		}
		return result;
	}
}
