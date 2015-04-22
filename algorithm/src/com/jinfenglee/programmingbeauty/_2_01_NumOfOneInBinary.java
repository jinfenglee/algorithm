package com.jinfenglee.programmingbeauty;

/**
 * 
 * 2.1 ��һ������������1�ĸ��� ��һ����ת��Ϊ�����ƺ�1�ĸ���.��
 * 
 * @author LJF
 * @version 1.0
 * @Date 2013-05-17
 * 
 */
public class _2_01_NumOfOneInBinary {
	public static void main(String[] args) {
		int a = 1023;
		int total1=count(a);
		int total = count2(a);
		int total2 = count3(a);
		System.out.println("����" + a + "ת���ɶ����ƺ�1�ĸ�����" + total);
		System.out.println("����" + a + "ת���ɶ����ƺ�1�ĸ�����" + total1);
		System.out.println("����" + a + "ת���ɶ����ƺ�1�ĸ�����" + total2);
	}
	// �����������ϵķ�ʽ
	private static int count(int v) {
		int num = 0;
		
		// ��C++�п���д���� while(v)
		while (v != 0) {
			if (1 == v % 2) {
				num++;
			}
			v /= 2;
		}
		return num;
	}
	
	/**
	 * ʹ��λ���㣬�����ƹ����У����һλֱ�Ӷ�������ˣ���Ҫ�ж����һλ�Ƿ�Ϊ1.
	 * O(log2 v)
	 * @param v
	 * @return
	 */
	private static int count2(int v) {
		int num = 0;
		
		while (v != 0) {
			num += v & 0x01;
			v >>= 1;
		}
		return num;
	}
	
	/**
	 * ���㷨���ӶȽ���1�ĸ����й�.
	 * �㷨���ӶȽ�һ�����ͣ�
	 * 
	 * @param v
	 * @return
	 */
	private static int count3(int v){
		int num = 0;

		// �����ʹ��1010��1001�������һ��.
		while (v != 0) {
			v &= (v - 1);
			num++;
		}
		return num;	
	}
	
	// ����4����0~255�С�1���ĸ���ֱ�Ӵ���������У�v��Ϊ������±꣬counttable[v]����v�С�1���ĸ�����
	// �㷨��ʱ�临�ӶȽ�ΪO(1)��
}
