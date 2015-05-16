package com.jinfenglee.stackqueue;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 使用两个栈实现一个队列
 * 
 * @version 2014-02-12 09:26:25
 * @review 2015-05-16 23:47:38
 * ref：http://www.cnblogs.com/wanghui9072229/archive/2011/11/22/2259391.html 
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
		List<Integer> result = new ArrayList<Integer>();
		queue.push(1);
		queue.push(6);
		queue.push(3);
		result.add(queue.poll());
		queue.push(4);
		result.add(queue.poll());
		queue.push(5);
		result.add(queue.poll());
		result.add(queue.poll());
		result.add(queue.poll());
		System.out.println(result.toString());
	}

	/**
	 * 出队
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
			// move to stack2 to make stack1 have only one element.Then pop this element.
			while (!stack1.empty()) {
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
	 * 入队
	 * @param o
	 * @return
	 */
	public Integer push(int o) {
		stack1.push(o);
		return o;
	}
}