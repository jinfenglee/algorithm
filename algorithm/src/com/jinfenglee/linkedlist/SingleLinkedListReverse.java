package com.jinfenglee.linkedlist;

/**
 * 单链表逆序
 * 
 * @author li.jf
 * @date 2017/12/19
 */
public class SingleLinkedListReverse {

	public static void main(String[] args) {
		Node head = new Node();
		head.setData(-1);
		head.setNext(null);

		Node p = head; // 定义指针
		initLinkedList(p);

		printSingleList(head);
		System.out.println("after reverse single Linkedlist: ");
		printSingleList(reverseList(head));
	}

	/**
	 * init linked list
	 * 
	 * @param p
	 */
	private static void initLinkedList(Node p) {
		for (int i = 10; i >=1; i--) {
			Node q = new Node();
			q.setData(i);
			q.setNext(null);
			p.setNext(q);
			p = q;
		}
	}
	

	/**
	 * 链表输出
	 * 
	 * @param head
	 */
	private static void printSingleList(Node head) {
		while (head != null) {
			System.out.print(head.getData() + " ");
			head = head.getNext();
		}
		System.out.println();
	}

	/**
	 * 链表逆序
	 * 
	 * @param node
	 *            原始链表头节点
	 * @return 逆序后链表头节点
	 */
	private static Node reverseList(Node head) {
		if (head.getNext() == null || head.getNext().getNext() == null) { // 链表为空或者只有一个元素
			return head;
		}
		
		Node p = head.getNext();
		Node q = head.getNext().getNext();
		Node temp = null;
		while (q != null) {
			temp = q.getNext();
			q.setNext(p);
			p = q;
			q = temp;
		}
		
//		head.setNext(null);
		head.getNext().setNext(null); // 原本首元素的next指针域设为null
		head.setNext(p); // 修改表头
		return head;
	}
}


