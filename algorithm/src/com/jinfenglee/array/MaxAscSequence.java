package com.jinfenglee.array;

/**
 * TODO: 一串数据的最大递增序列，输出个数.例如 4，2， 6，3， 1，5， 最大递增序列为， 2，3， 5，输出3
 * 
 * @author li.jf
 * 
 * LeetCode 中有算法和这个类似.
 */
public class MaxAscSequence {
	public static void main(String[] args) {
		int[] a = { 4, 2, 6, 3, 1, 5, 8 };
		System.out.println("max increase sequence length: " + maxSquenceLength(a));
	}

	/**
	 * 一组数的最大递增序列
	 * 
	 * @param arr
	 * @return int 最大递增序列的长度
	 */
	public static int maxSquenceLength(int[] arr) {
		int[] sequenceArr = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			// 初始化每个递增序列的值都为1
			sequenceArr[i] = 1; 
			for (int j = 0; j < i; j++) {
				if ((arr[j] < arr[i]) && (sequenceArr[j] + 1 > sequenceArr[i])) {
					sequenceArr[i] = sequenceArr[j] + 1;
				}
			}
		}

		int max = 0;
		for (int k = 0; k < sequenceArr.length; k++) {
			if (sequenceArr[k] > max) {
				max = sequenceArr[k];
			}
			// max = (sequenceArr[k] > max) ? sequenceArr[k] : max;
		}

		return max;
	}
}
