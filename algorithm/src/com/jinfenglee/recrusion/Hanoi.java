package com.jinfenglee.recrusion;
/**
 * 汉诺塔（经典的递归算法） reCrusion <br/>
 * 该算法结论：当有n个盘子的时候，移动的次数为2^n -1.
 * (2,A,C,B) -->  (1,A,B,C) + (1,C,A,B)
 * 
 * @author LJF
 * @date 2015-02-09 21:39:54
 * 
 */
public class Hanoi {
	public static void main(String[] args) {
		hanoi(2, 'A', 'B', 'C');
	}
	/**
	 * Move sheet form A to C via B(temp)
	 * @param n
	 * @param A
	 * @param B
	 * @param C
	 */
	private static void hanoi(int n, char A, char B, char C) {
		if (n == 1) {
			System.out.println("Move sheet " + n + " from " + A + " to " + C);
		} else {
			hanoi(n - 1, A, C, B);
			System.out.println("Move sheet " + n + " from " + A + " to " + C);
			hanoi(n - 1, B, A, C);
		}
	}
}
