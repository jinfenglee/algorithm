package com.jinfenglee.programmingbeauty;

/**
 * ���֮��2.6�� ��ȷ��ʾ������ ��������С��: X=0.a1a2...an ,X=(a1a2...an)/10^n ��������ѭ��С����
 * X=0.a1a2...an(b1b2...bm) = (a1a2��an +0.(b1b2��bm) )/ 10^n
 * ����Y=0.(b1b2��bm)����10m*Y= b1b2��bm+Y, => Y= b1b2��bm/ (10m-1)
 * 
 * ���ԣ�X= ((a1a2...an)*(10^m-1)+b1b2...bm)/((10^m-1)*10^n)
 * 
 * ���˿��Եõ�����һ������С��������ѭ��С���ķ�����ʽ�� ����ʱ���ӷ�ĸδ�������ģ� ��ʱ���ӷ�ĸ���������ǵ����Լ���� ���õ������ʽ��
 * 
 * �������ݣ� 0.325,   1.325,  0.3(33)
 * 
 * @author Administrator
 * @date 2014-06-24
 * 
 */
public class _2_06_PreciseFloat {
	public static void main(String[] args) {
		// ��������c����ѭ��С������a��ѭ��С������b  
		long a = 325L;
		long b = 10L;
		long c = 1L;
		
		if (a == 0L && b == 0L) {
			System.out.println(c);
		} else {
			// ����up ����ĸdown
			long up = c;
			long down = 1;
			long ta = a;
			// ���ϵ�ѭ����ֱ��ta��10֮���ֵת��Ϊlong�ͺ�Ϊ0.
			while (ta != 0L) {
				down *= 10;
				ta /= 10;  
			}
			up = c * down + a;   // ��1.325����ʱ�������� up = 1 *1000 + 325;
			
			if (b != 0L) {
				long wb = 1;
				long tb = b;
				while (tb != 0L) {
					wb *= 10;
					tb /= 10;
				}
				up = up * (wb - 1) + b;
				down = down * (wb - 1);
			}
			
			// ����Ӻͷ�ĸ�����Լ��
			long fac = gcd(up, down);
			
			System.out.println(up / fac + "/" + down / fac);
		}
	}
	
	/**
	 * �������������Լ��
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	private static long gcd(long x, long y) {

		if (x < y) {
			return gcd(y, x);
		}
		if (y == 0L) {
			return x;
		} else {
			return gcd(y, x % y);
		}
	}
}