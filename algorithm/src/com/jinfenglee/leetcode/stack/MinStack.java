package com.jinfenglee.leetcode.stack;

import java.util.ArrayList;
import java.util.List;

/**
 * Design a stack that supports push, pop, top, and retrieving <br/>
 * the minimum element in constant time.
 * 
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 * 
 * @author LJF
 * @date 2014-11-13 20:58:37
 * 
 */
public class MinStack {
	/*Stack<Integer> data;
	Stack<Integer> mindata;

	void push(int x) {
		data.push(x);
		// 最小元素栈，只有栈为空或待插元素小于栈中元素值才允许入栈.
		if (mindata.empty() || mindata.peek() >= x)
			mindata.push(x);
	}

	void pop() {
		// 注意这一点，可以使用2,1,2模拟一下.
		if (mindata.peek() == data.peek())
			mindata.pop();
		data.pop();
	}

	public int top() {
		return data.peek();
	}

	int getMin() {
		return mindata.peek();
	}*/
	
	 private List<Integer> stack = new ArrayList<Integer>();  
	    private List<Integer> minstack = new ArrayList<Integer>();  
	    public void push(int x) {  
	        stack.add(x);  
	        if(minstack.isEmpty() || minstack.get(minstack.size()-1) >= x)  
	            minstack.add(x);  
	    }  
	  
	    public void pop() {  
	        if(stack.isEmpty())  
	            return;  
	        int tmp = stack.remove(stack.size()-1);  
	        if(!minstack.isEmpty() && tmp == minstack.get(minstack.size()-1))  
	            minstack.remove(minstack.size()-1);  
	    }  
	  
	    public int top() {  
	        if(!stack.isEmpty())  
	            return stack.get(stack.size()-1);  
	        return -1;  
	    }  
	  
	    public int getMin() {  
	        if(!minstack.isEmpty())  
	            return minstack.get(minstack.size()-1);  
	        return -1;  
	    }  
}
