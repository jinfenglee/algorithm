package com.jinfenglee.programmingbeauty;

/**
 * ������˻������ֵ
 * ����һ������ΪN���������飬ֻ�����ó˷��������ó���������N-1������ϵĳ˻�����һ�飬
 * ��д���㷨��ʱ�临�Ӷȡ� 
 *
 * @author Administrator
 * @date 2014-07-08 22:03:12
 *
 */
public class _2_13_01_SubArrayMaxMultiply {
	public static void main(String[] args) {

		int[] a = { 2, 3, 6, 1, 8 };
		long result=getMaxSubMultiply(a);
		System.out.println(result);

		_2_13_01_SubArrayMaxMultiply arrayMaxMultiply = new _2_13_01_SubArrayMaxMultiply();
		System.out.println(arrayMaxMultiply.max(a));

	}

	/**
	 * M1: ʱ�临�Ӷ�ΪO(n^2),���á�
	 * 
	 * @param data
	 * @return
	 */
	public static long getMaxSubMultiply(int[] data) {

		long result = Long.MIN_VALUE;
		int length = data.length;

		for (int i = 0; i < length; i++) {
			long r = 1L;

			for (int j = 0; j < length; j++) {
				if (j != i) {
					r *= data[j];
				}
			}

			if (result < r) {
				result = r;
			}
		}
		return result;
	}

	/**
	 * ������������飬Ȼ��ȥ�Ƚ�������Ĵ�С ʱ�临�Ӷ�Ϊ O(n)
	 * 
	 * @param a
	 * @param b  N-1 ��Ԫ�س˻�����ɵ�����.
	 * @param len
	 *            ����ĳ���
	 */
	private void makeArray(int a[], int b[], int len) {
		int i;
		b[0] = 1;
		for (i = 1; i < len; ++i) {
			b[0] *= a[i - 1];  // b[0]�б���a[0]��a[i-1]�ĳ˻�
			b[i] = b[0]; 	   // b[i] = a[0]*a[1]*...*a[i-1]
		}
		// ������һ��forѭ����
		// b[1]=a[0]     
		// b[2]=a[0]*a[1]        
		// b[3]=a[0]*a[1]*a[2]
		// b[4]=a[0]*a[1]*a[2]*a[3] 

		b[0] = 1;
		for (i = len - 2; i > 0; --i) {
			b[0] *= a[i + 1]; 	// b[0] = a[i+1]*a[i+2]...*a[len-1]����b[0]�б���a[i+1]��a[len-1]�ĳ˻�
			b[i] *= b[0];  // b[i] = a[0]*a[1]*...*a[i-1]*a[i+1]*...*a[len-1]
			               // (�����forѭ�����Ѿ��������b[1]��b[2]��b[3]...)
			// �����һ��forѭ��д������Ǻܸ߼���  ����Ϊ�˴ճ�  b[i] = a[0]*a[1]*...*a[i-1]*a[i+1]*...*a[len-1]
		}
		b[0] *= a[1]; // ע����һ�㣬��������forѭ����b[0]= a[2]*...   ��������Ҫ�ٳ���b[1]
	}

	/**
	 * M2�� �ҵ������е����Ԫ��
	 * @param a
	 * @return
	 */
	public int max(int[] a) {
		int max;
		int length = a.length;                                                                   
		int[] b = new int[length];  // ����b��ȡ��n-1��Ԫ�س˻���ɵ�����

		makeArray(a, b, length);    // �������������
		max = b[0];

		// �ҳ����������飬����ֵ��max
		for (int i = 1; i < length; i++) {
			if (max < b[i]){
				max = b[i];
			}		
		}

		return max;
	}
}
