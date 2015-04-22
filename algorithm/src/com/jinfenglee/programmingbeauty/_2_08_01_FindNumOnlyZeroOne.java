package com.jinfenglee.programmingbeauty;

/**
 * �ҳ���������������
 * �������һ��������N����һ����С��������M��ʹ��N*M��ʮ���Ʊ�ʾ��ʽ��ֻ����0��1.
 * 
 * M1: �����֮��Ľ�������ж�.(Ч�ʽϵͣ�ִ��M��)
 * 
 * @author Administrator
 *
 */
public class _2_08_01_FindNumOnlyZeroOne {
	
	public static void main(String[] args) {
		int n = 136;
		long m;
		
		for (m = 1L; ; m++) {
			long result = m * n;
			if (hasOnlyOneAndZero(result)) {
				System.out.println(n +"-- " + m + "--" + n * m);
				break;
			}
		}
	}

	/**
	 * �ж�һ�������Ƿ��������0��1.
	 */
	private static boolean hasOnlyOneAndZero(long n) {
		while (n != 0) {
			if (n % 10 > 1) {
				return false;
			}
			
			n /= 10; // ֮���Գ���10 �Ƿ�ֹֻ�и�λ��, ��:9
		}
		return true;
	}
}
