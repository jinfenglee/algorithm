package com.jinfenglee.programmingbeauty;

/**
 * 给定一个十进制正整数N，写下从1开始，到N的所有正整数，计算其中出现的所有“1”的个数.
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
		System.out.println(totalNumOne(1111121110L)); //11111 73999 所以该n也是小于 11111 21110L
//		System.out.println(totalNumOne(999999999L));      // 99999 9999 --> 90000 0000
//		System.out.println(totalNumOne(9999999999L));   // 99999 99999 --> 10000 00000 0
//		System.out.println(totalNumOne(99999999999L));   // 99999 99999 9---> 11000 00000 00
		
		// 可以看出所要求的n值一定是大于9 个9而且小于10个9.
		// 为了求出满足条件的最大的n，所以for循环是从后向前，找出第一个满足条件的就break;
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
		
		// 满足条件的最大值是 1 111 111 110
		//35200001
	}

	/**
	 * 求1到N的数中所有1的个数.
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
