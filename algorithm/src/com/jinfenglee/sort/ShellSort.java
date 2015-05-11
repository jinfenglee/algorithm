package com.jinfenglee.sort;

/**
 * shellsort是在插入排序基础上的优化，主要是减少比较次数
 * 
 * @author LJF
 * 
 * @description: 不稳定的排序算法，是基于插入排序的两点性质提出改进方法的.
 *               <p> 插入排序在对几乎已经排好序的数据操作时， 效率高， 即可以达到线性排序的效率
 *               <p>但插入排序一般来说是低效的， 因为插入排序每次只能将数据移动一位.
 * 
 *               最差时间复杂度 根据步长串行的不同而不同。 已知最好的: O(n\log^2 n) 
 *               <p>最优时间复杂度 O(n) 
 *               <p> 平均时间复杂度 根据步长串行的不同而不同， 最差空间复杂度 O(n)
 * @Date 2013-11-29 11:30:46
 */
public class ShellSort {
	public static void main(String[] args) {
		int[] a = { 12, 4, 23, 7, 8, 34, 2357, 435, 9, 0, 265}; 
//		int[] a = { 8, 9, 1, 7, 6 };
		int length = a.length;

		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();

		shellSort(a, length);

		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}

	/**
	 * 希尔排序
	 * @param a
	 * @param n 待排序数组的长度
	 */
	private static void shellSort(int[] a, int n) {
		int i, j;
		int gap; // 步长

		for (gap = n; gap > 0; gap /= 2) {
			System.out.println("----------" + gap);
			for (i = gap; i < n; i++) {
				// 使用8,9,1,7,6 走一遍就可以了.
				for (j = i - gap; j >= 0 && a[j] > a[j + gap]; j--) {
					int temp;
					temp = a[j];
					a[j] = a[j + gap];
					a[j + gap] = temp;
				}
			}
		}
	}
}
