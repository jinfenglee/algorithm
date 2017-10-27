package com.jinfenglee.sort;

import java.util.Arrays;

/**
 * TODO：选择排序
 * <p>
 * 时间复杂度：O(n^2), 空间复杂度：O(1), 不稳定.
 * 
 * @author LJF (lijinfeng.ljf@gmail.com)
 * @date 2014-08-12 23:23:23
 */
public class SelectSort {
	public static void main(String[] args) {
		int arr[] = { 5, 2, 9, 6, 1, 3, 6 };
		System.out.println("排序前:" + Arrays.toString(arr));
		selectSort(arr);
		System.out.println("排序后:" + Arrays.toString(arr));
	}

	/**
	 * 选择排序
	 * 从数组中挑选最大的数放到最后，而遇到数值相等的值不进行处理（因而不稳定）。所以，
	 * 如果数值重复的比较多，建议用选择排序，这样交换的次数比较少，相对的速度将得到提升。
	 * 
	 * @param arr
	 *            待排序array
	 */
	private static void selectSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			int smallest = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[smallest]) {
					smallest = j;
				}
			}
			
			if(smallest != i) {   // 省得进行相同的元素再交换
				swap(arr, i, smallest);
			}
		}
	}

	/**
	 * 交换数组中两个元素的值
	 * @param arr
	 * @param i
	 * @param j
	 */
	private static void swap(int[] arr, int i, int j) {
		arr[i] = arr[i] + arr[j];
		arr[j] = arr[i] - arr[j];
		arr[i] = arr[i] - arr[j];
	}

}
