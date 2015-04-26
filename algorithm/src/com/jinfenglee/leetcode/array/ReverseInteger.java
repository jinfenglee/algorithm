package com.jinfenglee.leetcode.array;

/**
 * 对一个整数进行反转  如： 123-->321   0-->0   -123 --> -321
 * 
 * @author LJF
 * @date 2014-10-25 20:17:46
 * @review 2015-01-19 22:00:04
 * 
 */
public class ReverseInteger {
	public static void main(String[] args) {
		int a = 0;
		System.out.println(reverse(a));
	}
	
	/**
	 * 反转一个整数
	 * @param x 待反转的整数
	 * @return
	 */
	private static int reverse(int x) {
		String s = String.valueOf(x);
		StringBuffer buffer;
		if (x >= 0) {
			buffer = new StringBuffer(s);
			return Integer.valueOf(buffer.reverse().toString());
		} else {
			String temp = s.substring(1);
			buffer = new StringBuffer(temp);
			return Integer.valueOf("-" + buffer.reverse().toString());
		}
	}

}
