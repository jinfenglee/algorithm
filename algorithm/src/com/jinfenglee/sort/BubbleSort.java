package com.jinfenglee.sort;


/**
 * BubbleSort impl
 * 
 * @author LJF
 * @Date 2014-06-03 22:09:25
 * 
 */
public class BubbleSort {
	public static void main(String[] args) {
//		int a[] = { 12, 66, -1, 55, 7679, 4534, 6786, 345 };
		int a[] = { 5, 4, 6, 3, 7, 1 };
		
//		bubblesort(a);
//		bubbleSort_1(a);
		System.out.println("-----------------------------------");
//		bubbleSort_2(a);
		System.out.println("-----------------------------------");
		bubbleSort_3(a, a.length);
	}

	/**
	 *  M1：常规方法 ,平均 O(n^2)
	 * @param a
	 */
//	private static void bubblesort(int[] a) {
//		for (int i = 0; i < a.length; i++) {
//			for (int j = 0; j < i; j++) {
//				if (a[i] > a[j]) {
//					int temp = a[i];
//					a[i] = a[j];
//					a[j] = temp;
//				}
//			}
//			for (int k = 0; k < a.length; k++) {
//				System.out.print(a[k] + " ");
//			}
//			System.out.println();
//		}
//	}
	
	/**
	 * 常规写法1
	 * @param a
	 */
	private static void bubbleSort_1(int[] a) {
		for (int i = a.length -1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (a[j] > a[j + 1]) {
					int temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
			}

			for (int k = 0; k < a.length; k++) {
				System.out.print(a[k] + " ");
			}
			System.out.println();
		}
	}
	
	/**
	 * 常规写法2
	 * @param a
	 */
	private static void bubbleSort_2(int[] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length - i - 1; j++) {
				if (a[j] > a[j + 1]) {
					int temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
			}

			for (int k = 0; k < a.length; k++) {
				System.out.print(a[k] + " ");
			}
			
			System.out.println();
		}
	}
	
	/**
	 * 设置一个标记，如果一趟发生交换，则为true，否则为false。如果有一趟没有发生交换，说明排序已经完成。
	 * @param a 
	 * @param length 数组长度
	 */
	private static void bubbleSort_3(int[] a, int length) { 
        boolean flag = true;
        while (flag) {
        	 for(int i=0; i< length; i++) {
             	System.out.print(a[i] + " " );
             }
             System.out.println();
            flag = false;
            for (int j = 1; j < length; j++) {
                if (a[j - 1] > a[j]) {
                    int temp = a[j - 1];
                    a[j - 1] = a[j];
                    a[j] = temp;
                    flag = true;
                }
            }
        }
    }
	
	
	
}
