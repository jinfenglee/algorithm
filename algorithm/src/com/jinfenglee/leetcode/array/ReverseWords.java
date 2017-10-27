package com.jinfenglee.leetcode.array;

/**
 * 反转字符串中的英文单词 "how are you" --> "you are how"
 * 
 * @author LJF
 * @date 2014-10-27 22:08:30
 */
public class ReverseWords {
	public static void main(String[] args) {
		String s = "    ";
		System.out.println(reverseWords(s));
	}

	private static String reverseWords(String s) {
		if (s == null)
			return "";

		String[] str = s.split(" ");
		StringBuilder builder = new StringBuilder();

		for (int i = str.length - 1; i >= 0; i--) {
			if (!str[i].equals("")) {
				builder.append(str[i]).append(" "); 
			}
		}
		if (builder.length() != 0 && builder.toString().trim().length() == 0) {
			return s;
		}

		return builder.length() == 0 ? "" : builder.substring(0,
				builder.length() - 1);
	}

}
