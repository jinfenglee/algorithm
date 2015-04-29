package com.jinfenglee.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 使用最快的方式合并两个数组
 * 使用了API，偷懒.
 * 
 * @author LJF
 * @date 2014-09-17 21:53:19
 * 
 */
public class MergeArray {
	/*
	 * 当然也可以使用System.arraycopy() 方法， 创建新的数组(长度为两个待合并数组的大小之和)
	 */
	public static void main(String[] args) {
		String[] a = { "0", "1", "2" };
		String[] b = { "0", "1", "2" };

		List list1 = Arrays.asList(a);
		List list2 = Arrays.asList(b);
		List result = new ArrayList();
		result.addAll(list1);
		result.addAll(list2);

		System.out.println(result);
	}
}