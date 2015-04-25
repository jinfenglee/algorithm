package com.jinfenglee.leetcode.array;

/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2). Find the minimum element.
 * 
 * @author LJF
 * @date 2014-10-31 23:51:37
 */
public class MinimumRotatedSortedArray {
	public static void main(String[] args) {
		int[] num = { 4, 5, 7, 15, 2, 3 };
		System.out.println(findMin(num));
	}

	/**
	 * just a binarySearch
	 * 
	 * @param num
	 * @return
	 */
	private static int findMin(int[] num) {

		int len = num.length - 1;
		int left = 0;
		int right = len;

		while (left <= right) {
			int mid = left + (right - left) / 2;

			if (num[mid] > num[len])
				left = mid + 1;
			else
				right = mid - 1;
		}
		return num[left];
	}
}
