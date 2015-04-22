package com.jinfenglee.programmingbeauty;

/**
 * 2.8 ����������������M ʹ�� M*N ��ֻ����0��1
 * 
 * �����Ƕ�˼����M��������ʱ���˻�productҲ�ǵ�һ������������ֻ����0,1��. product % n == 0
 * ��Ϊproduct�����Ĵ�����M�٣����Դ�product����. 
 * �˻�product�Ŀ���ȡֵΪ 1, 10, 11, 100, 101, 110, 111 ...[ʮ���Ƶ�.] 
 * ���ǿ��Խ���ӳ��ɶ������� 1, 2�� 3�� 4�� 5�� 6�� 7 .....
 * 
 * Ȼ���������product%N == 0ʱ��product����������Ҫ����С�˻��� procude/ N ����������Ҫ��Mֵ��
 * 
 * @author LJF
 * @date 2014-06-30 20:23:06
 * 
 */
public class _2_08_02_FindNumOnlyZeroOne {
	public static void main(String[] args) {
		// 126���ܾ���������������κ�ֵ��˶������ܵõ�һ��0��1��ɵĳ˻�.
		// int n = 126;   
		
        int n =136;
		for (int i = 1; /*i <= Integer.MAX_VALUE*/; i++) {
			int decimal = decimalFromMappedBinary(i);

			if (decimal % n == 0) {
				System.out.print("M��ֵ��" + decimal / n + " ,�˻�Ϊ:" + decimal);
				break;
			}
		}
	}

	/**
	 * �Ӷ�������ӳ�����ʮ����
	 * 
	 * @param result Ϊ�˻��Ľ����ֻ����0��1��
	 * @return
	 */
	private static int decimalFromMappedBinary(int i) {
		// String s= String.valueOf(result);
		String k = Integer.toBinaryString(i); // ��������ʽ
		int result = Integer.valueOf(k);      // "10101"--> ʮ���Ƶ� 10101
		
		return result;
	}
}
