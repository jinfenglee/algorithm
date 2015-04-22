package com.jinfenglee.sort;

import java.util.Arrays;

/**
 * TODO：直接插入排序
 * 
 * @author LJF (lijinfeng.ljf@gmail.com)
 * @date 2014-08-13 23:28:55
 */
public class InsertSort {
	public static void main(String[] args) {
		int arr[] = { 5, 3, 2, 4, 6, 7, 3 };
		System.out.println("排序前:" + Arrays.toString(arr));
		insertSort(arr);
		System.out.println("排序后:" + Arrays.toString(arr));
	}

	/**
	 * 插入排序 时间复杂度 :O(n^2),最好为O(n); 空间复杂度：O(1). 稳定
	 * 
	 * @param arr
	 */
	public static void insertSort(int[] arr) {
		// 第i个元素插入已经排好序的i-1个元素中
		for (int i = 1; i < arr.length; i++) {
			int temp = arr[i];
			int j = i - 1;

			while (j >= 0 && arr[j] > temp) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = temp;
		}
	}
}
