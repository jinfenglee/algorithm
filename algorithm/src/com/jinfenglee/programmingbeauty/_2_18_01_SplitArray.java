package com.jinfenglee.programmingbeauty;

/**
 * 分割数组
 * http://blog.csdn.net/jiang_bing/article/details/8107201
 * @author LJF
 * 
 */
public class _2_18_01_SplitArray {
	/**  { 2, 5, 2, 1, 4 };  */
	static final int MAX = 7;
	static int[] arr = { 2, 5, 8, 2, 1, 4, 7 };
	static int sum_2;
	static {
		for (int i = 0; i < arr.length; i++)
			sum_2 += arr[i];
		sum_2 /= 2;
	}
	static int best = 100000;
	static int cv;
	static int[] result = new int[MAX];
	static int[] helper = new int[MAX];

	static void back(int t) {
		if (t == MAX) {
			if (Math.abs(cv - sum_2) < best) {
				best = Math.abs(cv - sum_2);
				System.arraycopy(helper, 0, result, 0, helper.length);
			}
			return;
		}
		if (cv <= sum_2) { // 大于就没必要再加了，加了只能更大
			helper[t] = 1;
			cv += arr[t];
			back(t + 1);
			helper[t] = 0;
			cv -= arr[t];
			back(t + 1);
		}
	}

	public static void main(String[] args) {
		back(0);
		for (int i = 0; i < MAX; i++) {
			if (result[i] == 1)
				System.out.print(arr[i] + " ");
		}
	}

}
