package com.jinfenglee.basic;

/**
 * String Include (no using Java API like IndexOf() or contains() )
 * 
 * @author LJF
 * @date 2014-09-22 23:36:01
 */
public class StringInclude {
	public static void main(String[] args) {
		String s1 = "12346";
		String s2 = "2345";
		if (s1.length() >= s2.length())
			System.out.println(myContains(s1, s2));
		else
			System.out.println(myContains(s1, s2));
		
		// System.out.println(s1.contains(s2));
	}

	private static boolean myContains(String s1, String s2) {
		char[] a = s1.toCharArray();
		char[] b = s2.toCharArray();
		int j;
		for (int i = 0; i < a.length - b.length; i++) {
			for (j = 0; j < b.length; j++) {
				if (a[i] != b[j]) {
					break;
				}
			}
			
			if (j == b.length) 
				return true;
		}
		return false;
	}
}
