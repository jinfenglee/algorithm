package com.jinfenglee.leetcode.string;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string containing only digits, restore it by returning all possible <br/> 
 * valid IP address combinations. 
 * For example: 
 * Given "25525511135", return
 * ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 * 
 * @author LJF
 * @date 2014-11-02 11:22:02
 * @review 2015-02-19 22:58:49 (Spring Festival)
 * 
 */
public class RestoreIPAddr {
	public static void main(String[] args) {
		String s = "21115";
		ArrayList<String> list = restoreIPAddresses(s);
		System.out.println(list);
	}

	private static ArrayList<String> restoreIPAddresses(String s) {
		ArrayList<String> list = new ArrayList<String>();
		// 字符串不符合要求，返回空list
		if (s == null || s.length() > 12 || s.length() < 4)
			return list;

		recruIP(s, 1, "", list);
		return list;
	}

	private static void recruIP(String s, int num, String ip, List<String> list) {
		if (s.isEmpty())
			return;
		// IP 地址只有4位时单独考虑
		if (num == 4 && isValid(s)) {
			ip += s;
			list.add(ip);
			return;
		}
		for (int i = 1; i < 4; i++) {
			if (i > s.length())
				break;

			String pre = s.substring(0, i);
			if (isValid(pre)) {
				String subStr = s.substring(i);
				recruIP(subStr, num + 1, ip + pre + ".", list);
			}
		}
	}

	/**
	 * 小数点分割的数字是否有效
	 * 
	 * @param s
	 * @return
	 */
	private static boolean isValid(String s) {
		if (s == null || s.length() == 0)
			return false;
		// 第一个小数点前面的数不能
		if (s.length() > 1 && s.charAt(0) == '0')
			return false;
		int v = Integer.parseInt(s);
		if (v >= 0 && v <= 255)
			return true;
		return false;
	}

}
