package com.learning.linkedlist;

import com.learning.linkedlist.listnode.ListNode;

/**
 * @Package: com.learning.linkedlist
 * 快慢指针，fast指针先走完n，那剩下的就是k-n没走。
 * 然后slow指针再走，当fast走到底，slow指针走了k-n，正好是倒数第n个节点
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
