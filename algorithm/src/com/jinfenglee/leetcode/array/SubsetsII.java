package com.jinfenglee.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * 求一个集合的子集(集合中可以包含重复元素)
 * @author LJF
 * @date 2014-11-06 
 */
public class SubsetsII {
	
	public static void main(String[] args) {
		int[] a = {10,2,2};
		System.out.println(subsets(a));
	}
	public static List<List<Integer>> subsets(int[] num) {
		ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> r = new ArrayList<Integer>();
		result.add(r);   // 子集中有一个是{}
		if (num == null || num.length == 0) {
			return result;
		}
		Arrays.sort(num);
		
		int[] position = new int[num.length + 1];
		
		for (int len = 1; len <= num.length; len++) {
			Arrays.fill(position, -1);
			int index = 1;
			while (index >= 1) {
				int pre = position[index];
				
				if (position[index] == -1) {
					position[index] = position[index - 1] + 1;
				} else {
					position[index]++;
				}
				
				if (pre != -1) {
					while (position[index] < num.length
							&& num[position[index]] == num[pre]) {
						position[index]++;
					}
				}
				
				
				if (position[index] < num.length) {
					if (index == len) {
						ArrayList<Integer> rr = new ArrayList<Integer>();
						for (int i = 1; i <= len; i++) {
							rr.add(num[position[i]]);
						}
						result.add(rr);
					} else {
						position[index + 1] = -1;
						index++;
					}
				} else {
					index--;
				}
			}
		}
		
		return result;
	}

}
