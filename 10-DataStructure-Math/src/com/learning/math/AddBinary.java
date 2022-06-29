package com.learning.math;

import java.util.jar.JarEntry;

/**
 * @Package: com.learning.math
 * @Description: 67. Add Binary
 * @Author: Sammy
 * @Date: 2022/2/18 17:05
 */

public class AddBinary {
	public String addBinary(String a, String b) {
		StringBuffer result = new StringBuffer();
		//关键是进位
		int carry = 0;
		int i = a.length() - 1, j = b.length() - 1;
		while (i >= 0 || j >= 0) {
			int tempSum = carry;
			if (i >= 0) {
				tempSum += a.charAt(i--) - '0';
			}
			if (j >= 0) {
				tempSum += b.charAt(j--) - '0';
			}
			carry = tempSum >= 2 ? 1 : 0;
			result.append(tempSum % 2);
		}
		if (carry==1) result.append("1");
		return result.reverse().toString();
	}
}
