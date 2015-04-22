package com.jinfenglee.programmingbeauty;

/**
 *“编程之美” 3.4 拓展问题：
 * 给定一个链表头指针，只允许遍历链表一次，将链表反转
 * 
 * @author LJF
 * @version 2014-02-13
 * 
 */
public class _3_04_2_ReverseLinklist {

	/**
	 * 非递归 
	 * 
	 * @param firstNode
	 *            指定链表的头指针
	 * @return 反序链表的头指针
	 */
	public static ChainNode reverseLinkedlist0(ChainNode firstNode) {
		
		// 空链表(只有头指针)或单节点链表
		if (firstNode == null || firstNode.next == null){
			return firstNode;
		}else {
			ChainNode p = firstNode;// 当前处理节点的下一个节点
			ChainNode q = null; // 当前处理节点的前一个节点
			ChainNode r = null; // 当前处理节点
			while (p != null) {
				r = p;
				p = p.next;
				r.next = q;
				q = r;
			}
			return r;
		}
	}

	/**
	 * 递归算法实现链表反转问题： 给定一个链表头指针，只允许遍历链表一次，将链表反转
	 * 
	 * @param firstNode
	 *            指定链表的头指针
	 * @return 反序链表的头指针
	 */
	public static ChainNode reverseLinkedlist_Recursion(ChainNode firstNode) {
		// 空链表或单节点链表
		if (firstNode == null || firstNode.next == null) {
			return firstNode;
		} else {
			ChainNode p = firstNode;
			ChainNode r = reverseLinkedlist_Recursion(p.next);
			p.next.next = p;
			p.next = null;

			return r;
		}
	}

	public static void main(String[] args) {
		// ChainNode next_1=null;
		ChainNode node = new ChainNode(0);
		System.out.println("chainnode");
		
	}
}

// 链表节点类
class ChainNode {
	public int element;
	public ChainNode next;

	public ChainNode(int element) {
		this.element = element;
	}

	public ChainNode(int element, ChainNode next) {
		this.element = element;
		this.next = next;
	}
}
