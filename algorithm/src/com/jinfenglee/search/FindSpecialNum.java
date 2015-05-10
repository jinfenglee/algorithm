package com.jinfenglee.search;

/**
 * 给定一个升序的数组A,让你在数组中找到任意下标x, 使得A[x]==x. example: [-1,1,2,3,10] x = 3;
 * tips: 注意是升序.
 * 
 * @author LJF
 */
public class FindSpecialNum {
	public static void main(String[] args) {
//		int[] arr = { -1, 1, 4, 5, 10 };
//		boolean flag = false;
//		for (int i = 0; i < arr.length; i++) {
//			if (i == arr[i]) { 
//				System.out.println(i);
//				flag = true;
//			}
//		}
//		
//		if (!flag) {
//			System.out.println("没有找到满足条件的数!");
//		}

		// 上面这种方式很容易想到，但是不是最好的（没有从数组升序中悟出什么东东~）. 如果B[0]>0,那么B[0...n]中不会出现特殊数字，
	 	// 同理：如果B[n]<n,  ********* 也不会出现特殊数字.
		
		int[] arr = { -1, 1, 2, 3, 6 };
		int result = specialNum(arr);
		if (result ==-1) {
			System.out.println("none");
		} else {
			System.out.println(result);
		}

	}
	
	/**
	 *  可以在O(1)时间内判断一个数字是否属于数组, 将问题转化为等价的子问题， 并且数据规模减少一半，
	 *  所以一定能在O(logN) 次内找到特定的数字， 时间复杂度O(logN), 空间复杂度 O(1)
	 *  
	 *  现在你懂了吧，就是一个二分查找
	 * @param arr
	 * @return
	 */
	private static int specialNum(int[] arr) {
		int left = 0;
		int right = arr.length - 1;
		int m;
		while (left <= right) {
			m = (left + right) / 2;
			if (arr[m] < m) {
				left = m + 1;
			} else if(arr[m] > m){
				right = m - 1;
			} else {
				// arr[m] == m
				return m;
			}
		}
		return -1;
	}

}
