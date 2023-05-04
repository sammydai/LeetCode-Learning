package com.learning.twopoints;

/**
 * [一句话描述该类的功能]
 *
 * @author : [Sammy]
 * @version : [v1.0]
 * @createTime : [2023/4/28 17:10]
 */
public class RemoveListNode {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null) return null;
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null) {
			if (slow.val != fast.val) {
				slow.next = fast;
				slow = slow.next;
			}
			fast = fast.next;
		}
		slow.next = null;
		return head;
	}
}
