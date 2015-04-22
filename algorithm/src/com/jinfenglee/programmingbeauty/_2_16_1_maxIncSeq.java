package com.jinfenglee.programmingbeauty;

/**
 * ������������������
 * 
 * ����һ������ΪN�����飬�ҳ�һ����ĵ������������У���һ����������
 * ������  1,-1,2,-3,4,-5,6,-7������������г���Ϊ4��1,2,4,6��
 * 
 * @author LJF
 * @date 2014-07-15 08:17:30
 * 
 */
public class _2_16_1_maxIncSeq {
	public static void main(String[] args) {
//		int[] a = { 1, -1, 2, -3, 4, -5, 6, -7, 5, 8 };
		int []a = {1,-1, 2,-3, 4};
		int result = lis(a, a.length);
		System.out.println(result);
	}

	/**
	 * O(n^2)  �ռ临�Ӷ�O(n).
	 * 
	 * ��һ����������������¼��ӦԪ�ؽ�β�������������еĳ���(lis[i] ��ʾ��a[i] ��β��������
	 * �����еĳ���)����ÿһ��Ԫ�أ������β�������������еĳ���ҪôΪ1��ҪôΪ���Ԫ��ǰ���Ԫ����С��
	 * ��Ԫ���������������еĳ��������Ǹ�Ԫ�ض�Ӧ�������������еĳ��� +1.
	 * @param a
	 * @param n
	 * @return �����������еĳ���
	 */
	private static int lis(int[] a, int n) {
		int lis[] = new int[n];
		int i;
		int j;
		
		/**
		 * 1  -1  2  -3  4
		 * lis[i]��ʼ��
		 * 1  1   1  1   1
		 * lis[i]forѭ��������ֵ:
		 * 1  1  2   1   3
		 */
		for (i = 0; i < n; i++) {
			lis[i] = 1;
			
			for (j = 0; j < i; j++) {
				if (a[i] > a[j] && lis[j] + 1 > lis[i]) {
					lis[i] = lis[j] + 1;
				}
			}
		}
		
		int max = 0;
		for (i = 0; i < n; i++) {
			if (lis[i] > max) {
				max = lis[i];
			}
		}
		
		return max;
	}

}
