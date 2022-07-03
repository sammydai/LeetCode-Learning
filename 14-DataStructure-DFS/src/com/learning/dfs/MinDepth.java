package com.learning.dfs;

import com.learning.tree.TreeNode;
import sun.jvm.hotspot.debugger.MachineDescriptionIntelX86;

import java.util.Currency;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Package: com.learning.dfs
 * @Description: 111. Minimum Depth of Binary Tree
 * 104. Maximum Depth of Binary Tree
 * @Author: Sammy
 * @Date: 2020/11/7 20:32
 */

public class MinDepth {
	public static int minDepth(TreeNode root) {
		if (root == null) return 0;
		if (root.left == null && root.right == null) {
			return 1;
		}
		int LeftNum = minDepth(root.left);
		int RightNum = minDepth(root.right);
		if (LeftNum==0) {
			return RightNum+1;
		}
		if (RightNum==0){
			return LeftNum+1;
		}
		return Math.min(LeftNum,RightNum)+1;
	}

	//1、确定队列数据结构，将每一层的数据offer到队列中
	//2、当遍历完一层之后，再把深度+1
	//3、如何确定：这一层遍历完了？依靠队列的大小，queue.size
	//4、根据队列的大小来判断，这一层的遍历次数
	public static int minDepthNew(TreeNode root) {
		if (root==null) return 0;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		int depth = 1;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode cur = queue.poll();
				if (cur.left == null && cur.right == null) return depth;
				if (cur.left != null) queue.offer(cur.left);
				if (cur.right != null) queue.offer(cur.right);
			}
			depth++;
		}
		return depth;
	}
}
