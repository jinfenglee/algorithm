package com.jinfenglee.programmingbeauty;

/**
 * 求数组最长递增子序列O(n*logn)
 * <p> 思路来自于：http://blog.sina.com.cn/s/blog_3f297c5c0101aoq1.html 表示感谢~
 * 
 * @author LJF
 * @date 2014-07-16 06:48:29
 * 
 */
public class _2_16_2_maxIncSeq {
	public static void main(String[] args) {
		
		int[] a = { 1, -1, 2, -3, -2, -5,1, 4 };   //  {-3,-2,1,4}
		int result = lis2(a, a.length);
		System.out.println(result);
	}
	
	/**
	 * 复杂度为O(nlog n)
	 * 其思想是设一个辅助数组temp,temp[i]表示长度为i+1（也就是程序中的len）的最长递增子序列的最小末尾，
	 * 则显然temp是有序的。遍历原数组中的每一个元素，对于每个元素key，若比temp数组中当前最后一个元素大，
	 * 则直接插入temp数组，表示最长递增子序列长度可以增加一，新的LIS以这个元素结尾；
	 * 否则要么temp中已包含key这个元素，则不做任何操作，要么temp中的数全部大于这个元素，
	 * 则key取代temp[0]成为长度为1的LIS的结尾元素，要么必然存在temp[j]<key<temp[j+1]，
	 * 这时key应取代temp[j+1]成为长度为j+2的LIS的结尾元素，对于后两种情况（temp中的数全部大于
	 * 这个元素或temp[j]<key<temp[j+1]），
	 * key实际是取代了temp中比key大的和key最接近的元素。最后temp数组的长度(len)即为所求。
	 * @param arr
	 * @param size 数组的大小
	 * @return 
	 */
	static int lis2(int[] arr, int size) {
		int temp[] = new int[size];
		int i, pos;
		temp[0] = arr[0];
		int len = 1;  // 用于标识temp数组中的元素个数
		
		for (i = 1; i < size; i++) {
			if (arr[i] > temp[len - 1]) // 如果大于temp中最大的元素，则直接插入到temp数组末尾
			{
				temp[len] = arr[i];
				len++;
			} else {
				pos = binarySearch(temp, len, arr[i]); // 二分查找需要插入的位置
				temp[pos] = arr[i];
			}
		} 
		
		return len;
	}
	
	
	
	/**
	 * 修改后的二分查找，查找成功时返回key所在的位置，不成功时返回比key大的和key最接近的
	 * 元素所在的位置，即key应该插入的位置.
	 * @param data
	 * @param len
	 * @param key
	 * @return
	 */
	static int binarySearch(int[] data, int len, int key) {
		int low = 0;
		int high = len - 1;
		int mid;

		while (low <= high) {
			mid = (low + high) / 2;
			
			if (data[mid] > key)
				high = mid - 1;
			else if (data[mid] < key)
				low = mid + 1;
			else
				return mid;
		}
		return low;
	}

}
