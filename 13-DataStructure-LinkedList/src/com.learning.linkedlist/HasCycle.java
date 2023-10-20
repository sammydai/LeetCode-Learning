package com.learning.linkedlist;


import com.learning.linkedlist.listnode.ListNode;

/**
 * @Package: com.learning.hashtable
 * @Description: 141. Linked List Cycle
 * @Author: Sammy
 * @Date: 2022/2/17 16:11
 */

public class HasCycle {
	public boolean hasCycle(ListNode head) {
		if (head == null || head.next == null) {
			return false;
		}
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null) {   //为空说明不是环形链表
			fast = fast.next.next;
			slow = slow.next;
			if (slow == fast) return true;                    //是环形链表
		}
		return false;
	}
}
