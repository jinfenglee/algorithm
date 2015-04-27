package com.jinfenglee.basic;

import java.util.Arrays;

/**
 * 如何用最快的方式把两个数组合并成一个
 * 
 * @author LJF
 * @date 2015-01-27 22:37:33
 * 
 */
public class ArrayConcat {
	public static void main(String[] args) {
		String a[] = { "12a", "test" };
		String b[] = { "aeeea", "2erer" };
		concat(a, b);
		concat1(a, b);
	}

	/**
	 * 使用系统的arraycopy()方法.
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	private static String[] concat(String[] a, String[] b) {
		String[] c = new String[a.length + b.length];
		System.arraycopy(a, 0, c, 0, a.length);
		System.arraycopy(b, 0, c, a.length, b.length);
		return c;
	}

	public static <T> T[] concat(T[] first, T[] second) {
		// Arrays.copyof() 直接传回一个新的数组对象，这个新数组中包含复制的内容
		T[] result = Arrays.copyOf(first, first.length + second.length);
		System.arraycopy(second, 0, result, first.length, second.length);
		return result;
	}

	/**
	 * 多个数组合并
	 * 
	 * @param <T>
	 * @param first
	 * @param rest
	 * @return
	 */
	public static <T> T[] concatAll(T[] first, T[]... rest) {
		int totalLength = first.length;
		for (T[] array : rest) {
			totalLength += array.length;
		}
		T[] result = Arrays.copyOf(first, totalLength);
		int offset = first.length;
		for (T[] array : rest) {
			System.arraycopy(array, 0, result, offset, array.length);
			offset += array.length;
		}
		return result;
	}

	/**
	 * 使用Arrays.newInstance()来生成数组
	 * 
	 * @param <T>
	 * @param a
	 * @param b
	 * @return
	 */
	private static <T> T[] concat1(T[] a, T[] b) {
		final int alen = a.length;
		final int blen = b.length;
		if (alen == 0) {
			return b;
		}
		if (blen == 0) {
			return a;
		}
		
		@SuppressWarnings("unchecked")
		final T[] result = (T[]) java.lang.reflect.Array.newInstance(a
				.getClass().getComponentType(), alen + blen);
		System.arraycopy(a, 0, result, 0, alen);
		System.arraycopy(b, 0, result, alen, blen);
		return result;
	}

}
