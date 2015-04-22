package com.jinfenglee.programmingbeauty;

import java.util.Arrays;

/**
 * 编程之美 2.10 找出一个数组中的最大最小的数.
 * 
 * 说明：M3方法并不好，有值得优化的地方.
 * 
 * @author Administrator
 * @date 2014-06-10 20:40:22
 * 
 */
public class _2_10_FindMaxMinNum_1 {

	static int[] a = { 12, 5, 9, 8, 2, 14, 15, 8, 7 };
//	static int[] a = { 3, 9, 6, 1};
	static int length = a.length;

	public static void main(String[] args) {
		System.out.println(Arrays.toString(a));

//		findMinMaxNum_1(a);
//		findMinMaxNum_2(a);
		findMinMaxNum_3(a);
//		findMinMaxNum_4(a);
	}

	/**
	 * 最不动脑筋的一种做法.比较了n*n次.
	 * 
	 * @param arr
	 */
	private static void findMinMaxNum_1(int[] arr) {
		Arrays.sort(a);
		System.out.println(arr[0] + "--" + arr[length - 1]);
	}

	/**
	 * 比较了2n次.
	 * 
	 * @param arr
	 */
	private static void findMinMaxNum_2(int[] arr) {
		int maximum = arr[0];// 最大值
		int minimum = arr[0];// 最小值

		for (int i = 0; i <= length - 1; i++) {
			if (minimum > arr[i]) {
				minimum = arr[i];
			}
			if (maximum < arr[i]) {
				maximum = arr[i];
			}
		}
		System.out.println("解法2---最小值:" + minimum + ",最大值:" + maximum);
	}

	/**
	 * 数组相邻的两位分为一组，比较大小，小的在下标为偶数的位置，大的在下标为奇数的位置。
	 * 
	 * @param arr
	 */
	private static void findMinMaxNum_3(int[] arr) {
		int temp;

		for (int i = 0; i < arr.length - 1; i += 2) {
			if (arr[i] > arr[i + 1]) {
				temp = arr[i];
				arr[i] = arr[i + 1];
				arr[i + 1] = temp;
			}
		}
		System.out.println(Arrays.toString(arr));
		
		// 类似于方法二找最小值、最大值
		for (int i = 0; i < arr.length; i += 2) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		for (int i = 1; i < arr.length - 1; i += 2) {
			System.out.print(arr[i] + " ");
		}
		
		
		// 这样是错误的，不能保证第一位是最小的
//		for (int i = 0; i < arr.length - 2; i+=2) {
//			if (a[i] > a[i + 2]) {
//				temp = arr[i];
//				arr[i] = arr[i + 2];
//				arr[i + 2] = temp;
//			}
//		}
		

		System.out.println(Arrays.toString(arr));

		System.out.println("解法3---min:" + arr[0] + ",max:"+ arr[arr.length - 1]);
	}

	private static void findMinMaxNum_4(int[] arr) {
		int maximum = arr[0];
		int minimum = arr[0];

		for (int i = 0; i < arr.length - 1; i++) {
			// 比较相邻两个数大小
			if (arr[i] > arr[i + 1]) {
				// 比较大数
				if (arr[i] > maximum) {
					maximum = arr[i];
				} else if (minimum > arr[i + 1]) {
					// 注意这一点的判定条件，开始时都忘记了.
					minimum = arr[i + 1];
				}
				
			} else {
				// 比较小数
				if (arr[i] < minimum) {
					minimum = arr[i];
				}
			}
		}
		System.out.println("解法4---最小值:" + minimum + ",最大值:" + maximum);
	}

}
