package com.learning.kmp;

import java.security.cert.X509Certificate;

/**
 * @Package: com.learning.kmp
 * @Description: Boyer-Moore
 * @Author: Sammy
 * @Date: 2020/11/26 08:51
 */
public class BoyerMoore {
	private static final int SIZE = 256;

	private static void generateBC(char[] b, int m, int[] bc) {
		for (int i = 0; i < SIZE; i++) {
			bc[i] = -1;
		}
		for (int i = 0; i < b.length; i++) {
			int ascii = b[i];
			bc[ascii] = i;
		}
	}

	/**
	 *
	 * @param a
	 * @param n
	 * @param b 模式串
	 * @param m 模式串的长度
	 * @return
	 */
	public int bm(char[] a, int n, char[] b, int m) {
		int[] bc = new int[SIZE];
		generateBC(b, m, bc);
		int i = 0;
		while (i<=n-m) {
			int j;
			for (j = m-1; j >=0; --j) {
				if (b[j]!=a[j+i]) {
					break; //找到坏字符串j的位置
				}
			}
			if (j < 0) {
				return i;
			}
			int x = bc[a[i + j]];//坏字符在模式串中的位置

		}
		return -1;
	}
}
