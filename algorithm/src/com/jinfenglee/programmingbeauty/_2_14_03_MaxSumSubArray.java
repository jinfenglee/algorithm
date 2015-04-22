package com.jinfenglee.programmingbeauty;

/**
 * TODO:����������֮�͵����ֵ��M3:��̬�滮����O(N)
 *  ���飺A[0], ���һ������(a[i]...a[j]),֮��Ĺ�ϵ��3�������
 * 1��0=i=j,a[0]��������������һ��. 
 * 2��0=i<j,����һ����a[0]��ʼ. 
 * 3��0<i, ����һ����a[0]û�й�ϵ.
 * 
 * @author LJF
 * @date 2014-07-12
 * 
 */
public class _2_14_03_MaxSumSubArray {
	public static void main(String[] args) {
		int[] array = { 3, -2, 3, 10, -4, 7, 2, -5 };
		// int arr[] = {4,-3,5,-2,-1,2,6,-2};
		System.out.println("Max sum: " + maxSum(array, array.length));
		System.out.println("Max sum: " + maxSum2(array, array.length));
	}
	/**
	 * ��̬�滮��������֮�����ֵ
	 * @param arr
	 * @param n
	 * @return  ������֮�����ֵ.
	 */
	private static int maxSum(int[] arr, int n) {
		int i;
		int All[] = new int[n];
		int Start[] = new int[n];

		/**
		 * All[1] ��ʾ(arr[1],arr[2],....arr[n-1])������һ������֮�ͣ����Բ�����arr[1]
		 */
		All[n - 1] = arr[n - 1];  
		Start[n - 1] = arr[n - 1];  // ����arr[n-1] ������һ������ΪStart[n-1];
		
		// ������ĩβ��ǰ������ֱ��������.
		for (i = n - 2; i >= 0; i--) {
			Start[i] = max(arr[i], arr[i] + Start[i + 1]);
			All[i] = max(All[i + 1], Start[i]);
		}
		return All[0];
	}

	static int max(int x, int y) {
		return (x > y) ? x : y;

	}
	
	
	/**
	 * ���Լ����Ż���û�б�Ҫʹ�ö������������ , \
	 * ��Ϊstart[k+1] ֻ���ڼ��� Start[k]ʱ������.   
	 * All[k+1]ֻ�ڼ���All[k]ʱ������.
	 * 
	 * �ռ临�ӶȽ�ΪO(1)
	 * @param arr
	 * @param n
	 * @return
	 */
	private static int maxSum2(int[] arr, int n) {
		int i;

		int nAll = arr[n - 1];
		int nStart = arr[n - 1]; 
		
		for (i = n - 2; i >= 0; i--) {
			nStart = max(arr[i], arr[i] + nStart);
			nAll = max(nStart, nAll);
		}
		return nAll;
	}
	
}
