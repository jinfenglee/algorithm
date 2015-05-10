package com.jinfenglee.search;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 在一个数组中，找出出现次数最多且数值最大的一个数并输出
 * 
 * @author LJF
 * 
 */
public class FindMaxMostNum {
	public static void main(String[] args) {
		Integer maxValue = Integer.MIN_VALUE;
		Integer maxKey = Integer.MIN_VALUE;
		
		int[] num = { 5, 2, 8, 5, 3,5, 5, 3, 3, 3, 1, 6, 1, 7, 1 };
		
		//K-V中, V代表数组中的元素出现的次数
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < num.length; i++) {
			if (map.containsKey(num[i])) {
				map.put(num[i],  map.get(num[i]) + 1);
			} else {
				map.put(num[i], 1); // 记出现1次
			}			
		}

		for (Entry<Integer, Integer> entry : map.entrySet()) {
			Integer key = entry.getKey();
			Integer value = entry.getValue();

			/**
			 * 排序好出现次数最大的元素，然后在其中找出键最大的
			 */
			if (value >= maxValue) {
				maxValue = value;
				if (key >= maxKey)
					maxKey = key;
			}
		}
	
		System.out.println("出现次数最多且数值最大的数:" + maxKey + "\n" + "出现的次数:" + maxValue
				+ "次");

	}
}
