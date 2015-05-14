package com.jinfenglee.stackqueue;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 
 * ʹ������ջʵ��һ������
 * 
 * offer() ��poll() �ֱ�ģ���˶��е���Ӻͳ���.
 * 
 * @author LJF
 * @version 2014-02-12 09:26:25
 * 
 */
public class QueueImplementByTwoStack {
	private Stack<Integer> stack1;
	private Stack<Integer> stack2;

	public QueueImplementByTwoStack() {
		stack1 = new Stack<Integer>();
		stack2 = new Stack<Integer>();
	}

	public static void main(String[] args) {
		QueueImplementByTwoStack queue = new QueueImplementByTwoStack();
		List<Integer> re = new ArrayList<Integer>();
//		queue.poll();
		/*if (queue == null) {
			System.out.println("hello");
			try {
				throw new Exception();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}*/
	/*	queue.offer(1);
		queue.offer(2);
		queue.offer(3);*/
		re.add(queue.poll());
		queue.offer(4);
		re.add(queue.poll());
		queue.offer(5);
		re.add(queue.poll());
		re.add(queue.poll());
		re.add(queue.poll());
		System.out.println(re.toString());
	}

	/**
	 * ����ʱ���ж�s2�Ƿ�Ϊ�գ�
	 * �粻Ϊ�գ�ֱ�ӵ���s2��ջ��Ԫ�ز����ӣ�
	 * ��Ϊ�գ���s1��Ԫ����������롱s2�������һ��Ԫ�ص��������ӡ�
	 * 
	 * ���ʱ�����ж�s1�Ƿ�Ϊ�գ�
	 * �����Ϊ�գ�˵��Ԫ�ض���s1�У������Ԫ��ֱ��ѹ��s1��
	 * ���Ϊ�գ�Ҫ��s2Ԫ���������s1����ѹ�����Ԫ��.
	 * 
	 * �Ż���
	 * (���ʱ��ֱ�ӽ�Ԫ��ѹ��s1�������˷�����ջ��������Ҫʱ�ŵ�һ��)
	 * 
	 * 
	 * ע��
	 * @return
	 */
	public Integer poll() {
		Integer re = null;
		if (stack1.isEmpty() && stack2.isEmpty()) {
			return null;
		}

		if (!stack2.empty()) {
			re = stack2.pop();
		} else {
			while (!stack1.empty()) {// move to stack2 to make stack1 have only
										// one element.Then pop this element.
				re = stack1.pop();
				stack2.push(re);
			}
			if (!stack2.empty()) {
				re = stack2.pop();
			}
		}
		return re;
	}

	/**
	 * �ṩԪ�� 
	 * ģ�����
	 * @param o
	 * @return
	 */
	public Integer offer(int o) {
		stack1.push(o);
		return o;
	}
}
