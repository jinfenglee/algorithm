package com.jinfenglee.basic;


/**
 * 有一个很长的字符串,均是大小写字母（大小写不区分），求出每个字母在这个字符串中出现的次数。
 * @author li.jf
 * @date 2015-08-01
 *
 */
public class AlphaTimes {
	private static String str = "aAWQELA";
	 private static int[] alphatTimesArr = new int[26];

	    public static void main(String[] args) {
	        AlphabeTotal(str);
	        print(alphatTimesArr);
	    }
	
	/**
	 * 这个方法实际上每个字符减去'A'（或者'a'）,得到一个值，统计这个值出现的次数.
	 * @param str
	 */
	private static void AlphabeTotal(String str) {
        char charTmp;

        for (int i = 0; i < str.length(); i++) { 
        	charTmp = str.charAt(i);
        	
            if(charTmp >='A' && charTmp <= 'Z') {
            	alphatTimesArr[charTmp - 'A']++;
            } else if(charTmp >='a' && charTmp <= 'z') {
            	alphatTimesArr[charTmp - 'a']++;
            }
        }
    }

	/**
	 * output
	 * @param a
	 */
    private static void print(int[] a) {
    	System.out.println("大小写不区分出现次数如下：");
        for (int i = 0; i < a.length; i++) {
            char c = (char) ('A' + i);
            if(a[i] != 0) {
            	 System.out.println(c+ " appear times:" + a[i] + " ");
            }
        }
    }
    
    /**
     * Summary:
     * 这实际上是一个很简单的问题，就是使用字母和ASCII对应表.
     * 试想一下：如果这个问题扩展到求任何字母在字符串中出现的次数，难道我们要创建一个比较大的数组，我们可以使用
     * HashMap,实现起来也比较简单。
     */


}
