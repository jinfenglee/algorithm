package com.jinfenglee.linkedlist;

/**
 * 删除有序链表中的重复元素, 并求和
 * 
 * @author li.jinfeng
 * @date 2017-12-20
 *
 */
public class DeleteRepeatElement {

	public static void main(String[] args) {
		DeleteRepeatElement mylist = new DeleteRepeatElement();
		int[] datas = { 1, 2, 3, 4, 4, 4, 5, 5, 5, 5, 6 };
		for (int data : datas) {
			mylist.addNode(data);
		}
		System.out.println("before del: " + mylist);
		mylist.delRepeatedNode();
		System.out.println("after del: " + mylist);
	}

	private class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			next = null;
		}
	}

	private Node head;
	private Node tail;

	// 采用尾插法添加结点
	public void addNode(int data) {
		Node newNode = new Node(data);
		if (tail != null)
			tail.next = newNode;
		else {// first node
			head = newNode;
		}
		tail = newNode;
	}

	// 实现思路：pre 和 next。初始时，pre指向链表中的第一个元素，next指向链表中的第二个元素。
	// 如果 pre 的值与 next 的值不相等，则两个指针分别都向后移一个结点；若相等，则删除 next 指针指向的结点即可。

	// 删除有序单链表中的重复结点
	public void delRepeatedNode() {
		if (head == null) {
			return;
		}

		Node pre, next;
		pre = head;
		next = head.next;

		while (next != null) {
			if (pre.data != next.data) {
				pre = next;
				next = next.next;
			} else {// ddatate next point node
				Node delNode = next;
				pre.next = next.next;
				next = next.next;
				delNode.next = null;// avoid memory leak
				// delNode = null;
			}
		}
	}

	@Override
	public String toString() {
		if (head == null)
			return "null";
		Node current = head;
		StringBuilder sb = new StringBuilder();
		while (current != null) {
			sb.append(current.data + " ");
			current = current.next;
		}
		return sb.toString();
	}
}
