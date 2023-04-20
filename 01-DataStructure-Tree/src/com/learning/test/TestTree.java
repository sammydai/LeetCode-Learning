package com.learning.test;

import com.learning.tree.TreeNode;

/**
 * @Package: com.learning.test
 * @Description:
 * @Author: Sammy
 * @Date: 2020/11/7 20:21
 */

public class TestTree {
	public static void main(String[] args) {
		TreeNode cc = new TreeNode(1, null,null);
		TreeNode aa = new TreeNode(23, null,cc);
		TreeNode bb = new TreeNode(8, null,null);
		TreeNode dd = new TreeNode(72,null,null);
		TreeNode rl = new TreeNode(9,aa,bb);
		TreeNode rr =new TreeNode(20,null,dd);
		// TreeNode t1 = new TreeNode(15,null,null);
		// TreeNode t2 = new TreeNode(7,null,null);
		// TreeNode rl = new TreeNode(9,null,null);
		// TreeNode rr = new TreeNode(20,t1,t2);
		TreeNode root = new TreeNode(3, rl,rr);
		// System.out.println("breadFirstSearch:");
		// System.out.println("-----------------");
		// breadFirstSearch(root);
		// System.out.println("breadFirstSearch1:");
		// System.out.println(levelOrderBottom(root));
		// System.out.println(minDepth(root));
		System.out.println("InorderTraversal");
		System.out.println("-----------------");
		// System.out.println(InorderTraversal.inorderTraversal(root));
		// System.out.println(breadFirstSearchNew(root));


	}
}
