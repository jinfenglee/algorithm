package com.jinfenglee.programmingbeauty;

/**
 * 编程之美2.6： 精确表示浮点数 对于有限小数: X=0.a1a2...an ,X=(a1a2...an)/10^n 对于无限循环小数：
 * X=0.a1a2...an(b1b2...bm) = (a1a2…an +0.(b1b2…bm) )/ 10^n
 * 其中Y=0.(b1b2…bm)，则10m*Y= b1b2…bm+Y, => Y= b1b2…bm/ (10m-1)
 * 
 * 所以：X= ((a1a2...an)*(10^m-1)+b1b2...bm)/((10^m-1)*10^n)
 * 
 * 至此可以得到任意一个有限小数或无限循环小数的分数形式， 但此时分子分母未必是最简的， 此时分子分母都除以它们的最大公约数， 即得到最简形式。
 * 
 * 测试数据： 0.325,   1.325,  0.3(33)
 * 
 * @author Administrator
 * @date 2014-06-24
 * 
 */
public class _2_06_PreciseFloat {
	public static void main(String[] args) {
		// 整数部分c，非循环小数部分a，循环小数部分b  
		long a = 325L;
		long b = 10L;
		long c = 1L;
		
		if (a == 0L && b == 0L) {
			System.out.println(c);
		} else {
			// 分子up ，分母down
			long up = c;
			long down = 1;
			long ta = a;
			// 不断地循环，直至ta除10之后的值转换为long型后为0.
			while (ta != 0L) {
				down *= 10;
				ta /= 10;  
			}
			up = c * down + a;   // 用1.325测试时，结束后 up = 1 *1000 + 325;
			
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
			
			// 求分子和分母的最大公约数
			long fac = gcd(up, down);
			
			System.out.println(up / fac + "/" + down / fac);
		}
	}
	
	/**
	 * 求两个数的最大公约数
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