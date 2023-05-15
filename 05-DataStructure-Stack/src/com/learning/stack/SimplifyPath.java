package com.learning.stack;


import java.util.Stack;

/**
 * [一句话描述该类的功能]
 *
 * @author : [Sammy]
 * @version : [v1.0]
 * @createTime : [2023/5/12 12:09]
 */
public class SimplifyPath {
	public static void main(String[] args) {
		System.out.println(new SimplifyPath().simplifyPath("/a/./b/../../c/"));
		System.out.println(new SimplifyPath().simplifyPath("/../"));
	}

	public String simplifyPath(String path) {
		Stack<String> stack = new Stack<>();
		for (String item : path.split("/")) {
			if (item.equals("..")) {
				if (!stack.isEmpty()) {
					stack.pop();
				}
			} else if (!item.isEmpty() && !item.equals(".")) {
				stack.push(item);
			}
		}
		String res = "";
		while (!stack.isEmpty()) {
			res = "/" + stack.pop() + res;
		}
		return res.isEmpty() ? "/" : res;
	}
}
