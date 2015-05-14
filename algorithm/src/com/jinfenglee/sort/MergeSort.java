package com.jinfenglee.sort;

/**
 * 
 * @author LJF
 * @version 1.0, 2013-12-04 09:18:35 <br />
 * <br />
 *          归并排序 原理,把原始数组分成若干子数组,对每一个子数组进行排序,
 *          继续把子数组与子数组合并,合并后仍然有序,直到全部合并完,形成有序的数组.
 * 
 * 
 *          我们来分析一下归并排序的时间复杂度，一趟归并需要将SR[1]～SR[n]中相邻的长度为h的有序序列进行两两归并。
 *          并将结果放到TR1[1]～TR1[n]中，这需要将待排序序列中的所有记录扫描一遍，因此耗费O(n)时间，
 *          而由完全二叉树的深度可知，整个归并排序需要进行.log2n.次，因此，总的时间复杂度为O(nlogn)，
 *          而且这是归并排序算法中最好、最坏、平均的时间性能。
 *          由于归并排序在归并过程中需要与原始记录序列同样数量的存储空间存放归并结果以及递归时深度为log2n的栈空间，
 *          因此空间复杂度为O(n+logn)。 另外，对代码进行仔细研究，发现Merge函数中有if (SR[i]<SR[j])语句，
 *          这就说明它需要两两比较，不存在跳跃，因此归并排序是一种稳定的排序算法。 也就是说，归并排序是一种 比较占用内存，但却效率高且稳定的算法。
 *          时间复杂度O(nlogn) 空间复杂度 O(n+logn)，稳定算法。
 * 
 */
public class MergeSort {
	public static void main(String[] args) {
		int[] a = { 6, 2};
		int[] sorted = new int[a.length];
		int len = sorted.length;
		
		merge_sort(a, 0, a.length, sorted);
		
		// 在for循环中尽量地不要使用a.length, 这是减少重复计算数组的长度
		for (int i = 0; i < len; i++) {
			if (sorted[i] > 0) {
				System.out.print(sorted[i]+" ");
			}
		}
		System.out.println();

	}

	static void merge(int[] unsorted, int first, int mid, int last, int[] sorted) {
		int i = first;
		int j = mid;
		int k = 0;
		while (i < mid && j < last) {
			if (unsorted[i] < unsorted[j]) {
				sorted[k++] = unsorted[i++];
			} else {
				sorted[k++] = unsorted[j++];
			}
		}

		while (i < mid) {
			sorted[k++] = unsorted[i++];
		}
		while (j < last) {
			sorted[k++] = unsorted[j++];
		}
		for (int v = 0; v < k; v++) {
			unsorted[first + v] = sorted[v];
		}	
	}

	// 注意此时的first的初始值是0, last开始值为数组的长度
	/**
	 * 先分组，再合并。
	 * @param unsorted
	 * @param first
	 * @param last
	 * @param sorted
	 */
	static void merge_sort(int[] unsorted, int first, int last, int[] sorted) {
		if (first + 1 < last) {
			int mid = (first + last) / 2;
			
			merge_sort(unsorted, first, mid, sorted);
			merge_sort(unsorted, mid, last, sorted);
			merge(unsorted, first, mid, last, sorted);
		} else {
			
		}
	}
}
