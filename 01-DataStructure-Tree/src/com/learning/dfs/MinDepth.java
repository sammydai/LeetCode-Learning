package com.learning.dfs;

import com.learning.tree.TreeNode;
import sun.jvm.hotspot.debugger.MachineDescriptionIntelX86;

/**
 * @Package: com.learning.dfs
 * @Description: 111. Minimum Depth of Binary Tree
 * @Author: Sammy
 * @Date: 2020/11/7 20:32
 */

public class MinDepth {
	public int minDepth(TreeNode root) {
		if (root == null) return 0;
		if (root.left==null&& root.right==null){
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
}
