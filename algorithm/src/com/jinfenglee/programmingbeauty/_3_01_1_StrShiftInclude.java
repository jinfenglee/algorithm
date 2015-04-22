package com.jinfenglee.programmingbeauty;

/**
 * 问题：给定两个字符串s1和s2，要求判断s2是否能够通过s1做循环移位操作得到的字符串包含。
 * 例如，给定s1＝AABCD和s2=CDAA，返回true；给定s1=ABCD和s2=ACBD，返回false。
 * 
 * @author LJF
 * @date 2014-03-26 14:23
 * 
 */

// 直接下面的这个方法就可以
//	public static boolean containStr2(String s1, String s2) {
//		s1 = s1.concat(s1);
//		return s1.contains(s2);
//	}

public class _3_01_1_StrShiftInclude {

	private static final int MATCH = 1;
	private static final int NO_MATCH = 0;

	private String source;

	public _3_01_1_StrShiftInclude(String source) {
		this.source = source;
	}

	/**
	 * 用空间来换时间,把s1 copy 一遍组成新串，看新串是否包含s2
	 * 
	 * @param pattern
	 * @return boolean 是否包含
	 */
	public int doMatch(String pattern) {
		// 字符串扩大一倍拼串，如果不包含pattern就说明不管怎么移位都不包含.
		String str = this.source + this.source;

		if (str.contains(pattern)) {
			return MATCH;
		} else {
			return NO_MATCH;
		}
	}

	public static void main(String[] args) {

		String s1 = "AABCD";
		String s2 = "CDAA";

		_3_01_1_StrShiftInclude include = new _3_01_1_StrShiftInclude(s1);

		if (include.doMatch(s2) == _3_01_1_StrShiftInclude.MATCH) {
			System.out.println("contain!");
		} else {
			System.out.println("not contain!");
		}
	}

}
