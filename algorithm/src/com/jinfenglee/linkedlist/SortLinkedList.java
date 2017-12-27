package com.jinfenglee.linkedlist;

/**
 * TODO: 后续补充 快速排序的链表实现
 * 
 * 对单链表进行排序            链表排序：https://www.cnblogs.com/bywallance/p/6726251.html
 * @author li.jf 
 * @date 2017-12-26
 *
 */
public class SortLinkedList {
	public static void main(String[] args) {
		MyNode head = new MyNode();
		head.val = -1;
		head.next = null;

		MyNode p = head; // 定义指针
		initLinkedList(p);
		
		bubbleSort(head);
		printSingleList(head);
	}
	
	private static void initLinkedList(MyNode p) {
		for (int i = 10; i >=1; i--) {
			MyNode q = new MyNode();
			q.val = i;
			q.next = null;
			p.next = q;
			p = q;
		}
	}
	
	private static void printSingleList(MyNode head) {
		while (head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
		System.out.println();
	}
	
	
	/**
	 * 冒泡排序  比较相邻的节点，如果是逆序就交换
	 * @param head
	 * @return
	 */
    public static MyNode bubbleSort(MyNode head){
        if(head == null || head.next == null)
            return head;
        
        MyNode cur = null, tail = null;
        cur = head;
        
        while(cur.next != tail){
            while(cur.next != tail){
                if(cur.val > cur.next.val){
                    int tmp = cur.val;
                    cur.val = cur.next.val;
                    cur.next.val = tmp;
                }
                cur = cur.next;
            }
            
            tail = cur;  //下一次遍历的尾结点是当前结点(仔细琢磨一下里面的道道)
            cur = head;     //遍历起始结点重置为头结点    
        }
        
        return head;
    }

}

class MyNode {
	MyNode next;
	int val;
}
