package com.jinfenglee.basic;
/**
 * 
 * @author LJF
 * @version 1.0  2013-12-26 13:44:53
 * 查找1~n 之间的所有质数
 *
 */
public class FindPrime {
	public static void main(String[] args) {
		/*for(int i=2;i <= 20; i++) {
			if(isPrime(i)) {
				System.out.print(" "+i);
			}
		}*/
		
		// 思路：把所有的合数去掉后留下质数， 这个思路相对来说比较好一些...
		int n = 30;
		int[] array = new int[n];
		for (int i = 2; i < 30; i++) {
			array[i] = i;
		}

		for (int i = 2; i < n; i++) {
			if (array[i] != 0) {
				int j, temp;

				temp = array[i];
				for (j = 2 * temp; j < n; j += temp) {
					array[j] = 0;
				}
				System.out.print(" "+array[i]);
			}
		}
	}

	// method1 很常规的做法  效率很低 加上main中  复杂度 O(n^2)
/*	private static boolean isPrime(int num) {
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if(num % i ==0) {
				return false;
			}
		}
		return true;
	}*/
	
}
