package com.jinfenglee.sort;


/**
 * 递归实现快速排序
 * 
 * @author LJF
 * @date 2014-08-16 23:35:48
 * 
 */
public class QuickSort {
	public void quickSort(String strDate[], int left, int right) {
		String middle, temp;
		int i, j;
		i = left;
		j = right;
		/**
		 * 这样来获得middle,总感觉不恰当，不都是把第一个元素的值设定为枢轴量吗？？？
		 * 我想应该是像QuickSort_new中有一个getMiddle()方法。
		 */
		middle = strDate[(i + j) / 2];
		do {
			while (strDate[i].compareTo(middle) < 0 && i < right) {
				i++;
			}
			while (strDate[j].compareTo(middle) > 0 && j > left) {
				j--;
			}
			if (i <= j) {
				// 将左边大数与右边的小数进行交换
				temp = strDate[i];
				strDate[i] = strDate[j];
				strDate[j] = temp;

				i++;
				j--;
			}
		} while (i <= j); // 循环终止的条件

		if (i < right) {
			quickSort(strDate, i, right);
		}
		if (j > left) {
			quickSort(strDate, left, j);
		}
	}

	public static void main(String[] args) {
		String[] str = new String[] { "11", "66", "22", "0", "55", "22", "0", "32" };
		System.out.println("排序后的结果为：");
		QuickSort sort = new QuickSort();
		sort.quickSort(str, 0, str.length - 1);
		for (int i = 0; i < str.length; i++) {
			System.out.print(str[i] + " ");
		}
	}
}