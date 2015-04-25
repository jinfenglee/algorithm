package com.jinfenglee.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ��һ��û���ظ�Ԫ�ؼ��ϵ������Ӽ�
 * 
 * @author LJF
 * @date 2014-11-06 21:04:20
 * 
 */
public class Subsets {
	public static void main(String[] args) {
		int[] a = { 1, 2 };
		System.out.println(subsets(a));
	}

	public static List<List<Integer>> subsets(int[] S) {
		ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> r = new ArrayList<Integer>();
		result.add(r); // �Ӽ�����һ����{}
		if (S == null || S.length == 0) {
			return result;
		}
		Arrays.sort(S);

		int[] position = new int[S.length + 1]; // ��Ϊ����S ���±�

		for (int len = 1; len <= S.length; len++) {
			Arrays.fill(position, -1);
			int index = 1;
			while (index >= 1) {
				if (position[index] == -1) {
					position[index] = position[index - 1] + 1;
				} else {
					position[index]++;
				}

				if (position[index] < S.length) {
					if (index == len) {
						ArrayList<Integer> rr = new ArrayList<Integer>();
						for (int i = 1; i <= len; i++) {
							rr.add(S[position[i]]);
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
