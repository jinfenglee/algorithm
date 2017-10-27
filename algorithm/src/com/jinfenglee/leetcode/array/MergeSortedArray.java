package com.jinfenglee.leetcode.array;

/**
 * 合并两个有序数组，并排序新数组
 * 
 * @author LJF
 * @date 2014-11-22 22:58:23
 * 
 */
public class MergeSortedArray {
	public static void main(String[] args) {
		int[] a = {11};
		int[] b = {13};
		merge(a, a.length, b, b.length);
	}
	/**
	 * merge two sorted array  result elements put in Array A.
	 * @param A
	 * @param m A数组的长度
	 * @param B
	 * @param n B数组的长度
	 */
	public static void merge(int A[], int m, int B[], int n) {
		if (B.length == 0) {
//			System.out.println(A);
			return;
		}
			
		int endA = m - 1;
		int endB = n - 1;
		int k= endA + endB -1;
		
		while (endA >= 0 && endB >= 0) {
			if(A[endA] >= B[endB]) {
				A[k] = A[endA];
				endA--;
				k--;
			} else {
				A[k] = B[endB];	
				k--;
				endB--;
			}
		}
		
		while (endA >= 0) {
			A[k] = A[endA];
			endA--;
			k--;
		}
		
		while (endB >= 0) {
			A[k] = B[endB];
			endA--;
			k--;
		}

		/*for (int end = m + n - 1; end >= 0; end--) {
			if (endA < 0)
				return;
			if (get(A, endA) >= get(B, endB)) {
				A[end] = A[endA]; 
				endA--;
			} else {
				A[end] = B[endB];
				endB--;
			}
		}
		
		for (int i = 0; i < A.length; i++) {
			System.out.print(A[i] + " ");
		}*/
	}

	public static int get(int[] A, int i) {
		if (i < A.length && i >= 0)
			return A[i];
		return Integer.MIN_VALUE;
	}
//	private static void merge(int A[], int m, int B[], int n) {
//		int[] c = new int[m + n];
//		int i = 0, j = 0, k = 0;
//		if (A == null || B == null) {
//			return;
//		}
//		if (A.length == 0 || B.length == 0) {
//			if (A.length == 0&& B.length != 0) {
//				for (int k2 = 0; k2 < B.length; k2++) {
//					System.out.println(B[k2]);
//				}
//			}
//			if (B.length == 0 && A.length != 0) {
//				for (int k2 = 0; k2 < A.length; k2++) {
//					System.out.println(A[k2]);
//				}
//			}
//			if (A.length ==0 && B.length == 0) {
//				return;
//			}
//		} else {
//			while (i < A.length && j < B.length) {
//				if (A[i] <= B[j]) {
//					c[k++] = A[i++];
//				} else {
//					c[k++] = B[j++];
//				}
//			}
//			while (i < A.length) {
//				c[k++] = A[i++];
//			}
//
//			while (j < B.length) {
//				c[k++] = B[j++];
//			}
//
//			for (int t = 0; t < c.length; t++) {
//				System.out.print(c[t] + " ");
//			}
//		}
//
//	}

	 }
