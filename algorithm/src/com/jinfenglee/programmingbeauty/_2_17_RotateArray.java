package com.jinfenglee.programmingbeauty;

/**
 * ���֮�� 2.17������ѭ����λ
 * <p>
 * ���ƺ�����ʵ���������Ƶģ�����kλ�ȼ������� n - kλ(n������ĳ���).
 * 
 * @author Administrator
 * @version v1.0
 * @Date 2014-04-21 19:31:27
 * 
 */
public class _2_17_RotateArray {
	public static void main(String[] args) {
		char a[] = { 'a', 'b', 'c', 'd', '1', '2', '3', '4' };
		System.out.println(rightShift(a, a.length, 5));
		
//		System.out.println(rightShift(a, a.length, a.length - 5));
		System.out.println(rightShift1(a, a.length, 5));
	}
	
	/**
	 * �㷨���Ӷ�ΪO(n^2),��K�޹�. ��Ϊ k%=n.
	 * ��������Ƚ������뵽�����Ǹ��Ӷ�̫��.
	 * 
	 * @param arr
	 * @param n
	 * @param k
	 * @return
	 */
	private static char[] rightShift1(char[] arr, int n, int k) {
		
		k %= n;
		while (k != 0) {			
			char temp = arr[n - 1];
			
			for (int i = n - 1; i > 0; i--) {
				arr[i] = arr[i - 1];
			}
			
			arr[0] = temp;
			k--;
		}
		return arr;
	}
	
	/**
	 * ���������е�����Ԫ��
	 * 
	 * @param arr
	 * @param b
	 * @param e
	 */
	private static void reverse(char[] arr, int b, int e) {
		for (; b < e; b++, e--) {
			char temp = arr[e];
			arr[e] = arr[b];
			arr[b] = temp;
		}
	}

	/**
	 * M2: ʹ�õݹ�ʵ��
	 * 
	 * ���� k=5 ����ģ��.
	 * 
	 * 1.   ��������abc��abcd1234 �� cbad1234��
	 * 2.   ��������d1234��dcba1234 �� cba4321d��
	 * 3.   ȫ������d1234abc
	 * 
	 * ���������Ե�ʱ����ʵ�����Ʋ���.
	 * 
	 * @param arr
	 * @param n
	 * @param k
	 *            �ƶ���λ��
	 * @return
	 */
	private static char[] rightShift(char[] arr, int n, int k) {
		// ��ֹ�ƶ���λ����������ĳ��ȶ����ִ���.
		k %= n;
		
		reverse(arr, 0, n - k - 1);
		reverse(arr, n - k, n - 1);
		reverse(arr, 0, n - 1);
		
		return arr;
	}

}
