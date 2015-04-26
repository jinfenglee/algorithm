package com.jinfenglee.programmingbeauty;

/**
 * 编程之美 2.17：数组循环移位
 * <p>
 * 右移和左移实际上是类似的，右移k位等价于左移 n - k位(n是数组的长度).
 * 
 * @author Administrator
 * @version v1.0
 * @Date 2014-04-21 19:31:27
 * 
 */
public class _2_17_RotateArray {
	public static void main(String[] args) {
		char a[] = { 'a', 'b', 'c', 'd', '1', '2', '3', '4' };
		System.out.println(rightShift(a, a.length, 5));
		
//		System.out.println(rightShift(a, a.length, a.length - 5));
		System.out.println(rightShift1(a, a.length, 5));
	}
	
	/**
	 * 算法复杂度为O(n^2),与K无关. 因为 k%=n.
	 * 这个方法比较容易想到，但是复杂度太高.
	 * 
	 * @param arr
	 * @param n
	 * @param k
	 * @return
	 */
	private static char[] rightShift1(char[] arr, int n, int k) {
		
		k %= n;
		while (k != 0) {			
			char temp = arr[n - 1];
			
			for (int i = n - 1; i > 0; i--) {
				arr[i] = arr[i - 1];
			}
			
			arr[0] = temp;
			k--;
		}
		return arr;
	}
	
	/**
	 * 交换数组中的两个元素
	 * 
	 * @param arr
	 * @param b
	 * @param e
	 */
	private static void reverse(char[] arr, int b, int e) {
		for (; b < e; b++, e--) {
			char temp = arr[e];
			arr[e] = arr[b];
			arr[b] = temp;
		}
	}

	/**
	 * M2: 使用递归实现
	 * 
	 * 根据 k=5 进行模拟.
	 * 
	 * 1.   逆序排列abc：abcd1234 → cbad1234；
	 * 2.   逆序排列d1234：dcba1234 → cba4321d；
	 * 3.   全部逆序：d1234abc
	 * 
	 * 可以在线性的时间里实现右移操作.
	 * 
	 * @param arr
	 * @param n
	 * @param k
	 *            移动的位数
	 * @return
	 */
	private static char[] rightShift(char[] arr, int n, int k) {
		// 防止移动的位数大于数组的长度而出现错误.
		k %= n;
		
		reverse(arr, 0, n - k - 1);
		reverse(arr, n - k, n - 1);
		reverse(arr, 0, n - 1);
		
		return arr;
	}

}
