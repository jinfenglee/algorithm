package com.jinfenglee.programmingbeauty;

/**
 * 连续子数组之和的最大值
 * 
 * @author LJF
 * @date 2014-07-09
 * 
 */
public class _2_14_01_MaxSumSubArray {
	public static void main(String[] args) {
		int a[] = { 1, -2, 3, 5, -3, 2 };
		System.out.println(maxSum(a, a.length));
	}

	/**
	 * M1:时间复杂度为O(n^2)， 简单，但时间复杂度较大.
	 * 
	 * @param a
	 * @param n
	 *            数组的长度
	 * 
	 * @return 数组的最大和
	 */
	private static int maxSum(int[] a, int n) {
		int maxArraySum = Integer.MIN_VALUE;
		int sum;

		for (int i = 0; i < n; i++) {
			sum = 0;
			for (int j = i; j < n; j++) {
				sum += a[j];
				if (sum > maxArraySum)
					maxArraySum = sum;
			}
		}

		return maxArraySum;
	}
}
