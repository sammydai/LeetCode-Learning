package com.learning.linkedlist.listnode;

/**
 * @Package: com.learning.linkedlist.listnode
 * @Description:
 * @Author: Sammy
 * @Date: 2022/1/28 13:10
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
