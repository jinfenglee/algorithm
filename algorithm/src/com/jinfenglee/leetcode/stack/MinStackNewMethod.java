package com.jinfenglee.leetcode.stack;

import java.util.Stack;

public class MinStackNewMethod {

	long min;
	Stack<Long> stack;// 有减法，所以用long，将数据越界考虑在内   test

	public MinStackNewMethod(){
	        stack=new Stack<Long>();
	    }

	public void push(int x) {
		if (stack.isEmpty()) {
			stack.push(0L);
			min = x;
			return;
		}
		stack.push(x - min);// Could be negative if min value needs to change
		if (x < min)
			min = x;
	}

	public void pop() {
		if (stack.isEmpty())
			return;

		long pop = stack.pop();

		if (pop < 0)
			min = min - pop;// If negative, increase the min value

	}

	public int top() {
		long top = stack.peek();
		if (top > 0) {
			return (int) (top + min);
		} else {
			return (int) (min);
		}
	}

	public int getMin() {
		return (int) min;
	}
}
