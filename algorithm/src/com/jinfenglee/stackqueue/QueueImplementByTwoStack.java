package com.jinfenglee.stackqueue;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 
 * 使用两个栈实现一个队列
 * 
 * offer() 和poll() 分别模拟了队列的入队和出队.
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
	 * 出队时先判断s2是否为空，
	 * 如不为空，直接弹出s2的栈顶元素并出队；
	 * 如为空，将s1的元素逐个“倒入”s2，把最后一个元素弹出并出队。
	 * 
	 * 入队时，先判断s1是否为空，
	 * 如果不为空，说明元素都在s1中，将入对元素直接压入s1；
	 * 如果为空，要将s2元素逐个倒回s1，再压入入队元素.
	 * 
	 * 优化：
	 * (入队时，直接将元素压入s1：避免了反复倒栈，仅在需要时才倒一次)
	 * 
	 * 
	 * 注意
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
	 * 提供元素 
	 * 模拟入队
	 * @param o
	 * @return
	 */
	public Integer offer(int o) {
		stack1.push(o);
		return o;
	}
}
