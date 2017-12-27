package com.jinfenglee.sort;

/**
 * QuickSort 算法不稳定
 * <p>思想：</p>
 *  通过一趟排序将待排记录分割成独立的两部分，
 *               其中一部分记录的关键字都比另一部分记录的关键字小，则分别对这两部分继续进行排序， 以达到整个序列有序。
 *               对照严蔚敏 数据结构,快排示例自己再模拟一下算法过程。
 * @author LJF
 * 
 * @date 2017-10-10 19:01:31
 * 
 */
public class QuickSortRecursion {
	
	/**
	 * 获取中轴的位置
	 * 
	 * @param arr
	 * @param low
	 * @param high
	 * @return 中轴的位置
	 */
	public int getMiddle(int[] arr, int low, int high) {
		int temp = arr[low]; // 把首元素作为枢轴(支点) pivot
		while (low < high) {
			while (low < high && arr[high] >= temp) {
				high--;
			}
			arr[low] = arr[high];

			while (low < high && arr[low] <= temp) {
				low++;
			}
			arr[high] = arr[low];
		}
		arr[low] = temp; // 中轴记录到尾
		return low; // 返回中轴的位置
	}

	/**
	 * 递归形式的分治排序
	 * 
	 * @param arr
	 * @param low
	 * @param high
	 */
	public void quickSort(int[] arr, int low, int high) {
		if (low < high) {
			int middle = getMiddle(arr, low, high);
//			System.out.println(middle);
			quickSort(arr, low, middle - 1);
			quickSort(arr, middle + 1, high);
		}
	}

	public void quick(int[] str) {
		if (str.length > 0) {
			quickSort(str, 0, str.length - 1);
		}
	}

	public static void main(String[] args) {
		int list[] = { 34, 3, 53, 14, 23, 14, 10 };
		
		System.out.print("before sort:  ");
		for (int i = 0; i < list.length; i++) {
			System.out.print(list[i] + " ");
		}
		System.out.println();
		
		QuickSortRecursion qs = new QuickSortRecursion();
		qs.quick(list);

		System.out.print("after sort:  ");
		for (int i = 0; i < list.length; i++) {
			System.out.print(list[i] + " ");
		}
		
		System.out.println();
	}
}
