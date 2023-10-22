package com.learning.linkedlist;

import com.learning.linkedlist.listnode.ListNode;

/**
 * 82. Remove Duplicates from Sorted List II
 *
 * @author : [Sammy]
 * @version : [v1.0]
 * @createTime : [2023/10/23 00:45]
 */
public class DeleteDuplicates {
	public ListNode deleteDuplicates(ListNode head) {
		ListNode dummy = new ListNode();
		dummy.next = head;
		ListNode pre = dummy;
		ListNode node = head;
		while (node != null && node.next != null) {
			if (node.val == node.next.val) {
				while (node.next != null && node.val == node.next.val) {
					node = node.next;
				} //把所有的重复节点找到
				pre.next = node.next; //重复节点的前一个节点指向后一个节点
			} else {
				pre = pre.next; //没有重复节点 pre往后移动
			}
			node = node.next; // 不管有没有重复节点 node往后移动
		}
		return dummy.next;
	}
}
