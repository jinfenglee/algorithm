package com.jinfenglee.programmingbeauty;

/**
 * 求数组的最长递增子序列
 * 
 * 给定一个长度为N的数组，找出一个最长的单调自增子序列（不一定连续），
 * 如序列  1,-1,2,-3,4,-5,6,-7的最长递增子序列长度为4（1,2,4,6）
 * 
 * @author LJF
 * @date 2014-07-15 08:17:30
 * 
 */
public class _2_16_1_maxIncSeq {
	public static void main(String[] args) {
//		int[] a = { 1, -1, 2, -3, 4, -5, 6, -7, 5, 8 };
		int []a = {1,-1, 2,-3, 4};
		int result = lis(a, a.length);
		System.out.println(result);
	}

	/**
	 * O(n^2)  空间复杂度O(n).
	 * 
	 * 用一个辅助数组用来记录对应元素结尾的最大递增自序列的长度(lis[i] 表示以a[i] 结尾的最大递增
	 * 子序列的长度)，对每一个元素，以其结尾的最大递增子序列的长度要么为1，要么为这个元素前面的元素中小于
	 * 该元素且最大递增自序列的长度最大的那个元素对应的最大递增自序列的长度 +1.
	 * @param a
	 * @param n
	 * @return 最大递增子序列的长度
	 */
	private static int lis(int[] a, int n) {
		int lis[] = new int[n];
		int i;
		int j;
		
		/**
		 * 1  -1  2  -3  4
		 * lis[i]起始：
		 * 1  1   1  1   1
		 * lis[i]for循环结束后值:
		 * 1  1  2   1   3
		 */
		for (i = 0; i < n; i++) {
			lis[i] = 1;
			
			for (j = 0; j < i; j++) {
				if (a[i] > a[j] && lis[j] + 1 > lis[i]) {
					lis[i] = lis[j] + 1;
				}
			}
		}
		
		int max = 0;
		for (i = 0; i < n; i++) {
			if (lis[i] > max) {
				max = lis[i];
			}
		}
		
		return max;
	}

}
