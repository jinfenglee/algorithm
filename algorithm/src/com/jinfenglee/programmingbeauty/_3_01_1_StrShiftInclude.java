package com.jinfenglee.programmingbeauty;

/**
 * ���⣺���������ַ���s1��s2��Ҫ���ж�s2�Ƿ��ܹ�ͨ��s1��ѭ����λ�����õ����ַ���������
 * ���磬����s1��AABCD��s2=CDAA������true������s1=ABCD��s2=ACBD������false��
 * 
 * @author LJF
 * @date 2014-03-26 14:23
 * 
 */

// ֱ���������������Ϳ���
//	public static boolean containStr2(String s1, String s2) {
//		s1 = s1.concat(s1);
//		return s1.contains(s2);
//	}

public class _3_01_1_StrShiftInclude {

	private static final int MATCH = 1;
	private static final int NO_MATCH = 0;

	private String source;

	public _3_01_1_StrShiftInclude(String source) {
		this.source = source;
	}

	/**
	 * �ÿռ�����ʱ��,��s1 copy һ������´������´��Ƿ����s2
	 * 
	 * @param pattern
	 * @return boolean �Ƿ����
	 */
	public int doMatch(String pattern) {
		// �ַ�������һ��ƴ�������������pattern��˵��������ô��λ��������.
		String str = this.source + this.source;

		if (str.contains(pattern)) {
			return MATCH;
		} else {
			return NO_MATCH;
		}
	}

	public static void main(String[] args) {

		String s1 = "AABCD";
		String s2 = "CDAA";

		_3_01_1_StrShiftInclude include = new _3_01_1_StrShiftInclude(s1);

		if (include.doMatch(s2) == _3_01_1_StrShiftInclude.MATCH) {
			System.out.println("contain!");
		} else {
			System.out.println("not contain!");
		}
	}

}
