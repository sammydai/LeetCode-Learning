package com.learning.bfs;

import com.learning.tree.TreeNode;
import sun.util.resources.cldr.ar.CalendarData_ar_YE;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Package: com.learning.bfs
 * @Description: 103. Binary Tree Zigzag Level Order Traversal
 * @Author: Sammy
 * @Date: 2022/1/26 13:17
 */

public class ZigzagLevelOrder {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
       List<List<Integer>> result = new ArrayList<>();
		if (root ==null) return result;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		int level = 1;
		while (!queue.isEmpty()) {
			int levelNum = queue.size();
			level++;
			List<Integer> tempResult = new ArrayList<>();
			for (int i = 0; i < levelNum; i++) {
				TreeNode cur = queue.poll();
				if (level % 2 != 0) {
					tempResult.add(cur.val);
				} else {
					tempResult.add(0, cur.val);
				}
				if (cur.left != null) {
					queue.offer(cur.left);
				}
				if (cur.right!=null) {
					queue.offer(cur.right);
				}
			}
			result.add(tempResult);
		}
		return result;
	}
}
