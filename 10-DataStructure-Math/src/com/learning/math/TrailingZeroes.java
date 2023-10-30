package com.learning.math;

/**
 * 172. Factorial Trailing Zeroes
 * https://leetcode.cn/problems/factorial-trailing-zeroes/solutions/47030/xiang-xi-tong-su-de-si-lu-fen-xi-by-windliang-3/?envType=study-plan-v2&envId=top-interview-150
 * 首先末尾有多少个 0 ，只需要给当前数乘以一个 10 就可以加一个 0。
 * <p>
 * 再具体对于 5!，也就是 5 * 4 * 3 * 2 * 1 = 120，我们发现结果会有一个 0，原因就是 2 和 5 相乘构成了一个 10。而对于 10 的话，其实也只有 2 * 5 可以构成，所以我们只需要找有多少对 2/5。
 * <p>
 * 我们把每个乘数再稍微分解下，看一个例子。
 * <p>
 * 11! = 11 * 10 * 9 * 8 * 7 * 6 * 5 * 4 * 3 * 2 * 1 = 11 * (2 * 5) * 9 * (4 * 2) * 7 * (3 * 2) * (1 * 5) * (2 * 2) * 3 * (1 * 2) * 1
 * <p>
 * 对于含有 2 的因子的话是 1 * 2, 2 * 2, 3 * 2, 4 * 2 ...
 * <p>
 * 对于含有 5 的因子的话是 1 * 5, 2 * 5...
 * <p>
 * 含有 2 的因子每两个出现一次，含有 5 的因子每 5 个出现一次，所有 2 出现的个数远远多于 5，换言之找到一个 5，一定能找到一个 2 与之配对。所以我们只需要找有多少个 5。
 * <p>
 * 直接的，我们只需要判断每个累乘的数有多少个 5 的因子即可。
 *
 * @author : [Sammy]
 * @version : [v1.0]
 * @createTime : [2023/10/30 11:13]
 */
public class TrailingZeroes {
	public int trailingZeroes(int n) {
		int count = 0;
		for (int i = 1; i <= n; i++) {
			int N = i;
			while (N > 0) {
				if (N % 5 == 0) {
					count++;
					N /= 5;
				} else {
					break;
				}
			}
		}
		return count;
	}
}
