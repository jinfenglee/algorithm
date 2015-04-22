package com.jinfenglee.programmingbeauty;

/**
 * Ѱ�������ԣ�1��  �ȿ�һά�����������ҳ�N����������ֻ�����Сֵ.
 * 
 * @author LJF
 */
public class _2_11_MinPointPair_1 {
	public static void main(String[] args) {
		double[] arr = new double[] { 2.2, 4.1, 3.2, 5, 2, 1, 1.9, 1.5, 8, 4.05 };
		double result = minDifference(arr, arr.length);
		System.out.println(result);
	}
	
	/**
	 * ������������֮�����Сֵ. (������һά��չ����ά.)   
	 * O(N^2),����ʹ�ã����š��鲢��������ʹ���Ӷ�����ΪO(N*log2n)
	 * 
	 * @param arr
	 * @param n
	 * @return
	 */
	private static double minDifference(double[] arr, int n) {
		if (n <= 1) {
			return 0;
		}
		double fMinDiff = Math.abs(arr[0] - arr[1]);

		for (int i = 0; i < n; ++i) {
			for (int j = i + 1; j < n; j++) {
				double temp = Math.abs(arr[i] - arr[j]);
				if (fMinDiff > temp) {
					fMinDiff = temp;
				}
			}
		}
		return fMinDiff;
	}

}
