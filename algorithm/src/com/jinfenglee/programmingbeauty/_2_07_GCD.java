package com.jinfenglee.programmingbeauty;

/**
 * ���֮�� 2.7 �������������Լ�� ����������������ܴ��أ�
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
	 * Ӧ��շת����� f(42,30)=f(30,12)=f(12,6)=f(6,0)=6.
	 * �����������Ǵ�������ʱ�򣬲����ʣ���Ϊȡģ����(�õ�����)���Ƿǳ�����Ŀ���.
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
	 * ʹ�ü������������������Ҫ�ٽ��д�����ȡģ����.
	 * 
	 * ȱ�㣺���������϶ࡣ�磺100000000000000000000��1
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
	 * ��������λ����ͼ������㣬����Ƿǳ���.
	 * 
	 * ��x,y ��ż��f(x,y)=f(x/2,y/2). 
	 * ��x������yż����f(x,y)=f(x,y/2)
	 * ��xż����y������f(x,y)=f(x/2,y);
	 * ��x,y ���棺f(x,y)=f(x,x-y).
	 * ִ�е�x,y��Ϊ����֮��(x-y) ��һ��ż����һ���г�2�Ĳ���.
	 * �����µ�ʱ�临�Ӷ�Ϊ:O(log 2(max(x,y))).
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
	 * �ж��ǲ���ż��(even)
	 * 
	 * ����(odd)
	 * 
	 * @param i
	 * @return
	 */
	private static boolean isEven(int i) {
		return (i & 1) != 1;
	}
}
