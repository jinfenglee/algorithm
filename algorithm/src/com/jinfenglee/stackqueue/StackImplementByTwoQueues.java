package com.jinfenglee.stackqueue;

import java.util.LinkedList;

/**
 * 用两个队列模拟实现一个栈  （在用两个栈实现一个队列基础上的发散） 
 */
public class StackImplementByTwoQueues {

	// use 'queue1' and 'queue2' as a queue.That means only use the method
	// 'addLast' and 'removeFirst'.
	private LinkedList<Integer> queue1;
	private LinkedList<Integer> queue2;

	public StackImplementByTwoQueues() {
		queue1 = new LinkedList<Integer>();
		queue2 = new LinkedList<Integer>();
	}

	/**
	 * 模拟出栈操作（关键点，不要把队列1的最后一个元素再添加到队列2上）
	 * @return
	 */
	public Integer pop() {
		Integer result = null;
		if (queue1.size() == 0 && queue2.size() == 0) {
			return null;
		}
		
		if (queue2.size() == 0) {
			while (queue1.size() > 0) {
				result = queue1.removeFirst();
				if (queue1.size() != 0) {  // do not add the last element of queue1 to queue2
					queue2.addLast(result);
				}
			}
		} else if (queue1.size() == 0) {
			while (queue2.size() > 0) {
				result = queue2.removeFirst();
				if (queue2.size() != 0) {// do not add the last element of queue2 to queue1
					queue1.addLast(result);
				}
			}
		}
		return result;
	}

	/**
	 * 入栈操作
	 * @param o
	 * @return
	 */
	public void push(Integer o) {
		if (queue1.size() == 0 && queue2.size() == 0) {
			queue1.addLast(o);  //  或者 queue2.addLast(o); 
		}
		if (queue1.size() != 0) {
			queue1.addLast(o);
		} else if (queue2.size() != 0) {
			queue2.addLast(o);
		}
//		return o;
	}

	public static void main(String[] args) {
		StackImplementByTwoQueues stack = new StackImplementByTwoQueues();
		int temp = 0;
		stack.push(1);
		stack.push(2);
		stack.push(3);
		temp = stack.pop();
		System.out.println(temp);// 3
		stack.push(4);
		temp = stack.pop();
		System.out.println(temp);// 4
		temp = stack.pop();
		System.out.println(temp);// 2
		stack.push(5);
		stack.push(6);
		temp = stack.pop();
		System.out.println(temp);// 6
		temp = stack.pop();
		System.out.println(temp);// 5
		temp = stack.pop();
		System.out.println(temp);// 1
	}
}
