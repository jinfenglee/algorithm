package com.jinfenglee.programmingbeauty;

/**
 * Fibonacci 数列的几种实现方式，包括一些优化.
 * 
 * @author Administrator
 * @Date 2014-05-03
 * 
 */
public class _2_09_Fibonacci {
	public static void main(String[] args) {
		int x = 44;
		System.out.println(Fibonacci1(x));
		System.out.println(Fibonacci2(x));
		System.out.println(Fibonacci3(x));
	}

	// 递归实现，当n比较大的时候开销会很大,不建议这样使用.	
	private static int Fibonacci1(int n) {
		if (n <= 0)
			return 0;
		else if (n == 1)
			return 1;
		else
			return Fibonacci1(n - 1) + Fibonacci1(n - 2);
	}

	/**
	 * 用数组保存每次计算过的值，速度很快，但占用空间较大.
	 * 
	 * @param n
	 * @return
	 */
	private static long Fibonacci2(int n) {

		long[] fib = new long[n + 1];
		fib[0] = 0;
		fib[1] = 1;
		for (int i = 2; i <= n; i++) {
			fib[i] = fib[i - 1] + fib[i - 2];
		}
		return fib[n];
	}

	/**
	 * 用两个变量存储前两个计算的结果，实现方式和用数组实现是相似的.
	 * 方法比较好.
	 * f(0)=0   temp=0
	 * f(1)=1   f(0)
	 * f(1)=temp+f(0)
	 * temp=1
	 * f(0)=1
	 * f(1)=2
	 * temp=1  f(0)=2  f(1)=3  此时 i=4
	 * 
	 * 
	 * @param n
	 * @return
	 */
	private static long Fibonacci3(int n) {
		long f0 = 0L;
		long f1 = 1L;
		long temp;

		for (int i = 2; i <= n; i++) {
			temp = f0;
			f0 = f1;
			f1 += temp;

		}
		return f1;
	}
}
