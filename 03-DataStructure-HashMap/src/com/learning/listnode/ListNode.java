package com.learning.listnode;

/**
 * @Package: com.learning.listnode
 * @Description: ListNode
 * @Author: Sammy
 * @Date: 2022/2/17 16:12
 */

public class ListNode {
	public int val;
	public ListNode next;

	public ListNode() {
	}

	public ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}
