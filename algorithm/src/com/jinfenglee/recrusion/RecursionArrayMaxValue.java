package com.jinfenglee.recrusion;

/**
 * 
 * @author LJF
 * @version 1.0, 2013-12-02 10:50:15
 * <br />
 * <br />
 * 使用递归找出数组中的最大元素
 *
 */
public class RecursionArrayMaxValue {
	public static void main(String[] args) {
		int []arr={12,465,85,34,213,89,34687,8909,34,23,9099,34688,34};
		
		int maxValue=max(arr,0,arr.length-1);
		
		System.out.println("数组中元素的最大值为："+maxValue);
		 
	}
	/**
	 * 使用递归算法求数组中的最大值
	 * @param arr
	 * @param low   数组的下标
	 * @param heigh 数组的上标
	 * @return
	 */
	private static int max(int []arr,int low,int heigh) {
		int max;
		
		// 数组中只有一个或者两个元素时
		if (low >= heigh-1) {
			if (arr[low] > arr[heigh]) {
				max = arr[low];
			} else {
				max = arr[heigh];
			}
		}else {
			int mid = (low + heigh) / 2;
			int max1 = max(arr, low, mid);
			int max2 = max(arr, mid + 1, heigh);
			max = max1 > max2 ? max1 : max2;
		}	
		return max;
	}
}
