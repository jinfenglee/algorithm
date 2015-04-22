package com.jinfenglee.programmingbeauty;

/**
 * 编程之美3.3 ：计算字符串之间的相似度
 * 
 * 实际上就是在求编辑距离.
 * 
 * @author LJF
 * @Date 2014-02-11
 * 
 */
public class _3_03_StringSimiliarity {

	public static void main(String[] args) {
		String a = "abcd";
		String b = "ad";

		System.out.println("两个字符串的相似度为："
				+ 1.0
				/ (1 + calculateStringDistance(a, 0, (int) a.length() - 1, b,0, (int) b.length() - 1)));
	}

	/**
	 * 递归计算字符串之间的距离 但是在递归过程中，
	 * 有些数据被重复计算了. (画出递归的属性结构就可以看出) 可以改进！！！
	 * 
	 * @param strA
	 * @param pABegin
	 * @param pAEnd
	 * @param strB
	 * @param pBBegin
	 * @param pBEnd
	 * @return
	 */
	private static int calculateStringDistance(String strA, int pABegin,
			int pAEnd, String strB, int pBBegin, int pBEnd) {
		char[] c1 = strA.toCharArray();
		char[] c2 = strB.toCharArray();

		if (pABegin > pAEnd) {
			if (pBBegin > pBEnd) {
				return 0;
			} else {
				// 距离为B的长度
				return pBEnd - pBBegin + 1;
			}
		}

		if (pBBegin > pBEnd) {
			if (pABegin > pAEnd) {
				return 0;
			} else {
				return pAEnd - pABegin + 1;
			}
		}
		/**
		 * 两种写法都是可以的，下面的写法不需要再定义 char[],代码会更简洁一些.
		 */
		// if (c1[pABegin] ==c2[pBBegin]) {
		if (strA.charAt(pABegin) == strB.charAt(pBBegin)) {
			return calculateStringDistance(strA, pABegin + 1, pAEnd, strB,
					pBBegin + 1, pBEnd);
		} else {
			int t1 = calculateStringDistance(strA, pABegin + 1, pAEnd, strB,
					pBBegin + 2, pBEnd);
			int t2 = calculateStringDistance(strA, pABegin + 2, pAEnd, strB,
					pBBegin + 1, pBEnd);
			int t3 = calculateStringDistance(strA, pABegin + 2, pAEnd, strB,
					pBBegin + 2, pBEnd);

			return minValue(t1, t2, t3) + 1;
		}
	}

	// 求三个数中的最小数
	private static int minValue(int a, int b, int c) {
		if (a < b && a < c) {
			return a;
		} else if (b < a && b < c) {
			return b;
		} else {
			return c;
		}
	}

}
