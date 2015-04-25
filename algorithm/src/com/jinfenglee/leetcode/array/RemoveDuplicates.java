package com.jinfenglee.leetcode.array;

/**
 * Given a sorted array, remove the duplicates in place such that each element
 * appear only once and return the new length. <br>
 * Do not allocate extra space for another array,<br>
 * you must do this in place with constant memory.
 * �Ƴ���������������ظ���Ԫ�أ�ʹ��ֻ����һ��.
 * 
 * @author LJF
 * @date 2014-11-09 18:15:17
 * @review 2015-03-03 08:13:27
 * 
 */
public class RemoveDuplicates {
	public static void main(String[] args) {
		// giving sorted array
		int[] a = { 1, 1, 2, 2, 2, 3, 3, 4, 6 };
		System.out.println(removeDuplicates(a));
	}

	private static int removeDuplicates(int[] A) {
		int len = A.length;
		int i = 0;
		int j = 1;

		if (len == 0 || len == 1)
			return len;

		while (j < len) {
			if (A[i] == A[j]) {
				j++;
			} else {
				A[++i] = A[j++];
			}
		}
		
		return i + 1;
	}

}
