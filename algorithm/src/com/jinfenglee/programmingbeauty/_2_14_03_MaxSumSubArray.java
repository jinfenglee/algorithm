package com.jinfenglee.programmingbeauty;

/**
 * TODO:数组子数组之和的最大值（M3:动态规划法）O(N)
 *  数组：A[0], 最大一段数组(a[i]...a[j]),之间的关系的3种情况：
 * 1、0=i=j,a[0]本身构成数组的最大一段. 
 * 2、0=i<j,最大的一段以a[0]开始. 
 * 3、0<i, 最大的一段与a[0]没有关系.
 * 
 * @author LJF
 * @date 2014-07-12
 * 
 */
public class _2_14_03_MaxSumSubArray {
	public static void main(String[] args) {
		int[] array = { 3, -2, 3, 10, -4, 7, 2, -5 };
		// int arr[] = {4,-3,5,-2,-1,2,6,-2};
		System.out.println("Max sum: " + maxSum(array, array.length));
		System.out.println("Max sum: " + maxSum2(array, array.length));
	}
	/**
	 * 动态规划求子数组之和最大值
	 * @param arr
	 * @param n
	 * @return  子数组之和最大值.
	 */
	private static int maxSum(int[] arr, int n) {
		int i;
		int All[] = new int[n];
		int Start[] = new int[n];

		/**
		 * All[1] 表示(arr[1],arr[2],....arr[n-1])中最大的一段数组之和，可以不包含arr[1]
		 */
		All[n - 1] = arr[n - 1];  
		Start[n - 1] = arr[n - 1];  // 包含arr[n-1] 的最大的一段数组为Start[n-1];
		
		// 从数组末尾往前遍历，直到数组首.
		for (i = n - 2; i >= 0; i--) {
			Start[i] = max(arr[i], arr[i] + Start[i + 1]);
			All[i] = max(All[i + 1], Start[i]);
		}
		return All[0];
	}

	static int max(int x, int y) {
		return (x > y) ? x : y;

	}
	
	
	/**
	 * 可以继续优化，没有必要使用额外的两个数组 , \
	 * 因为start[k+1] 只有在计算 Start[k]时才有用.   
	 * All[k+1]只在计算All[k]时才有用.
	 * 
	 * 空间复杂度降为O(1)
	 * @param arr
	 * @param n
	 * @return
	 */
	private static int maxSum2(int[] arr, int n) {
		int i;

		int nAll = arr[n - 1];
		int nStart = arr[n - 1]; 
		
		for (i = n - 2; i >= 0; i--) {
			nStart = max(arr[i], arr[i] + nStart);
			nAll = max(nStart, nAll);
		}
		return nAll;
	}
	
}
