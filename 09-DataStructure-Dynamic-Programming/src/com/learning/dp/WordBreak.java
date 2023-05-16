package com.learning.dp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 139. Word Break
 *
 * @author : [Sammy]
 * @version : [v1.0]
 * @createTime : [2023/5/16 11:15]
 */
public class WordBreak {
	public boolean wordBreak(String s, List<String> wordDict) {
		//dp[i] 表示字符串 s 的 [0,i) (当 i==0 时表示空串) 的字母组成的单词能否由字典中的单词拼接而成
		// 状态转移的时候，考虑枚举分割点 j (0 <= j <= i) , 将字符串分成 [0,j) 和 [j,i) 两部分, 注意 j==0 时，第一部分是空串，j==i 时，第二部分是空串
		// 如果两部分都在字典中，则整个串可以由字典中的单词拼成
		// 因为计算到 dp[i] 的时候，已经计算出了 dp[0]....dp[i-1] 的值, 所以 [0,j) 直接由 dp[j] 即可得到
		// 所以只需计算 [j,i) 在不在字典中即可
		// 所以如果 [j,i) 在字典中且 dp[j] 为 true , 则 dp[i] = true , 否则 dp[i] = false
		int len = s.length();
		Set<String> wordDictSet = new HashSet(wordDict);
		boolean[] dp = new boolean[len + 1];
		Arrays.fill(dp, false);
		dp[0] = true;
		for (int i = 1; i <= len; i++) {
			for (int j = 0; j <= i; j++) {
				if (dp[j] && wordDict.contains(s.substring(j, i))) {
					dp[i] = true;
					break;
				}
			}
		}
		return dp[len];

	}
}
