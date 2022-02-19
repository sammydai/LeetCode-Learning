package com.learning.linkedlist;

import com.learning.linkedlist.listnode.ListNode;

/**
 * @Package: com.learning.linkedlist
 * @Description: 19. Remove Nth Node From End of List
 * @Author: Sammy
 * @Date: 2022/2/17 10:20
 */

public class RemoveNthFromEnd {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode dummy = new ListNode();
		dummy.next = head;
		ListNode fast = head;
        ListNode slow = head;
        ListNode pre = dummy;
		while (fast!= null) {
			fast = fast.next;
			n--;
			if (n==0) {
				break;
			}
		}
		if (n > 0 ) return null;
		while (fast != null) {
			fast = fast.next;
			slow = slow.next;
			pre = pre.next;
		}
		pre.next = slow.next;
		return dummy.next;
	}
}
