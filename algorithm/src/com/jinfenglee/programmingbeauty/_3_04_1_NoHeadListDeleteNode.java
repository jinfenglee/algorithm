package com.jinfenglee.programmingbeauty;

/**
 * 编程之美 3.4  从无头单链表中删除节点，该节点非首尾
 * 
 * 思路：把待删除节点的下一个节点的数据域赋值给待删除节点的数据域，然后把这 “下一个节点”删除即可.
 * 
 * @author LJF
 * @Date 2014-02-14
 * 
 */
public class _3_04_1_NoHeadListDeleteNode {

	// 链表中节点的两个属性：元素值和指向下一个节点的指针
	protected class ChainNode {
		public Object elem;
		public ChainNode next;

		public ChainNode(Object elem, ChainNode next) {
			this.elem = elem;
			this.next = next;
		}
	}

	/**
	 * 从无头单链表中删除节点问题：
	 *  假设有一个没有头指针的单链表，一个指针指向此单链表的中间一
	 * 个节点（不是第一个也不是最后一个），将此节点从此链表中删除。
	 * 
	 * 假设链表如下...A->B->C->D..(D可能为空)，现在要删除节点B. 
	 * 由于将B节点删除后，将分割链表（无法通过指针追溯到A），所以
	 * 换个角度：将C的数据域赋值给B的数据域，然后删除C
	 * 
	 * @param current  待删除的节点
	 */
	public static void DeleteRandomNode(ChainNode current) {
		ChainNode pnext = current.next;
		if (pnext != null) {
			current.next = pnext.next;
			current.elem = pnext.elem;
			pnext = null;
		}
	}
}
