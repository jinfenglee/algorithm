package com.jinfenglee.basic;

/**
 * 
 * @author LJF
 * 
 * 所有进制之间的转换
 * 
 * @date： 2013-11-27 20:49:30
 * 
 * 最重要的是要理解方法实现的原理，那才是最关键的！！！会调用只是会吃饭，但是不是会做饭，you know！
 *
 */
public class BinHexOct {
	public static void main(String[] args) {
		int n1 = 12;
		System.out.println(Integer.toBinaryString(n1));  //转换成其他进制也是同样，你要经吃该方法的实现过程。
		// 真的是非常好的.
		String a=Integer.valueOf("FFFF",16).toString();  
		System.out.println(a);
		
		System.out.println(Integer.toBinaryString(Integer.valueOf("FFFF",16)));
		
		Integer.valueOf("576",8).toString();  //八进制变成十进制
		
		// 傻瓜，怎么还是转换成八进制
		System.out.println(Integer.toOctalString(Integer.valueOf("576",8)));

		System.out.println(Integer.toBinaryString(Integer.valueOf("576",8)));  // bajinzhi转化成二进制
		
		
		String s=Integer.valueOf("0101",2).toString();  
		System.out.println(s);
		
		System.out.println(Integer.toOctalString(Integer.valueOf("1010",2)));  //二进制到八进制
		
		// 如果是数字的话，大写就不起作用了。  a--A
		System.out.println(Integer.toHexString(Integer.valueOf("1001",2)).toUpperCase());  //二进制到16进制   变成大写！
		
	}
}

