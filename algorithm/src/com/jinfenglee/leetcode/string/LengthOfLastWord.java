package com.jinfenglee.leetcode.string;

/**
 * @TODO length of last word  
 * For example:
 * Given s = "Hello World",
 * return 5.
 * 
 * @author LJF
 * @date 2015-02-06 08:37:26
 * @review 2015-03-06 23:54:30  A very easy question, no need to review again.
 * 
 */
public class LengthOfLastWord {

	public static void main(String[] args) {
		String s = " ";
		System.out.println(lengthOfLastWord(s));
	}

	public static int lengthOfLastWord(String s) {
		/*
		 *  take care: s is possible " ".   In fact, the question note explicitly that 
		 *  sequence consists of non-space characters only.
		 */
		if (s.isEmpty() || s.trim().isEmpty()) {
			return 0;
		}
		String[] str = s.split(" ");
		return str[str.length-1].length();
	}
}
