package com.jinfenglee.linkedlist;

import java.util.HashMap;

/**
 * 单链表是否有环
 * 
 * @author li.jf
 * @date 2017/12/20
 *
 */
public class IsSingleListContainsCircle {

	/**
	 * 一个一步长，一个两步，当两个指针相遇时，则存在环。
	 * @param node
	 * @return
	 */
	public static boolean hasCicle(Node node) {
		// 链表为空或者链表只有头结点
		if (node == null || node.getNext() == null) {
			return false;
		}
		
		Node p = node.getNext();// p每次一步
		Node q = node.getNext().getNext();// q每次两步
		
		while (q != null && q.getNext() != null) { 
			if (p == q) { // 有环
				return true; 
			}
			p = p.getNext();
			q = q.getNext().getNext();
		}
		return false;
	}

	/**
	 * 将每次走过的节点保存到hash表中，如果节点在hash表中，则表示存在环
	 * @param n
	 * @return
	 */
	public static boolean hasCircle2(Node n) {
		Node temp1 = n;
		HashMap<Node, Node> ns = new HashMap<Node, Node>();
		while (n != null) {
			if (ns.get(temp1) != null)
				return true;
			else
				ns.put(temp1, temp1);
			
			temp1 = temp1.getNext();
			if (temp1 == null)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);

		n1.setNext(n2);
		n2.setNext(n3);
		n3.setNext(n4);
		n4.setNext(n5);
		n5.setNext(n1); // 构造一个带环的链表,去除此句表示不带环

		System.out.println(hasCicle(n1));
		System.out.println(hasCircle2(n1));
	}

}
