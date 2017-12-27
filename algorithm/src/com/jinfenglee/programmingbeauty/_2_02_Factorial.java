package com.jinfenglee.programmingbeauty;


/**
 * Q1、给定一个整数N，求N!末尾有多少个0? 
 * （能被2整除的数出现的频率比能被5整除的数高得多.）
 * 
 * Q2、求N!的二进制表示中最低位1的位置；(从后往前数，出现的1，位置序号从0开始.)
 * 
 * @author li.jf
 * 
 */
public class _2_02_Factorial {
	public static void main(String[] args) {
		int n = 4;
		System.out.println(bottomZeroNum(100));   // 100!  最后0的个数为  24     5*5，5*5*2, 5*5*3， 5*5*4  
		System.out.println(bottomZeroNum2(10));
		System.out.println("---------------");
		System.out.println("720的二进制表示为：" + Integer.toBinaryString(720));
		System.out.println(lowestOne(6));
		System.out.println(totalNumZero(7));
//		System.out.println(t);
		System.out.println(Integer.toBinaryString(5040));
	}
	
	private static int bottomZeroNum(int n) {
		int ret = 0;

		for (int i = 1; i <= n; i++) {
			int j = i;
			while (j % 5 == 0) {
				ret++;
				j /= 5;
			}
		}
		return ret;
	}
	
	/**
	 * 不大于n的数中5的倍数贡献一个5.
	 * 
	 * @param n
	 * @return
	 */
	private static int bottomZeroNum2(int n) {
		int ret = 0;

		while (n != 0) {
			ret += n / 5;
			n /= 5;
		}
		return ret;
	}

	/**
	 * 问题2
	 * 判断最后一个二进制位是否为0，若为0，右移一位，即为商值；
	 * 反之，若为1，则说明这个二进制数是奇数，无法被2整除;
	 * 问题等同于N! 中含有质因数2的个数 == N/2+N/4+...（N/K 等于1，2，3，---N中能为K整除的数的个数.）
	 * 以6!= 1011010000 为例子， 最后一位1的位置为5.
	 * 
	 * @param n
	 * @return
	 */
	private static int lowestOne(int n) {
		int ret = 0;

		while (n != 0) {
			n >>= 1;   // n /= 2; 等价于 n>>=1;
			ret += n;
			// System.out.println(n+""); //3, 1
		}
		return ret + 1;
	}
	
	/**
	 * 求一个数的阶乘二进制表示中0的个数.
	 * @param n
	 * @return
	 */
	private static int totalNumZero(int n) {
		int temp = 1;
		int num = 0;

		for (int i = 1; i <= n; i++) {
			temp *= i;
		}
		
		System.out.println("--- " + temp);
		
//		while (temp != 0) {
//			num += temp & 0x01;
//			temp >>= 1;
//		}
		
		while (temp != 0) {
			if (0 == temp % 2) {
				num++;
			}
			temp /= 2;
		}
		return num;
	}

}
