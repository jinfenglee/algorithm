package com.jinfenglee.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 输出数组中两个元素的下标，使他们的和等于给定的值.
 * 
 * @author LJF
 * @date 2014-10-25 16:18:13
 * 
 */
public class TwoSum {
	public static void main(String[] args) {
		int[] nums = { 2, 7, 11, 15 };

		int a[] = new int[2];
		a = twoSum(nums, 9);
		for (int i = 0; i < a.length; i++) {
			System.out.print("index" + a[i]+" ");
		}
	}

	private static int[] twoSum(int[] numbers, int target) {
		int[] result = new int[2];
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < numbers.length; i++) {
			map.put(numbers[i], i);
		}

		for (int i = 0; i < numbers.length; i++) {
			int first = numbers[i];
			Integer second = map.get(target - first);
			if (second != null && i < second) {
				result[0] = i + 1;
				result[1] = second + 1;
				break;
			}
		} 
		return result;
	}
}
