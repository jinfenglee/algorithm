package com.jinfenglee.programmingbeauty;

/**
 * 编程之美 2.21 只考加法的面试题
 * 写一个程序，对于一个64位正整数，输出它所有可能的连续自然数之和的算式.
 * 
 * @author LJF
 * @date 2014-07-31 07:31:55
 * 
 */
public class _2_21_justPlusInterview {
	public static void main(String[] args) {
		int n = 15;
		deCompose(n);
		System.out.println("--------------------------------");
		deCompose2(n);
	}

	
	/**
	 * s+(s+1)+(s+2)+...+(s+k) = n
	 * (k+1)s + (k+1)k/2 = n
	 * (k+1)(2s+k)=2n
	 * s = (2n/(k+1)-k)/2
	 * 因为 s, k都是整数，所以应满足2n%(k+1)==0 && (2n/(k+1)-k)%2==0
	 * @param n
	 */
	private static void deCompose(int n) {
		int last = (int) Math.sqrt(2 * n); // 0+ ...+last ==> (last+1)*last=2n

		for (int k = 1; k < last; k++) {
			if (2 * n % (k + 1) == 0 && (2 * n / (k + 1) - k) % 2 == 0) {
				int s = (2 * n / (k + 1) - k) / 2;
				print(n, s, k);
			}
		}
	}
	
	/**
	 * 时间复杂度O(n)，但是只使用了加减法
	 * @param n
	 */
	private static void deCompose2(int n) {
		int start = 1;
		int end = 1;
		int sum = 0;

//		int up = (n + 1) >> 2;
		int up = (n + 1) >> 1; // 如果n=5上面那样做肯定不合适.
		while (end <= up) {
			sum += end;
			if (sum == n) {
				print(n, start, end - start);
				sum -= start++;
				end++;
			} else if (sum < n) {
				end++;
			} else {
				sum -= end;
				sum -= start++;
			}
			/**
			 * sum=15 start=1 end =5
			 * sum=14 start=2 end=6
			 * sum=20 12  start=3 end=6
			 * sum=18 9  start=4 end=6
			 * sum+end=15  4,5,6
			 * sum=11 start=5 end=7
			 * sum=18 6 start=6 end =7
			 * sum=13   start=6 end=8
			 * sum=21 7 start=7 end=8
			 * sum=0 start=8 end=9（up=8）   while循环结束
			 * 7+8=15
			 *  
			 */
		}
	}
	
	/**
	 * 打印输出
	 * 
	 * @param n
	 *            连续元素总和
	 * @param m
	 *            起始元素的值
	 * @param k
	 *            元素的总个数-1
	 */
	private static void print(int n, int m, int k)
	{
		System.out.print(n + " = ");
		for (int i = m; i <= m + k; i++) {
			if (i == m)
				System.out.print(i);
			else
				System.out.print("+" + i);
		}
	    System.out.println();
	}
	/**
	 * 子序列数目最多的数是哪一个？
	 * 子序列最多这一点可以推断出该序列一定是从1开始的，那么就有
	 * (k+1)k/2 <= INT_MAX
	 * k = sqrt(2*INT_MAX);
	 * if ( (k+1)k/2 > INT_MAX)
	 * k--;
	 */
}
