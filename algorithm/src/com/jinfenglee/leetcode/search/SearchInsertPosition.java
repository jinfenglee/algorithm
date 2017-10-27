package com.jinfenglee.leetcode.search;

/**
 * 
 * search insert position.
 *  For example: 
 *  {1,3,5,6} 5-->2 
 *  {1,3,5,6} 2-->1
 *  {1,3,5,6} 7-->4
 * 
 * @author LJF
 * @date 2014-11-03 22:52:41
 */
public class SearchInsertPosition {
	public static void main(String[] args) {
		int[] a = { 1, 3, 5, 6 };
		System.out.println(searchInsert(a, 2));
	}
	
	/**
	 * Binary Search
	 * @param a
	 * @param length  the length of array
	 * @param target 
	 * @return
	 */
	private static int searchInsert(int A[], int target) {
		if (null == A || A.length ==0) {
			return 0;
		}

		int left = 0; 
		int right = A.length - 1;
		int mid = 0;
		
		while (left <= right) {
			mid = left + (right - left) / 2;
			if (target == A[mid])
				return mid;
			else if (target < A[mid])
				right = mid - 1;
			else
				left = mid + 1;
		}
		return left;
	}
	
	// 在结束的时候，如果没有找到Target，那么left指向小于target的最大的数，right指向大于target的最小的数。

}
