package com.jinfenglee.stackqueue;

import java.util.Stack;

/**
 * 使用一个栈把十进制转换成二进制
 * @author li.jf
 * @date 2017-12-27
 *
 */
public class StackOctToBinary {

	public static void main(String[] args) {	
		int num = 12;
		Stack<String> stack = new Stack<String>();  
        while (num != 0) {  
            stack.push(String.valueOf(num % 2));  
            num /= 2;  
        }  
  
        StringBuilder sb = new StringBuilder();  
        while (!stack.isEmpty()) { 
            sb.append(stack.pop());  
        }  
        
        System.out.println(sb);

	}

}
