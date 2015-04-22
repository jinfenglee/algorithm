package com.jinfenglee.programmingbeauty;

/**
 * 寻找最近点对（1）  先看一维情况，即如何找出N个数中两两只差的最小值.
 * 
 * @author LJF
 */
public class _2_11_MinPointPair_1 {
	public static void main(String[] args) {
		double[] arr = new double[] { 2.2, 4.1, 3.2, 5, 2, 1, 1.9, 1.5, 8, 4.05 };
		double result = minDifference(arr, arr.length);
		System.out.println(result);
	}
	
	/**
	 * 数组中两个数之差的最小值. (可以由一维扩展到二维.)   
	 * O(N^2),可以使用（快排、归并、堆排序）使复杂度提升为O(N*log2n)
	 * 
	 * @param arr
	 * @param n
	 * @return
	 */
	private static double minDifference(double[] arr, int n) {
		if (n <= 1) {
			return 0;
		}
		double fMinDiff = Math.abs(arr[0] - arr[1]);

		for (int i = 0; i < n; ++i) {
			for (int j = i + 1; j < n; j++) {
				double temp = Math.abs(arr[i] - arr[j]);
				if (fMinDiff > temp) {
					fMinDiff = temp;
				}
			}
		}
		return fMinDiff;
	}

}
