package com.jinfenglee.programmingbeauty;

import java.util.Arrays;

/**
 * �ܷ�����ҵ�һ�������е��������֣�����֮�͵���һ�����������֡�
 * <p>
 * ������������п϶���������һ��������Ϸ���Ҫ��Ľ�.
 * 
 * @author LJF
 * @date 2014-07-02 07:27:38
 * 
 */
public class _2_12_Find2NumSum {

	public static void main(String[] args) {
		int a[] = { 5, 56, 23, 1, 45, 67 };
		int sum = 68;
		find(a, sum);
		System.out.println("-------M2:---------");
		find2(a, sum);
		
		System.out.println(search(a, a.length, 67));  // �ҵ�������67 ���Ϊsum������Ԫ���±꣬��1��ʼ.
		System.out.println(search2(a, a.length, 67));

	}

	/**
	 * M1: n(n-1)/2 �Σ�ʱ�临�Ӷ�ΪO(n^2).
	 * 
	 * @param a
	 * @param sum
	 *            �����������ĺ�
	 */
	private static void find(int[] a, int sum) {
		for (int j = 0; j < a.length; j++) {
			for (int k = j + 1; k < a.length; k++) {
				if (a[j] + a[k] == sum) {
					System.out.println(a[j] + "----" + a[k]);
				}
			}
		}
	}

	/**
	 * �������ֱ��������ָ�����˽���ɨ��.ʱ�临�Ӷ� O(n)
	 * <p>
	 * ��������Ƚ��������������ɨ�裬ʱ�临�Ӷ�O(N*logN)+O(N)=O(N*logN)
	 * <p>
	 * �ռ临�Ӷ�ʼ��ΪO(1).
	 * 
	 * @param a
	 * @param sum
	 */
	private static void find2(int[] a, int sum) {
		Arrays.sort(a);

		for (int i = 0, j = a.length - 1; i < j;) {
			if (a[i] + a[j] == sum) {
				System.out.println(a[i] + "--" + a[j]);
				i++;
			} else if (a[i] + a[j] < sum) {
				i++;
			} else {
				j--;
			}
		}
	}
	
	/*
	 * M3:
	 * Ҫ��ﵽʱ��O(n),�ռ�O(1)��Ŀ�ֻ꣬��ԭ������������ܹ�����������������������Ļ�����ֻ��������
	 * Ȼ����ж��ֲ��� ʱ�临�Ӷ�ΪO(N*logN), ����ʹ��ӳ�����Hash��
	 * ��ʱ��Ϳռ䶼��O(n)����ʹ���˿ռ任ʱ�䡣
	 * ����һ�����֣����߹�ϣӳ�������һ�������Ƿ�Ҳ�������У�ֻ��ҪO(1)��ʱ��.
	 */

	////////////////////���ֲ��ҵ�ʵ��//////////////////////
	static int search(int array[], int n, int v) {
		int left, right, middle;
		left = 0;
		right = n;
		
		while (left < right) {
			middle = left + (right - left) / 2;

			if (array[middle] > v) {
				right = middle;
			} else if (array[middle] < v) {
				left = middle + 1;
			} else {
				return middle;
			}
		}
		return -1;
	}
	
	// ��������õ������±�.
	static int search2(int array[], int n, int v) {
		int left, right, middle;

		left = 0;
		right = n - 1;

		while (left <= right) {
			middle = left + (right - left) / 2;
			
			if (array[middle] > v) {
				right = middle - 1;
			} else if (array[middle] < v) {
				left = middle + 1;
			} else {
				return middle;
			}
		}
		return -1;
	}

}
