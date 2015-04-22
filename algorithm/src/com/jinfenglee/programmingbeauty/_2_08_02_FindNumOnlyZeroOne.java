package com.jinfenglee.programmingbeauty;

/**
 * 2.8 求满足条件的整数M 使得 M*N 中只含有0和1
 * 
 * 换个角度思考，M满足条件时，乘积product也是第一次满足条件（只含有0,1）. product % n == 0
 * 因为product遍历的次数比M少，可以从product入手. 
 * 乘积product的可能取值为 1, 10, 11, 100, 101, 110, 111 ...[十进制的.] 
 * 我们可以将其映射成二进制数 1, 2， 3， 4， 5， 6， 7 .....
 * 
 * 然后遍历，当product%N == 0时，product就是我们需要的最小乘积， procude/ N 就是我们需要的M值。
 * 
 * @author LJF
 * @date 2014-06-30 20:23:06
 * 
 */
public class _2_08_02_FindNumOnlyZeroOne {
	public static void main(String[] args) {
		// 126可能就是特殊情况，与任何值相乘都不可能得到一个0和1组成的乘积.
		// int n = 126;   
		
        int n =136;
		for (int i = 1; /*i <= Integer.MAX_VALUE*/; i++) {
			int decimal = decimalFromMappedBinary(i);

			if (decimal % n == 0) {
				System.out.print("M的值：" + decimal / n + " ,乘积为:" + decimal);
				break;
			}
		}
	}

	/**
	 * 从二进制中映射出的十进制
	 * 
	 * @param result 为乘积的结果（只包含0和1）
	 * @return
	 */
	private static int decimalFromMappedBinary(int i) {
		// String s= String.valueOf(result);
		String k = Integer.toBinaryString(i); // 二进制形式
		int result = Integer.valueOf(k);      // "10101"--> 十进制的 10101
		
		return result;
	}
}
