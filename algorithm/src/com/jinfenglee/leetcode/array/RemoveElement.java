package com.jinfenglee.leetcode.array;

/**
 * remove element and return the new length.
 * 
 * @author LJF
 * @date 2014-11-09 18:12:40
 * 
 */
public class RemoveElement {
	public static void main(String[] args) {
		int[] a = { 1, 2, 4, 6, 3, 4, 78, 34, 6 };
		System.out.println(removeElement(a, 4));

	}

	public static int removeElement(int[] A, int elem) {
		int resultLength = 0;
		for (int i = 0; i < A.length; i++) {
			if (elem != A[i]) {
				A[resultLength++] = A[i];
			}
		}

		return resultLength;
	}
}
