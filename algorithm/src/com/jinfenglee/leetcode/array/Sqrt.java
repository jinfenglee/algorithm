package com.jinfenglee.leetcode.array;

public class Sqrt {
	public static void main(String[] args) {
		System.out.println(sqrt(12));
	}

	private static int sqrt(int x) {
		if (x == 0) {
			return 0;
		}
			
		double pre;
		double cur = 1;
		do {
			pre = cur;
			cur = x / (2 * pre) + pre / 2.0;
		} while (Math.abs(cur - pre) > 0.00001);
		
		return (int) cur;

	}
	
//	int sqrt(int x) {
//
//	    if (x <=0 ) return 0;
//	    
//	    //the sqrt is not greater than x/2+1
//	    int e = x/2+1;
//	    int s = 0;
//	    // binary search
//	    while ( s <= e ) {
//	        int mid = s + (e-s)/2;
//	        long long sq = (long long)mid*(long long)mid;
//	        if (sq == x ) return mid;
//	        if (sq < x) {
//	            s = mid + 1;
//	        }else {
//	            e = mid - 1;
//	        }
//	    }
//	    return e; 
//	        
//	}

}
