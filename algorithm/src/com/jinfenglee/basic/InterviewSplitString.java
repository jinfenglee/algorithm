package com.jinfenglee.basic;

/**
 * 题目:给定一个字符串，例如abc123de4f67,把里面所有的数字子串找出来，
 * 并且存贮起来，例如你要把123，4，67找出来，放到3个char型数组里。 
 * 这个题目很经典了，相信很多人都知道。
 * 
 * @author LJF
 * @date 2015-01-14 08:18:37
 * @review 2015-04-22 23:36:50
 * 
 */
public class InterviewSplitString {
	public static void main(String[] args) {
		String s = "abc123de4f67";
		char [][]c = new char[5][];

		// \\D+数字出现一次或多次
		String nums[] = s.split("\\D+");
		for (int i = 0; i < nums.length; i++) {
			// nums[0]=" "
			if (!nums[i].trim().equals("")) {
				c[i] = nums[i].toCharArray();

				for (int j = 0; j < c[i].length; j++) {
					System.out.print(c[i][j] + " ");
				}

				System.out.println();
			}
		}
	}
}
