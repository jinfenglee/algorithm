package com.jinfenglee.programmingbeauty;

/**
 * 求数组中的最大数和最小数(使用分治的方法解决)，在网上找的一种解决办法，思路很不错.
 * 
 * @author Administrator
 * @Date 2014-06-10
 */
public class _2_10_FindMaxMinNum_2 {
	public static void main(String[] args) {
		 int[] arr =  {12, 5, 9, 8, 2, 14, 15, 8, 7 };
		 _2_10_FindMaxMinNum_2.function3(arr, 0 , arr.length - 1).print(); 
	}
	
	private static Pair function3(int[] arr, int begin, int end) {  
        Pair pair = null;  
        
        int max = 0;  
        int min = 0;  
        
		if (begin + 1 >= end) {
			max = arr[begin] > arr[end] ? arr[begin] : arr[end];
			min = arr[begin] < arr[end] ? arr[begin] : arr[end];
		} else {
			int middle = (begin + end + 1) / 2;
			Pair left = function3(arr, begin, middle);
			Pair right = function3(arr, middle + 1, end);

			max = left.getMax() > right.getMax() ? left.getMax() : right.getMax();
			min = left.getMin() < right.getMin() ? left.getMin() : right.getMin();
		}
        
        pair = new Pair(max, min);           
        return pair;  
    }  
}

class Pair {
	private int max;
	private int min;

	public Pair(int max, int min) {
		this.max = max;
		this.min = min;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}
	public void print() {
		System.out.println("最小值:" + this.min + ",最大值：" + this.max );
	}
	
}

