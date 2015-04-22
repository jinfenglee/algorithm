package com.jinfenglee.dynamaicprogram;

/**
 * ��̬�滮��һ�������ӣ�
 * һ����N��1 �����ٲ��裬����� 3�ı�������3��������Լ�2���߼� 1�� 
 * ���� 7: 7-1=6�� 6/3=2�� 2-1=1��
 * 
 * �����Ա���һ���⣨�ο�����
 * http://zhiqiang.org/blog/science/computer-science/complexity-of-recursive-algorithm.html
 * @author LJF
 * 
 */
public class MogujieDynamicProgram {
	public static void main(String[] args) {
		System.out.println(leastCount(8));
	}

	private static int min(int a, int b) {
		return a < b ? a : b;
	}

	private static int leastCount(int n) {
		if (n <= 1)
			return 0;
		if (n == 2)
			return 1;
		if (n % 3 == 0)
			return leastCount(n / 3) + 1;
		else if (n % 3 == 1)
			return min(leastCount(n / 3 + 1), leastCount(n / 3)) + 2;
		else if (n % 3 == 2)
			return min(
					min(leastCount(n / 3 + 2), leastCount(n / 3 + 1)) + 2,
					min(leastCount(n / 3 + 1), leastCount(n / 3)) + 2
					) + 1;
		else 
			return n;
	}
}
