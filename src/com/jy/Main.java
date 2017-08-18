package com.jy;

public class Main {

	public static void main(String[] args) {
		// 构造链表
		ListNode listNode9 = new ListNode(9, null);
		ListNode listNode8 = new ListNode(8, listNode9);
		ListNode listNode7 = new ListNode(7, listNode8);
		ListNode listNode6 = new ListNode(6, listNode7);
		ListNode listNode5 = new ListNode(5, listNode6);
		ListNode listNode4 = new ListNode(4, listNode5);
		ListNode listNode3 = new ListNode(3, listNode4);
		ListNode listNode2 = new ListNode(2, listNode3);
		ListNode listNode1 = new ListNode(1, listNode2);
		// 头结点
		ListNode headNode = listNode1;

		System.out.print("反转链表前:");
		printListNode(headNode);

		System.out.print("反转链表后:");
		headNode = reverseList(headNode);
		printListNode(headNode);

		System.out.print("反转链表后:");
		headNode = reverseListrecursively(headNode);
		printListNode(headNode);
	}

	/**
	 * 反转链表，并返回反转后链表的头节点
	 * 
	 * @param headNode
	 *            待反转链表的头结点
	 * @return 反转链表的头结点
	 */
	public static ListNode reverseList(ListNode headNode) {
		// 反转后链表的头结点
		ListNode reversedHeadNode = null;
		// 当前节点的前面一个节点
		ListNode preListNode = null;
		// 当前节点
		ListNode listNode = headNode;
		while (listNode != null) { // 鲁棒性检查
			// 当前节点的下一个节点
			ListNode nextListNode = listNode.mNext;
			if (nextListNode == null) // 找到反转链表的头节点
				reversedHeadNode = listNode;
			// 将链表反转
			listNode.mNext = preListNode;
			// 继续下一次反转的准备
			preListNode = listNode;
			listNode = nextListNode;

		}
		return reversedHeadNode;
	}

	/**
	 * 使用递归方式反转链表，并返回反转后链表的头节点
	 * 
	 * @param headNode
	 *            待反转链表的头结点
	 * @return 反转链表的头结点
	 */
	public static ListNode reverseListrecursively(ListNode headNode) {
		// headNode = null,是鲁棒性检查，说明链表为空，直接返回null
		// headNode.mNext = null表明通过递归找到了源链表的为节点，这时返回尾节点作为反转链表的头结点
		if (headNode == null || headNode.mNext == null)
			return headNode;
		// 反转后链表的头结点
		ListNode reversedHeadNode = reverseListrecursively(headNode.mNext);
		// 对源链表的第二个节点和头结点做反转
		headNode.mNext.mNext = headNode;
		// 源链表的头节点指向null
		headNode.mNext = null;
		// 返回反转后链表的头节点
		return reversedHeadNode;
	}

	/**
	 * 从头节点往后遍历输出链表
	 * 
	 * @param headNode
	 *            待输出链表的头节点
	 */
	public static void printListNode(ListNode headNode) {
		ListNode node = headNode;
		for (; node.mNext != null; node = node.mNext) {
			System.out.print(node.mValue + "->");
		}
		System.out.print(node.mValue);
		System.out.println();
	}
}
