package com.jinfenglee.leetcode.array;

/**
 * Follow up for "Remove Duplicates":<br>
 * What if duplicates are allowed at most twice?<br>
 * For example: Given sorted array A = [1,1,1,2,2,3], <br>
 * Your function should return length = 5, and A is now [1,1,2,2,3].
 * 
 * @author LJF
 * @date 2014-11-09 18:33:32
 * @review 2015-03-03 22:18:00
 * 
 */
public class RemoveDuplicatesII {
	public static void main(String[] args) {
		int[] a = { 1, 1, 2, 2, 3, 3, 3, 4,4,5,5,5, 6 };
		System.out.println(removeDuplicates(a));
	}

	public static int removeDuplicates(int[] A) {
		int len = A.length;
		int resultLen = 1;
//		int tempElem = A[1];

		if (len == 0 || len == 1) {
			return len;
		}
			
		// this line must below if(),because A.length maybe 0
		int tempElem = A[1];
		for (int i = 2; i < len; i++) {
			if (A[i] != A[i - 2]) {
				A[resultLen++] = tempElem;
				tempElem = A[i];
			}
		}
		A[resultLen++] = tempElem;

		return resultLen;
	}
}
