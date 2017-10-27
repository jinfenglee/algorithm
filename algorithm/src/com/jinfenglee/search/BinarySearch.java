package com.jinfenglee.search;

import java.util.Arrays;

/**
 * BinarySearch
 * 
 * @author li.jf
 * @date 2017-10-17 21:34:02
 * 
 */
public class BinarySearch {

	/**
	 * 二分查找 复杂度 O(log(n))   特点：要求待查表必须是有序表，并且顺序存储
	 * 
	 * @param arr
	 * @param num 待查找的数
	 * @return
	 */
	private static int binarySearch(int[] arr, int num) {
		int low = 0;
		int high = arr.length - 1;

		while (low <= high) {
			// 网上有的写法是这样的：middle = low + ((high - low) >> 1), 效果实际一样的.
//			int mid = (low + high) / 2;
			int mid = low + ((high - low) >> 1);
			if (num > arr[mid]) {
				low = mid + 1;
			} else if (num < arr[mid]) {
				high = mid - 1;
			} else {
				return mid;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] arr = { 2, 5, 11, 3, 91, 13, 35, 4 };
		Arrays.sort(arr); // 二分查找要求数组有序，先排序
		
		for (int a : arr) {
			System.out.print(a + " ");
		}
		System.out.println();

		int num = 5;
		int result = binarySearch(arr, num);

		if (result != -1) {
			System.out.println("存在该数" + num + " ,索引下标为：" + result);
		} else {
			System.out.println("数组中不存在该数据");
		}
	}

}
