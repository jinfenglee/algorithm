package com.jinfenglee.programmingbeauty;

import java.util.Arrays;

/**
 * 能否快速找到一个数组中的两个数字，两数之和等于一个给定的数字。
 * <p>
 * 假设这个数组中肯定存在这样一组或者以上符合要求的解.
 * 
 * @author LJF
 * @date 2014-07-02 07:27:38
 * 
 */
public class _2_12_Find2NumSum {

	public static void main(String[] args) {
		int a[] = { 5, 56, 23, 1, 45, 67 };
		int sum = 68;
		find(a, sum);
		System.out.println("-------M2:---------");
		find2(a, sum);
		
		System.out.println(search(a, a.length, 67));  // 找到的是与67 相加为sum的数的元素下标，从1开始.
		System.out.println(search2(a, a.length, 67));

	}

	/**
	 * M1: n(n-1)/2 次，时间复杂度为O(n^2).
	 * 
	 * @param a
	 * @param sum
	 *            给定的两数的和
	 */
	private static void find(int[] a, int sum) {
		for (int j = 0; j < a.length; j++) {
			for (int k = j + 1; k < a.length; k++) {
				if (a[j] + a[k] == sum) {
					System.out.println(a[j] + "----" + a[k]);
				}
			}
		}
	}

	/**
	 * 如果有序，直接用两个指针两端进行扫描.时间复杂度 O(n)
	 * <p>
	 * 如果无序，先进行排序后再两端扫描，时间复杂度O(N*logN)+O(N)=O(N*logN)
	 * <p>
	 * 空间复杂度始终为O(1).
	 * 
	 * @param a
	 * @param sum
	 */
	private static void find2(int[] a, int sum) {
		Arrays.sort(a);

		for (int i = 0, j = a.length - 1; i < j;) {
			if (a[i] + a[j] == sum) {
				System.out.println(a[i] + "--" + a[j]);
				i++;
			} else if (a[i] + a[j] < sum) {
				i++;
			} else {
				j--;
			}
		}
	}
	
	/*
	 * M3:
	 * 要想达到时间O(n),空间O(1)的目标，只有原数组是有序才能够做到；否则，数组若是无序的话，就只能先排序，
	 * 然后进行二分查找 时间复杂度为O(N*logN), 或者使用映射或者Hash，
	 * （时间和空间都是O(n)），使用了空间换时间。
	 * 给定一个数字，更具哈希映射查找另一个数字是否也在数组中，只需要O(1)的时间.
	 */

	////////////////////二分查找的实现//////////////////////
	static int search(int array[], int n, int v) {
		int left, right, middle;
		left = 0;
		right = n;
		
		while (left < right) {
			middle = left + (right - left) / 2;

			if (array[middle] > v) {
				right = middle;
			} else if (array[middle] < v) {
				left = middle + 1;
			} else {
				return middle;
			}
		}
		return -1;
	}
	
	// 这个是利用的数组下标.
	static int search2(int array[], int n, int v) {
		int left, right, middle;

		left = 0;
		right = n - 1;

		while (left <= right) {
			middle = left + (right - left) / 2;
			
			if (array[middle] > v) {
				right = middle - 1;
			} else if (array[middle] < v) {
				left = middle + 1;
			} else {
				return middle;
			}
		}
		return -1;
	}

}
