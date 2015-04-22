package com.jinfenglee.programmingbeauty;

/**
 * 找出符合条件的整数
 * 任意给定一个正整数N，求一个最小的正整数M，使得N*M的十进制表示形式里只含有0和1.
 * 
 * M1: 对相乘之后的结果进行判断.(效率较低，执行M次)
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
	 * 判断一个数中是否仅有数字0和1.
	 */
	private static boolean hasOnlyOneAndZero(long n) {
		while (n != 0) {
			if (n % 10 > 1) {
				return false;
			}
			
			n /= 10; // 之所以除以10 是防止只有个位数, 如:9
		}
		return true;
	}
}
