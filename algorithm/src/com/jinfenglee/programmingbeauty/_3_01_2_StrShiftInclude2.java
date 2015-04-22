package com.jinfenglee.programmingbeauty;


/**
 * 3.1 两个字符串循环包含问题.
 * 比较常规的方法，时间复杂度比较大. 
 * @author LJF
 * @version 2014-05-07 14:57:38
 * 
 */
public class _3_01_2_StrShiftInclude2 {
	public static void main(String[] args) {
		String s1 = "AABCD";
		String s2 = "CDAA";
		System.out.println(shiftContains(s1, s2));
	}

	/**
	 * s1 是否循环包含s2
	 * 
	 * @param s1
	 * @param s2
	 * @return boolean 是否包含
	 */
	private static boolean shiftContains(String s1, String s2) {
		char[] str1 = s1.toCharArray();
		char[] str2 = s2.toCharArray();

		for (int i = 0; i < str1.length; i++) {
			char temp = str1[0];

			for (int j = 0; j < str1.length - 1; j++) {
				str1[j] = str1[j + 1];
			}
			str1[str1.length - 1] = temp;

			if (containStr2(str1, str2)) {
				return true;
			}
		}

		return false;
	}

	/**
	 * str1[]是否包含str2[]
	 * 
	 * @param str1
	 * @param str2
	 * @return
	 */
	private static boolean containStr2(char[] str1, char[] str2) {
		if (str1 == null || str2 == null || str1.length == 0
				|| str2.length == 0) {
			return false;
		}

		if (str1.length >= str2.length) {
			int i = 0;
			int j = 0;

			while (i < str1.length && str1[i] != str2[j]) {
				i++;
			}

			for (; i < str1.length && j < str2.length; i++, j++) {
				// 该循环得到的字符串str1不包含str2.
				if (str1[i] != str2[j]) {
					break;
				}
			}

			if (j == str2.length) {
				return true;
			}
		}
		return false;
	}
}
