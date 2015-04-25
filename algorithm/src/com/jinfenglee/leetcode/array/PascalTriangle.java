package com.jinfenglee.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 巴斯卡三角形
 * 
 * @author LJF
 * @date 2014-10-29 22:08:08
 * 
 */
public class PascalTriangle {
	public static void main(String[] args) {
		System.out.println(generate(5));
	}

	public static List<List<Integer>> generate(int numRows) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		ArrayList<List<Integer>> resultList = new ArrayList<List<Integer>>();
		for (int i = 0; i < numRows; i++) {
			ArrayList<Integer> tempList = new ArrayList<Integer>();
			tempList.add(1);
			if (i > 0) {
				// i = 1 时下面的for循环不会执行
				for (int j = 0; j < resultList.get(i - 1).size() - 1; j++) {
					// 头上的两个元素之和
					tempList.add(resultList.get(i - 1).get(j) + resultList.get(i - 1).get(j + 1));
				}
					
				tempList.add(1);
			}
			resultList.add(tempList);
		}
		return resultList;
	}

}
