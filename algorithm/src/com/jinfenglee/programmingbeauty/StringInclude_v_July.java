package com.jinfenglee.programmingbeauty;

/**
 * 假设这有一个各种字母组成的字符串A，和另外一个字符串B， 
 * 字符串里B的字母数相对少一些。 什么方法能最快的查出所有小字符串B里的字母在大字符串A里都有？
 * 
 * @author LJF
 * @date 2014-10-19 09:56:52
 * @description 思路来自算法大牛v_july的博客
 * 
 * 需要改进之处：
 * 1、只考虑大写字符，没有考虑小写字符以及数字
 * 2、没有考虑重复字符
 * 
 */
public class StringInclude_v_July {
	public static void main(String[] args) {
		String longStr = "ABCDEFGHLMNOPQRS";
		String shortStr = "ZDCGSRQPO";
//		compareString(longStr, shortStr);
		
		compareStr2(longStr,shortStr);

	}
	/**
	 * M2:使用hash表  总的时间复杂度为 O(m+n),比方法1好很多.
	 * @param longStr
	 * @param shortStr
	 */
	private static void compareStr2(String longStr, String shortStr) {
		
		int hash[] = new int[26];
		int num = 0; // 辅助数组元素个数
		for (int j = 0; j < shortStr.length(); j++) {
			// 字符  --> 对应辅助数组的索引
			int index = shortStr.charAt(j) - 'A';

			if (hash[index] == 0) {
				hash[index] = 1;
				num++;
			}
		}
		
		for (int i = 0; i < longStr.length(); i++) {
			int index = longStr.charAt(i) - 'A';

			if (hash[index] == 1) {
				hash[index] = 0;
				num--;
				if (num == 0)
					break;
			}
		}
		
		if (num == 0)
			System.out.println("true");
		else
			System.out.println("false");
		
	}

	
	
	/**
	 * M1：时间复杂度为O(m*n),易想，但非常不好。 
	 * @param longStr
	 * @param shortStr
	 * @return
	 */
//	private static int compareString(String longStr, String shortStr) {
//		int i,j;
//		
//		for (i = 0; i < shortStr.length(); i++) {
//			for (j = 0; j < longStr.length(); j++) {
//				if (shortStr.charAt(i) == longStr.charAt(j)) {
//					break;  // 退出当前循环
//				}
//			}
//			
//			if (j==longStr.length()) {
//				System.out.println("false");
//				return 0;
//			}
//		}
//		
//		System.out.println("true");
//		return 1;
//	}

}
