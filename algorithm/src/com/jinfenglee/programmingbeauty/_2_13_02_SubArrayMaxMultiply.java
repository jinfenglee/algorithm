package com.jinfenglee.programmingbeauty;

/**
 * 给定整型数组a,求最大连续子段的乘积.（最小连续子段乘积呢？一样的）
 * 
 * @author LJF
 * @date 2014-07-07 (卢沟桥事变，勿忘国耻)
 * 
 */
public class _2_13_02_SubArrayMaxMultiply {
	public static void main(String[] args) {
		int[] a = { -5, 3, 5, -6, -4 }; // 450
//		int[] a = { 2, 3, -6}; // 6
		int result = maxResult(a, a.length);
		System.out.println(result);  
	}

	/**
	 * 数组中连续元素乘积的最大值
	 * 
	 * @param a 数组
	 * @param n  数组长度
	 * @return result 最大乘积
	 */
	private static int maxResult(int[] a, int n) {
		int maxProduct = 1;
		int minProduct = 1;
		int result = 1;

		for (int i = 0; i < n; i++) {
			if (a[i] > 0) {
				maxProduct *= a[i];
				minProduct = Math.min(minProduct * a[i], 1);
			} else if (a[i] == 0) {
				maxProduct = 1;
				minProduct = 1;
			} else {
				// a[i] < 0
				int temp = maxProduct;
				maxProduct = Math.max(minProduct * a[i], 1);
				minProduct = temp * a[i];
			}

			// 每次执行之后都把 最大的值保存到result中，
			// 如果后面再碰到比result大的元素，就进行替换.
			result = Math.max(result, maxProduct);
			
//			result = Math.min(result, minProduct);  // 连续子段乘积的最小值.
		}
		return result;
	}
}
