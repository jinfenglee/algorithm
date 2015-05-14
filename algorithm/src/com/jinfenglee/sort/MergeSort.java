package com.jinfenglee.sort;

/**
 * 
 * @author LJF
 * @version 1.0, 2013-12-04 09:18:35 <br />
 * <br />
 *          �鲢���� ԭ��,��ԭʼ����ֳ�����������,��ÿһ���������������,
 *          ��������������������ϲ�,�ϲ�����Ȼ����,ֱ��ȫ���ϲ���,�γ����������.
 * 
 * 
 *          ����������һ�¹鲢�����ʱ�临�Ӷȣ�һ�˹鲢��Ҫ��SR[1]��SR[n]�����ڵĳ���Ϊh���������н��������鲢��
 *          ��������ŵ�TR1[1]��TR1[n]�У�����Ҫ�������������е����м�¼ɨ��һ�飬��˺ķ�O(n)ʱ�䣬
 *          ������ȫ����������ȿ�֪�������鲢������Ҫ����.log2n.�Σ���ˣ��ܵ�ʱ�临�Ӷ�ΪO(nlogn)��
 *          �������ǹ鲢�����㷨����á����ƽ����ʱ�����ܡ�
 *          ���ڹ鲢�����ڹ鲢��������Ҫ��ԭʼ��¼����ͬ�������Ĵ洢�ռ��Ź鲢����Լ��ݹ�ʱ���Ϊlog2n��ջ�ռ䣬
 *          ��˿ռ临�Ӷ�ΪO(n+logn)�� ���⣬�Դ��������ϸ�о�������Merge��������if (SR[i]<SR[j])��䣬
 *          ���˵������Ҫ�����Ƚϣ���������Ծ����˹鲢������һ���ȶ��������㷨�� Ҳ����˵���鲢������һ�� �Ƚ�ռ���ڴ棬��ȴЧ�ʸ����ȶ����㷨��
 *          ʱ�临�Ӷ�O(nlogn) �ռ临�Ӷ� O(n+logn)���ȶ��㷨��
 * 
 */
public class MergeSort {
	public static void main(String[] args) {
		int[] a = { 6, 2};
		int[] sorted = new int[a.length];
		int len = sorted.length;
		
		merge_sort(a, 0, a.length, sorted);
		
		// ��forѭ���о����ز�Ҫʹ��a.length, ���Ǽ����ظ���������ĳ���
		for (int i = 0; i < len; i++) {
			if (sorted[i] > 0) {
				System.out.print(sorted[i]+" ");
			}
		}
		System.out.println();

	}

	static void merge(int[] unsorted, int first, int mid, int last, int[] sorted) {
		int i = first;
		int j = mid;
		int k = 0;
		while (i < mid && j < last) {
			if (unsorted[i] < unsorted[j]) {
				sorted[k++] = unsorted[i++];
			} else {
				sorted[k++] = unsorted[j++];
			}
		}

		while (i < mid) {
			sorted[k++] = unsorted[i++];
		}
		while (j < last) {
			sorted[k++] = unsorted[j++];
		}
		for (int v = 0; v < k; v++) {
			unsorted[first + v] = sorted[v];
		}	
	}

	// ע���ʱ��first�ĳ�ʼֵ��0, last��ʼֵΪ����ĳ���
	/**
	 * �ȷ��飬�ٺϲ���
	 * @param unsorted
	 * @param first
	 * @param last
	 * @param sorted
	 */
	static void merge_sort(int[] unsorted, int first, int last, int[] sorted) {
		if (first + 1 < last) {
			int mid = (first + last) / 2;
			
			merge_sort(unsorted, first, mid, sorted);
			merge_sort(unsorted, mid, last, sorted);
			merge(unsorted, first, mid, last, sorted);
		} else {
			
		}
	}
}
