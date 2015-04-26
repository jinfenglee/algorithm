package com.jinfenglee.leetcode.string;

public class AddBinary {
	public static void main(String[] args) {
		String s1 = "1010";
		String s2 = "10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101";
		System.out.println(addBinary(s1, s2));
	}

	public static String addBinary(String a, String b) {
		// if (a.length() == 0)
		// return b;
		// if (b.length() == 0)
		// return a;
		//
		// long result = Long.valueOf(a, 2) + Integer.valueOf(b, 2);
		// return Long.toBinaryString(result);

		int i = a.length() - 1; // i指向a的末尾
		int j = b.length() - 1; // j指向b的末尾
		int c = 0; // carry 进位
		char[] achar = a.toCharArray();
		char[] bchar = b.toCharArray();
		char[] resultChar = new char[Math.max(achar.length, bchar.length) + 2];
		int k = 0; // k指向结果数组的开头

		while (true) {
			// c==0 表示没有进位
			if (i < 0 && j < 0 && c == 0) {
				break;
			}

			int aint = 0;
			int bint = 0;

			if (i >= 0) {
				aint = achar[i] - '0';
			}
			if (j >= 0) {
				bint = bchar[j] - '0';
			}
			if (aint + bint + c > 1) {
				resultChar[k] = (char) ('0' + aint + bint + c - 2);
				c = 1;
			} else {
				resultChar[k] = (char) ('0' + aint + bint + c);
				c = 0;
			}
			k++;
			i--;
			j--;
		}
		// char数组转string,然后revese()
		return new StringBuffer(new String(resultChar, 0, k)).reverse().toString();
	}

}
