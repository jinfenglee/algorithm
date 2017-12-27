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
		queue.enQueue(9);
		queue.enQueue(8);
		queue.enQueue(7);
		result.add(queue.deQueue());
		queue.enQueue(4);
		result.add(queue.deQueue());
		queue.enQueue(5);
		result.add(queue.deQueue());
		result.add(queue.deQueue());
		result.add(queue.deQueue());
		
		System.out.println(result.toString());
	}

	/**
	 * 出队
	 * 把stack1 作为存储空间， stack2作为缓冲区.
	 * @return
	 */
	private Integer deQueue() {
		Integer result = null;
		// 两个栈都为空进行的特殊处理
		if (stack1.isEmpty() && stack2.isEmpty()) {
			return null;
		}

		if (!stack2.empty()) {
			result = stack2.pop();
		} else {
			// move to stack2 to make stack1 have only one element. Then pop this element.
			while (!stack1.empty()) {
				result = stack1.pop();
				stack2.push(result);
			}
			
			if (!stack2.empty()) {
				result = stack2.pop();
			}
		}
		return result;
	}
	
	/**
	 * 入队    O(1)
	 * @param element
	 * @return
	 */
	private void enQueue(int element) {
		stack1.push(element);
//		return element;
	}
}