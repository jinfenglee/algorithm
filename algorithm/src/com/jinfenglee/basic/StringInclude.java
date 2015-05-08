package com.jinfenglee.basic;

/**
 * String Include (no using Java API like IndexOf() or contains() )
 * 
 * @author LJF
 * @date 2014-09-22 23:36:01
 */
public class StringInclude {
	public static void main(String[] args) {
		String s1 = "12346";
		String s2 = "2345";
		if (s1.length() >= s2.length())
			System.out.println(myContains(s1, s2));
		else
			System.out.println(myContains(s1, s2));
		
		// System.out.println(s1.contains(s2));
		
		String s3 = "advnnbn";
		String s4 = "vnnb";
		String s = compareDoubleString(s3, s4);
		System.out.println(s);
	}

	private static boolean myContains(String s1, String s2) {
		char[] a = s1.toCharArray();
		char[] b = s2.toCharArray();
		int j;
		for (int i = 0; i < a.length - b.length; i++) {
			for (j = 0; j < b.length; j++) {
				if (a[i] != b[j]) {
					break;
				}
			}
			
			if (j == b.length) 
				return true;
		}
		return false;
	}
	
	 public static String compareDoubleString(String source, String target) {
	        // 分别获取两个字符串的长度，因为后面会用到
	        int sourceLength = source.length();
	        int targetLength = target.length();
	        // 获取目标的第一个字符
	        char firstTargetChar = target.charAt(0);
	        // 最多比较的次数
	        int max =  sourceLength - targetLength;
	        
	        // 如果第一个不相等，那么一直找到相等的那一个或者找完都不能找到
	        int sourceOffset = -1;
	        while (++sourceOffset < max
	                && source.charAt(sourceOffset) != firstTargetChar) {
	        }
	        if (sourceOffset <= max) {
	            // 设置新的源索引
	            int newSourceOffset = sourceOffset + 1;
	            // 剩余的比较长度，也就是在offset上增加targetLength
	            int leaveLength = newSourceOffset + targetLength - 1;
	            int targetOffset = 1;
	            
	            // 连续的比较，条件不符合的时候跳出
	            for (; newSourceOffset < leaveLength
	                    && source.charAt(newSourceOffset) == target
	                            .charAt(targetOffset); newSourceOffset++, targetOffset++)
	                ;
	            if (newSourceOffset == leaveLength) {
	                return "包含：" + source + "包含" + target + "字符串!";
	            }
	        }
	        return "不包含：" + source + "不包含" + target + "字符串!";
	    }
	
	
	
}
