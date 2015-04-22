package com.jinfenglee.programmingbeauty;

import java.util.Arrays;

/**
 * 编程之美：3.2 把座机键盘上的数字转换为字母的组合
 * 
 * @author LJF
 * @version 2014-02-12 17:56:31
 * 
 */
public class _3_02_NumToWord {
	private String phoneNumStr; // 字符串合格的电话号码
	private int[] phoneNum; // 数字格式的电话号码
	private int len; // 电话号码的长度
	private char[] result; // 电话号码代表的一个单词

	private static int count = 0;

	private static final String[] LETTERS = { "", // 0
			"", // 1
			"ABC",// 2
			"DEF",// 3
			"GHI",// 4
			"JKL",// 5
			"MNO",// 6
			"PQRS",// 7
			"TUV",// 8
			"WXYZ"// 9
	};
	// 每个数字按键有几个字母， 0,1两个按键没有字母.
	private int[] total = { 0, 0, 3, 3, 3, 3, 3, 4, 3, 4 };

	public _3_02_NumToWord(String phoneNumStr) {
		this.phoneNumStr = phoneNumStr;
	}

	private void numToWord() {
		if (phoneNumStr == null || phoneNumStr.length() == 0) {
			System.out.println("phoneNum is null or empty!");
			return;
		}
		// Regex 正则表达式
		if (!phoneNumStr.matches("[2-9]+")) {
			System.out.println("invalid phoneNum" + phoneNumStr);
			return;
		}

		init();
		dfs(0);
	}

	/**
	 * 递归找出所有组合 
	 * 
	 * 递归结束条件， level等于字符串的长度.
	 * @param level 
	 */
	public void dfs(int level) {

		if (level == len) {
			System.out.println(Arrays.toString(result));
			count++;
			return;
		}
		int num = phoneNum[level];  // phoneNum[0]=2
		String str = LETTERS[num];

		int size = total[num];
		char[] letters = str.toCharArray();

		for (int i = 0; i < size; i++) {
			result[level] = letters[i];
			dfs(level + 1);
		}
	}

	// 初始化change "234"(String) to {2, 3, 4}(int[])
	private void init() {
		int len = phoneNumStr.length();   
		System.out.println(len); // 3
		this.len = len;
		phoneNum = new int[len];

		result = new char[len];   // 注意：result 字符数组要在这里初始化.

		char[] letters = phoneNumStr.toCharArray();

		for (int i = 0; i < len; i++) {
			phoneNum[i] = letters[i] - '0'; // 2的ASCII与 0 的ASCII相减.
//			System.out.println(phoneNum[i]);
		}
	}

	public static void main(String[] args) {
		_3_02_NumToWord data = new _3_02_NumToWord("237");
		data.numToWord();
		System.out.println("the total num of combination is:  " + count);
	}
}
