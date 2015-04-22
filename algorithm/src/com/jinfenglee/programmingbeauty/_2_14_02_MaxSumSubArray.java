package com.jinfenglee.programmingbeauty;

/**
 * TODO：连续子数组的最大和（减治法）
 * 
 * @author LJF
 * @date: 2014-07-12 06:00:20
 * 
 */
public class _2_14_02_MaxSumSubArray {
	public static void main(String[] args) {
		int[] array = { 1, -2, 3, 10, -4, 7, 2, -5 };
		// int arr[] = {4,-3,5,-2,-1,2,6,-2};
		System.out.println("Max sum: " + getMax(array));
	}

	/*
	 * M2： 减治法
	 * 目标：将问题规模不断减小，直到可以简单处理为止。
	 * 假设我们已知一个数组的最大子数组和，现在在该数组后面增加一个数字，
	 * 新数组的最大子数组和可能是什么结果呢？
	 * 原数组的最大子数组和；
	 * 新增加的数字为正数，和最右侧的子数组形成了一个新的最大子数组和（所以为了通过一次遍历完成，
	 * 我们需要保存最右侧的子数组的最大和）。
	 * 然后将两个数字进行比较即可。
	 * 所以减治至数组只包含最左侧一个数字，我们知道它的最大子数组和和最右侧子数组最大和都为还数字，
	 * 逐次加1个数字直到整个数组即可。
	 */

	/**
	 * 获得连续子数组的最大和
	 * 
	 * @param array
	 * @return 最大和，此处用了Long型是为了表示当参数为null或空时， 可以返回null，
	 *         <p>
	 *         返回其它任何数字都可能引起歧义。
	 */
	public static Long getMax(int[] array) {
		if (array == null || array.length <= 0) {
			return null;
		}

		long maxSum = array[0];
	
		long rightEdge = array[0];	// 右侧子数组的最大和
		/*
		 * 由于rightEdge初始值为数组的第一个元素值，所以for循环中 i的下标是从1开始.
		 */
		for (int i = 1; i < array.length; i++) {
			// 当右侧子数组的最大和为负数时，对于新数组，右侧子数组的最大和为新增加的数。
			if (rightEdge < 0) {
				rightEdge = array[i];
			} else {
				// 为正数时，对于新数组，右侧子数组的最大和为新增加的数 + 原来的最大和。
				rightEdge += array[i];
			}
			
			System.out.println("righteEdge--maxSum:" + rightEdge + "---" + maxSum);

			maxSum = max(rightEdge, maxSum);
		}
		return maxSum;
	}

	private static long max(long a, long b) {
		return a > b ? a : b;
	}

}
