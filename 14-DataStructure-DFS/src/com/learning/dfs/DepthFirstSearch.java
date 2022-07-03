package com.learning.dfs;

import com.learning.tree.TreeNode;

import java.util.Stack;

/**
 * @Package: com.learning.dfs
 * @Description:
 * @Author: Sammy
 * @Date: 2020/11/7 19:44
 */

public class DepthFirstSearch {

	public static void main(String[] args) {
		TreeNode cc = new TreeNode(1, null,null);
		TreeNode aa = new TreeNode(23, null,cc);
		TreeNode bb = new TreeNode(8, null,null);
		// TreeNode dd = new TreeNode(72,null,null);
		TreeNode rl = new TreeNode(9,aa,bb);
		TreeNode rr =new TreeNode(20,null,null);
		// TreeNode t1 = new TreeNode(15,null,null);
		// TreeNode t2 = new TreeNode(7,null,null);
		// TreeNode rl = new TreeNode(9,null,null);
		// TreeNode rr = new TreeNode(20,t1,t2);
		TreeNode root = new TreeNode(3, rl,rr);
		System.out.println("depthFirstSearch:");
		System.out.println("-----------------");
		depthFirstSearch(root);
	}

	/**
	 * 深度遍历树dfs
	 * @param root
	 */
	public static void depthFirstSearch(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		TreeNode node = null;
		while (!stack.empty()) {
			node = stack.pop();
			System.out.print(node.val+" ");//遍历根结点
			if (node.right != null) {
				stack.push(node.right);//先将右子树压栈
			}
			if (node.left != null) {
				stack.push(node.left);//再将左子树压栈
			}
		}
	}
	//出栈顺序：根、左、右
	//入栈顺序：右，左
}
