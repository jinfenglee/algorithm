package com.jinfenglee.basic;

import java.math.BigInteger;

/**
 * 非递归的形式实现FIB数列
 * 
 */
public class NoRecursionFib {
	public static void main(String[] args) {
		
		int k = 0;
		/*
		 * 就这样一个嵌套for循环，昨天晚上自己想了将近2个小时还没有完成，
		 * 我一直觉得是一件很简单的事情，怎么就不能够打印输出呢？ 以后一定要多加练习。 2013-12-03 08:59:39
		 */
		for (int i = 1; i <= 10; i++) {
			for (int j = 1; j <= i; j++) {
				k++;
				System.out.print(fib(k) + " ");
			}
			System.out.println();
		}
		//System.out.println();	
		//System.out.println(populateWithoutRecursion(600));
	}

	/**
	 * 非递归实现fib算法
	 * @param n 
	 * @return n的fib值
	 */
	
	private static int fib(int n) {
		if (1 == n || 2 == n) {
			return 1;
		}
		int num1 = 1;
		int num2 = 1;
		int temp = 0;

		// 注意：此时i是从2开始的，到n-1结束
		for (int i = 2; i < n; i++) {
			temp = num2;
			num2 += num1;
			num1 = temp;
		}
		return num2;
	}
	
	/**
	 * 使用BigInteger，可以防止出现当n大到一定程度的时候会出现上溢
	 * @param n
	 * @return
	 */
	public static BigInteger populateWithoutRecursion(int n) {
		if (1 == n || 2 == n) {
			return new BigInteger("1");
		}
		BigInteger num1 = new BigInteger("1");
		BigInteger num2 = new BigInteger("1");
		BigInteger temp = new BigInteger("0");
		for (int i = 2; i < n; i++) {
			temp = num2;
			num2 = num2.add(num1);
			num1 = temp;
		}
		return num2;
	} 
}
