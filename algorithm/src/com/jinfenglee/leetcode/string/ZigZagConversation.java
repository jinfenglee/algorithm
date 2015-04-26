package com.jinfenglee.leetcode.string;
/**
 * 
 * @author LJF
 * 
 * tip: uncompleted.
 *
 */
public class ZigZagConversation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

	public static String convert(String s, int nRows) {
		if(nRows<=1 || s.length()<=nRows) return s;  
        
        int len = s.length();  
        StringBuilder sb = new StringBuilder();  
        for(int i=0; i<nRows; i++) {  
            int j=i;  
            while(j<len) {  
                sb.append(s.charAt(j));  
                if(i!=0 && i!=nRows-1) {  
                    if(j + 2*(nRows-1-i) < len) sb.append(s.charAt(j + 2*(nRows-1-i) ) );  
                }  
                j += 2*(nRows-1);  
            }  
        }  
        return sb.toString(); 
	}

}
