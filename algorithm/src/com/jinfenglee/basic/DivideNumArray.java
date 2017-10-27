package com.jinfenglee.basic;
/**
 * 百度面试题，假设一整型数组存在若干正数和负数， 现在通过某种算法使得该数组的所有负数在正数的左边，
 * 且保证负数和正数间元素相对位置不变。时间和空间复杂度要求分别为：o(n),o(1)
 * 关键点就在于： 元素相对位置保持不变.
 * 
 * @author LJF
 * @date 2015-05-03 20:39:25
 * 
 * M1:使用链表，改变元素位置只需要修改指针就可以了;  改变存储结构
 * M2: 把数组中的第一个负数插入到第一个正数的前面，把第一个正数和第一个负数之间的元素
 * 向后移动一个位置. 只需要遍历一遍就可以了.
 * 
 */
public class DivideNumArray {
	
	/**
	 * 重排数组，分开正负数，并使元素相对位置保持不变.  （同理，分开奇偶数，相对位置不变，也是同样类型）
	 * @param a
	 * @param size
	 */
	private static void reSortArray(int[] a, int size) {
		// 数组中正负数的下标
		int nagitive = -1, positive = -1;
		int temp = 0;
		for (int i = 0; i < size; i++) {
			if (nagitive == -1) {
//				if (a[i] < 0 && positive >= 0) {
//					nagitive = i; // 用来寻找第一个负数
//				}
//				if (a[i] > 0 && positive < 0) {
//					positive = i; // 用来寻找第一个正数
//				}
				
				if (a[i]%2 != 0 && positive >= 0) {
					nagitive = i; // 用来寻找第一个奇数
				}
				if (a[i] % 2 == 0 && positive < 0) {
					positive = i; // 用来寻找第一个偶数
				}
			}
			
			// 都找到之后进行交换
			if (nagitive >= 0 && positive >= 0) {
				temp = a[positive];
				a[positive++] = a[nagitive];
				for (int k = nagitive; k > positive; k--) {
					a[k] = a[k - 1];
				}
				a[positive] = temp;
				nagitive = -1;
			}
		}
	}
	
	public static void main(String[] args) {
		int a[] = { 2, 3, -2, 4, 5, -3, -1, -5 };
		System.out.println("----- before sort:------");
		int len = a.length;
		int i;
		for (i = 0; i < len; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println("\n----- after sort:------");

		reSortArray(a, len);

		for (i = 0; i < len; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

}
