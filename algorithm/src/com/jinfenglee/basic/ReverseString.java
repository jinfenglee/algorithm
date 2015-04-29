package com.jinfenglee.basic;

/**
 * 把字符串逆序
 * 
 * @author LJF
 * @date 2014-09-25 06:52:05
 * 
 */
public class ReverseString {
	public static void main(String[] args) {
		String s = "adds2234";
		System.out.println(myReverse(s));
	}
	
	/**
	 * 时间和空间复杂度均为 O(n)
	 * @param s
	 * @return
	 */
	private static String myReverse(String s) {
		char[] a = s.toCharArray();
		int i = 0;
		char temp;
		int arrLen = a.length - 1;
		while (i < arrLen) {
			temp = a[i];
			a[i++] = a[arrLen];
			a[arrLen--] = temp;
		}
		
		return String.copyValueOf(a);
	}
}
