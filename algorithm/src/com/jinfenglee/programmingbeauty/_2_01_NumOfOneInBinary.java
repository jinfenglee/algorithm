package com.jinfenglee.programmingbeauty;

/**
 * 
 * 2.1 求一个二进制数中1的个数 （一个数转换为二进制后1的个数.）
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
		System.out.println("数字" + a + "转换成二进制后1的个数：" + total);
		System.out.println("数字" + a + "转换成二进制后1的个数：" + total1);
		System.out.println("数字" + a + "转换成二进制后1的个数：" + total2);
	}
	// 求余和相除相结合的方式
	private static int count(int v) {
		int num = 0;
		
		// 在C++中可以写成是 while(v)
		while (v != 0) {
			if (1 == v % 2) {
				num++;
			}
			v /= 2;
		}
		return num;
	}
	
	/**
	 * 使用位运算，在右移过程中，最后一位直接丢掉，因此，需要判断最后一位是否为1.
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
	 * 让算法复杂度仅与1的个数有关.
	 * 算法复杂度进一步降低，
	 * 
	 * @param v
	 * @return
	 */
	private static int count3(int v){
		int num = 0;

		// 你可以使用1010和1001进行类比一下.
		while (v != 0) {
			v &= (v - 1);
			num++;
		}
		return num;	
	}
	
	// 方法4：把0~255中“1”的个数直接存放在数组中，v作为数组的下标，counttable[v]就是v中“1”的个数，
	// 算法的时间复杂度仅为O(1)。
}
