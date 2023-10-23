package com.learning.linkedlist;

import com.learning.linkedlist.listnode.ListNode;

/**
 * 86. Partition List
 *
 * @author : [Sammy]
 * @version : [v1.0]
 * @createTime : [2023/10/23 14:55]
 */
public class PartitionList {
	public ListNode partition(ListNode head, int x) {
		ListNode lessListPre = new ListNode();      // 小于链表的伪头节点
		ListNode noLessListPre = new ListNode();   // 不小于链表的伪头节点
		ListNode lessNode = lessListPre;           //小于链表当前最后一个节点，初始为伪头节点
		ListNode noLessNode = noLessListPre;       //不小于链表当前最后一个节点，初始为伪头节点
		while (head != null) {
			if (head.val < x) {
				lessNode.next = head;
				lessNode = lessNode.next;
			} else {
				noLessNode.next = head;
				noLessNode = noLessNode.next;
			}
			head = head.next;
		}
		noLessNode.next = null;
		lessNode.next = noLessListPre.next;
		return lessListPre.next;
	}
}
