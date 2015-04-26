package com.jinfenglee.leetcode.array;

/**
 * 求连续子数组的最大乘积.
 * 
 * @author LJF
 * @date 2014-11-13 21:23:15
 * 
 */
public class MaxMultiProductSubarray {
	public static void main(String[] args) {
		int[] a = { 3, 2, -2, 4, 2 };
		System.out.println(maxProduct(a));
	}

	public static int maxProduct(int[] A) {
		if (A == null || A.length == 0) {
			return 0;
		}

		int maxProduct = A[0];
		int maxTemp = A[0];
		int minTemp = A[0];

		for (int i = 1; i < A.length; i++) {
			int a = A[i] * maxTemp;
			int b = A[i] * minTemp;
			maxTemp = Math.max(Math.max(a, b), A[i]);
			minTemp = Math.min(Math.min(a, b), A[i]);
			maxProduct = Math.max(maxProduct, maxTemp);
		}
		return maxProduct;
	}

}
