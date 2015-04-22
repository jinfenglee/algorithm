package com.jinfenglee.programmingbeauty;

/**
 * 
 * 解法3：要想判断s1移位后的字符串是否包含s2，其实意思就是“如果我们把字符串看成是一个循环字符串，
 * 那么问s2字符串中的字符能否在s1这个循环字符串中顺序连续的出现， 如果能，则说明包含，如果不能，则说明不包含。”。
 * 
 * 这种效率是最高的. 使用取余，方法很巧妙.
 * 
 * @author LJF
 * @date: 2014-05-07 15:04:53
 * 
 */
public class _3_01_3_StrShiftInclude3 {
	public static void main(String[] args) {
		String s1 = "AABCD";
		String s2 = "CDAA";
		System.out.println(containStr4(s1, s2));
	}

	private static boolean containStr4(String s1, String s2) {
		int i = 0;
		int j = 0;

		while (i < s1.length() && s1.charAt(i) != s2.charAt(j)) {
			i++;
		}

		for (; i < s1.length() && j < s2.length();) {

			if (s1.charAt(i) != s2.charAt(j)) {
				return false;
			}

			// 主要就是这一条语句.
			// 其实没必要对 s1 进行真正的移位, 依次从 s1[0], s1[1], ... 开始比较,
			// 如果 s1 的下标超出范围, 就对其取余, 这样就相当于延长字符串 s1 了.
			i = (i + 1) % s1.length();

			j++;
		}

		if (j == s2.length()) {
			System.out.println("contain!");
			return true;
		}

		return false;
	}

}
