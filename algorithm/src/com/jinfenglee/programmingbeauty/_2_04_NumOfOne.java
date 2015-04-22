package com.jinfenglee.programmingbeauty;

/**
 * ����һ��ʮ����������N��д�´�1��ʼ����N���������������������г��ֵ����С�1���ĸ���.
 * 
 * @author Administrator
 * @Date 2014-06-16
 * @version 1.0
 */
public class _2_04_NumOfOne {
	public static void main(String[] args) {
		long n1 = 12L;
		System.out.println(totalNumOne(n1));  // 5
		System.out.println(totalNumOne(1111111110L));
		System.out.println(totalNumOne(1111121110L)); //11111 73999 ���Ը�nҲ��С�� 11111 21110L
//		System.out.println(totalNumOne(999999999L));      // 99999 9999 --> 90000 0000
//		System.out.println(totalNumOne(9999999999L));   // 99999 99999 --> 10000 00000 0
//		System.out.println(totalNumOne(99999999999L));   // 99999 99999 9---> 11000 00000 00
		
		// ���Կ�����Ҫ���nֵһ���Ǵ���9 ��9����С��10��9.
		// Ϊ�������������������n������forѭ���ǴӺ���ǰ���ҳ���һ�����������ľ�break;
//		long n = 9999999999L;
		long n = 1111121110L;
		System.out.println("-----------------------------");
		for (long i = n; i > 999999999L; i--) {
			if (totalNumOne(i) == i) {
				System.out.println(i);
				break;
			} else {
				System.out.println(totalNumOne(i)+"----------------"+i);
			}
		}
		
		// �������������ֵ�� 1 111 111 110
		//35200001
	}

	/**
	 * ��1��N����������1�ĸ���.
	 * 
	 * @param n
	 * @return
	 */
	private static Long totalNumOne(Long n) {
		long iCount = 0;
		
		long iFactor = 1;

		long iLowerNum = 0;
		int iCurrNum = 0;
		
		long iHigherNum = 0;

		while (n / iFactor != 0) {
			iLowerNum = n - (n / iFactor) * iFactor;
			iCurrNum = (int) ((n / iFactor) % 10);
			iHigherNum = n / (iFactor * 10);

			switch (iCurrNum) {
			case 0:
				iCount += iHigherNum * iFactor;
				break;
			case 1:
				iCount += iHigherNum * iFactor + iLowerNum + 1;
				break;
			default:
				iCount += (iHigherNum + 1) * iFactor;
				break;
			}
			iFactor *= 10;
		}
		return iCount;
	}
}
