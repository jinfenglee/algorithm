package com.jinfenglee.sort;


/**
 * BubbleSort(两种方法实现)
 * 
 * @author LJF
 * @Date 2014-06-03 22:09:25
 * @review 2015-02-28 23:51:08
 * 
 */
public class BubbleSort {
	public static void main(String[] args) {
		int a[] = { 12, 66, -1, 55, 7679, 4534, 6786, 345 };
		// int a[] = { 5, 4, 6, 3, 1 };
		
		bubblesort(a);
		System.out.println();
		bubblesort2(a);
	}

	/**
	 *  M1：常规方法 ,平均 O(n^2)
	 * @param a
	 */
	private static void bubblesort(int[] a) {
		// TODO Auto-generated method stub
		for (int i = 0; i < a.length; i++) {
			for (int j = i; j < a.length; j++) {
				if (a[i] > a[j]) {
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
			// 每一次a[i]是剩余元素最小的.
			System.out.print(a[i] + " ");
		}
	}

	/**
	 * M2:设置一个标记为，如果某一趟发生交换，则为true，否则为false
	 * 
	 * @param a
	 */
	private static void bubblesort2(int[] a) {
		int i;
		int j = a.length;
		boolean flag = true;
		
		while (flag) {
			flag = false;
			for (i = 1; i < j; i++) {
				if (a[i - 1] > a[i]) {
					int temp = a[i - 1];
					a[i - 1] = a[i];
					a[i] = temp;
					flag = true;
				}
			}

//			j--;
		}
		
		for (int k = 0; k < a.length; k++) {
			System.out.print(a[k] + " ");
		}
	}
}
