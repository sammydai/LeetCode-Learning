package com.learning.linkedlist;

import com.learning.linkedlist.listnode.ListNode;

/**
 * 反转单链表
 *
 * @author : [Sammy]
 * @version : [v1.0]
 * @createTime : [2023/4/28 15:55]
 */
public class ReverseList {
	public ListNode reverseList(ListNode head) {
		if (head == null || head.next == null) return head;
		ListNode last = reverseList(head.next);
		head.next.next = head;
		head = null;
		return last;
	}
}
