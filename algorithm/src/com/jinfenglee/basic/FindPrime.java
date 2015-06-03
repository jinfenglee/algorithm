package com.jinfenglee.basic;
/**
 * 
 * @author LJF
 * @version 1.0  2013-12-26 13:44:53
 * ����1~n ֮�����������
 *
 */
public class FindPrime {
	public static void main(String[] args) {
		/*for(int i=2;i <= 20; i++) {
			if(isPrime(i)) {
				System.out.print(" "+i);
			}
		}*/
		
		// ˼·�������еĺ���ȥ�������������� ���˼·�����˵�ȽϺ�һЩ...
		int n = 30;
		int[] array = new int[n];
		for (int i = 2; i < 30; i++) {
			array[i] = i;
		}

		for (int i = 2; i < n; i++) {
			if (array[i] != 0) {
				int j, temp;

				temp = array[i];
				for (j = 2 * temp; j < n; j += temp) {
					array[j] = 0;
				}
				System.out.print(" "+array[i]);
			}
		}
		
	}

	// method1 �ܳ��������  Ч�ʺܵ� ����main��  ���Ӷ� O(n^2)
/*	private static boolean isPrime(int num) {
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if(num % i ==0) {
				return false;
			}
		}
		return true;
	}*/
	
}
