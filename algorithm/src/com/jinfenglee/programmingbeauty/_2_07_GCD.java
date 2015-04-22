package com.jinfenglee.programmingbeauty;

/**
 * 编程之美 2.7 求两个数的最大公约数 如果两个正整数都很大呢？
 * 
 * @author LJF
 * @Date 2014-05-08 
 * 
 */
public class _2_07_GCD {
	public static void main(String[] args) {
		int x = 69;
		int y = 23;
		System.out.println(gcd_1(x, y));
		System.out.println(gcd_2(x, y));
		System.out.println(gcd_3(x, y));
	}

	/**
	 * 应用辗转相除法 f(42,30)=f(30,12)=f(12,6)=f(6,0)=6.
	 * 当两个整数是大整数的时候，不合适，因为取模运算(用到除法)，是非常昂贵的开销.
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	private static int gcd_1(int x, int y) {

		if (x < y) {
			return gcd_1(y, x);
		}
		if (y == 0) {
			return x;
		} else {
			return gcd_1(y, x % y);
		}
	}

	/**
	 * 使用减法来代替除法，不需要再进行大整数取模运算.
	 * 
	 * 缺点：迭代次数较多。如：100000000000000000000，1
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	private static int gcd_2(int x, int y) {

		if (x < y) {
			return gcd_2(y, x);
		}
		if (y == 0) {
			return x;
		} else {
			return gcd_2(x - y, y);
		}
	}

	/**
	 * 利用了移位运算和减法运算，真的是非常好.
	 * 
	 * 若x,y 均偶：f(x,y)=f(x/2,y/2). 
	 * 若x奇数，y偶数，f(x,y)=f(x,y/2)
	 * 若x偶数，y奇数，f(x,y)=f(x/2,y);
	 * 若x,y 均奇：f(x,y)=f(x,x-y).
	 * 执行到x,y均为奇数之后，(x-y) 是一个偶数，一定有除2的操作.
	 * 最坏情况下的时间复杂度为:O(log 2(max(x,y))).
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	private static int gcd_3(int a, int b) {
		if (a < b) {
			return gcd_3(b, a);
		}
		if (b == 0) {
			return a;
		}
		// a>=b

		if (isEven(a)) {
			if (isEven(b)) {
				return (gcd_3(a >> 1, b >> 1) << 1);
			} else {
				return gcd_3(a >> 1, b);
			}
		} else {
			if (isEven(b)) {
				return gcd_3(a, b >> 1);
			} else {
				return gcd_3(a - b, b);
			}
		}
	}

	/**
	 * 判断是不是偶数(even)
	 * 
	 * 奇数(odd)
	 * 
	 * @param i
	 * @return
	 */
	private static boolean isEven(int i) {
		return (i & 1) != 1;
	}
}
