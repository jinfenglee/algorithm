package com.jinfenglee.basic;

import java.util.Random;
/**
 * 
 * @description: 生成一组不重复的随机数
 * @date： 2013-11-27 13:55:06
 * 如果检测到重复，就把循环变量减1，重新循环一次，重新生成一个随机数,
 * 直到生成一个不重复的随机数为止。
 * 
 */
public class NoCommonRandom {
	public static void main(String[] args) {

		int[] result = new int[10];
		int temp = -1;
		Random random = new Random();
		boolean repeat = false;  // 记录是否检测到重复

		for (int i = 0; i < 10; i++) {
			repeat = false;

			// 加1 的目的是为了使生成的随即是都大于0
			temp = random.nextInt(20) + 1;

			for (int j = 0; j < i; j++) {
				if (temp == result[j]) {
					repeat = true;
					break;
				}
			}
			
			if (!repeat) {
				result[i] = temp;
			} else {
				i = i - 1;
			}
		}
		
		// print
		for (int i = 0; i < 10; i++) {
			System.out.print(result[i] + " ");
		}
	}
}
