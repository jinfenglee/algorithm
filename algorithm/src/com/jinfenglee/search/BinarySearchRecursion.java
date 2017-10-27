package com.jinfenglee.search;

import java.util.Arrays;

/**
 * BinarySearch Recursion Implement
 * 
 * @author kingfeng
 * 
 */
public class BinarySearchRecursion {

	public static void main(String[] args) {
		int[] arr = { 2, 5, 11, 3, 91, 13, 5, 35, 4 };
		Arrays.sort(arr); // 二分查找要求数组有序，先排序
		for (int a : arr) {
			System.out.print(a + " ");
		}
		System.out.println();

		int num = 5;
		int result = binSearch(arr, 0, arr.length - 1, num);

		if (result != -1) {
			System.out.println("存在该数" + num + " ,索引下标为：" + result);
		} else {
			System.out.println("数组中不存在该数据");
		}
	}

	/**
	 * 递归实现二分查找
	 * 
	 * @param srcArray
	 * @param start
	 * @param end
	 * @param key
	 * @return
	 */
	public static int binSearch(int srcArray[], int start, int end, int key) {
		// 这两种取mid的方式都是可以的，这样写是为了避免可能的溢出；
		// int mid = (end - start) / 2 + start;
		int mid = start + ((end - start) >> 1);

		if (srcArray[mid] == key) {
			return mid;
		}
		if (start >= end) {
			return -1;
		} else if (key > srcArray[mid]) {
			return binSearch(srcArray, mid + 1, end, key);
		} else if (key < srcArray[mid]) {
			return binSearch(srcArray, start, mid - 1, key);
		}
		return -1;
	}
}
