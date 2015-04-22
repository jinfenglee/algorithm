package com.jinfenglee.programmingbeauty;

/**
 * 子数组乘积的最大值
 * 给定一个长度为N的整数数组，只允许用乘法不允许用除法，计算N-1个数组合的乘积最大的一组，
 * 并写出算法的时间复杂度。 
 *
 * @author Administrator
 * @date 2014-07-08 22:03:12
 *
 */
public class _2_13_01_SubArrayMaxMultiply {
	public static void main(String[] args) {

		int[] a = { 2, 3, 6, 1, 8 };
		long result=getMaxSubMultiply(a);
		System.out.println(result);

		_2_13_01_SubArrayMaxMultiply arrayMaxMultiply = new _2_13_01_SubArrayMaxMultiply();
		System.out.println(arrayMaxMultiply.max(a));

	}

	/**
	 * M1: 时间复杂度为O(n^2),不好。
	 * 
	 * @param data
	 * @return
	 */
	public static long getMaxSubMultiply(int[] data) {

		long result = Long.MIN_VALUE;
		int length = data.length;

		for (int i = 0; i < length; i++) {
			long r = 1L;

			for (int j = 0; j < length; j++) {
				if (j != i) {
					r *= data[j];
				}
			}

			if (result < r) {
				result = r;
			}
		}
		return result;
	}

	/**
	 * 求出所有子数组，然后去比较子数组的大小 时间复杂度为 O(n)
	 * 
	 * @param a
	 * @param b  N-1 个元素乘积所组成的数组.
	 * @param len
	 *            数组的长度
	 */
	private void makeArray(int a[], int b[], int len) {
		int i;
		b[0] = 1;
		for (i = 1; i < len; ++i) {
			b[0] *= a[i - 1];  // b[0]中保存a[0]到a[i-1]的乘积
			b[i] = b[0]; 	   // b[i] = a[0]*a[1]*...*a[i-1]
		}
		// 经过第一个for循环后
		// b[1]=a[0]     
		// b[2]=a[0]*a[1]        
		// b[3]=a[0]*a[1]*a[2]
		// b[4]=a[0]*a[1]*a[2]*a[3] 

		b[0] = 1;
		for (i = len - 2; i > 0; --i) {
			b[0] *= a[i + 1]; 	// b[0] = a[i+1]*a[i+2]...*a[len-1]，即b[0]中保存a[i+1]到a[len-1]的乘积
			b[i] *= b[0];  // b[i] = a[0]*a[1]*...*a[i-1]*a[i+1]*...*a[len-1]
			               // (上面的for循环中已经计算出了b[1]、b[2]、b[3]...)
			// 下面的一个for循环写得真的是很高级，  就是为了凑成  b[i] = a[0]*a[1]*...*a[i-1]*a[i+1]*...*a[len-1]
		}
		b[0] *= a[1]; // 注意这一点，经过上面for循环后，b[0]= a[2]*...   ，所以需要再乘上b[1]
	}

	/**
	 * M2： 找到数组中的最大元素
	 * @param a
	 * @return
	 */
	public int max(int[] a) {
		int max;
		int length = a.length;                                                                   
		int[] b = new int[length];  // 数组b是取得n-1个元素乘积组成的数组

		makeArray(a, b, length);    // 求出所有子数组
		max = b[0];

		// 找出最大的子数组，并赋值给max
		for (int i = 1; i < length; i++) {
			if (max < b[i]){
				max = b[i];
			}		
		}

		return max;
	}
}
