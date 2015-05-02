package com.jinfenglee.basic;

/**
 * 找出四个数组（都已经排序好）的交集.
 * @author LJF
 * @date 2015-05-02 09:05:19
 *
 */
public class FourArrIntersection {
	public static void main(String[] args) {
		int a[] = { 2, 3, 5, 67, 78 };
		int b[] = { 1, 5, 8, 33 };
		int c[] = { 3, 4, 5, 6, 7 };
		int d[] = { 1, 2, 5, 7, 9, 10 };

		int arr[] = getCommonArray(a, b, c, d);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	/**
	 * 获取几个数组的公共部分
	 * 
	 * @param A
	 * @param B
	 * @param C
	 * @param D
	 * @return []resultArray 结果数组
	 */
	private static int[] getCommonArray(int[] A, int[] B, int[] C, int[] D) {
		if (A == null || B == null || C == null || D == null || A.length == 0
				|| B.length == 0 || C.length == 0 || D.length == 0)
			return null;

		int lenA = A.length;
		int lenB = B.length;
		int lenC = C.length;
		int lenD = D.length;

		// 找出4个数组比较后的最小长度.
		int minLen = Math.min(lenA, Math.min(lenB, Math.min(lenC, lenD)));

		int[] resultArray = new int[minLen];
		int i = 0;
		int j = 0;
		int x = 0;
		int y = 0;

		int index = 0;

		while (i < lenA && j < lenB && x < lenC && y < lenD) {
			if (A[i] == B[j] && B[j] == C[x] && C[x] == D[y]) {
				resultArray[index++] = A[i];
				i++;
				j++;
				x++;
				y++;
			} else {
				int min = Math.min(A[i], Math.min(B[j], Math.min(C[x], D[y])));
				if (A[i] == min)
					i++;
				if (B[j] == min)
					j++;
				if (C[x] == min)
					x++;
				if (D[y] == min)
					y++;
			}
		}
		return resultArray;
	}

}
