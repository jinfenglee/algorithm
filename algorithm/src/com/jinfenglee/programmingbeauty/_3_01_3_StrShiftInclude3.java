package com.jinfenglee.programmingbeauty;

/**
 * 
 * �ⷨ3��Ҫ���ж�s1��λ����ַ����Ƿ����s2����ʵ��˼���ǡ�������ǰ��ַ���������һ��ѭ���ַ�����
 * ��ô��s2�ַ����е��ַ��ܷ���s1���ѭ���ַ�����˳�������ĳ��֣� ����ܣ���˵��������������ܣ���˵��������������
 * 
 * ����Ч������ߵ�. ʹ��ȡ�࣬����������.
 * 
 * @author LJF
 * @date: 2014-05-07 15:04:53
 * 
 */
public class _3_01_3_StrShiftInclude3 {
	public static void main(String[] args) {
		String s1 = "AABCD";
		String s2 = "CDAA";
		System.out.println(containStr4(s1, s2));
	}

	private static boolean containStr4(String s1, String s2) {
		int i = 0;
		int j = 0;

		while (i < s1.length() && s1.charAt(i) != s2.charAt(j)) {
			i++;
		}

		for (; i < s1.length() && j < s2.length();) {

			if (s1.charAt(i) != s2.charAt(j)) {
				return false;
			}

			// ��Ҫ������һ�����.
			// ��ʵû��Ҫ�� s1 ������������λ, ���δ� s1[0], s1[1], ... ��ʼ�Ƚ�,
			// ��� s1 ���±곬����Χ, �Ͷ���ȡ��, �������൱���ӳ��ַ��� s1 ��.
			i = (i + 1) % s1.length();

			j++;
		}

		if (j == s2.length()) {
			System.out.println("contain!");
			return true;
		}

		return false;
	}

}
