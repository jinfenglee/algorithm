package com.jinfenglee.programmingbeauty;

/**
 * 2.3 Ѱ�ҷ�����ˮ���� ����ˮ��������������Ŀ��������������һ�룬��ΰѡ�ˮ�����ҳ���.
 * 
 * <p>
 * ����˼·������ÿ��ID���п�����ˮ������ô�ڱ���ʱ���ˮ����Ҫ����һ����ս�������Լ����������ǻ����ӵģ�
 * Ҳ������������ս�ģ�������Ҫ���ٵġ���������������ֻ��ˮ�����������ӵļ�ȥ������ս�����������Ǵ���0�ġ�
 * �����κ����Ӽ���Ϊˮ��ʱ���ǽ�������ս�ġ�  ʱ�临�Ӷ�ΪO(n),�ǳ���.
 * 
 * �෴�����������Ȼ��ͳ��ÿ�������ֵĴ�������̫ɵ���ˣ����Ӷ�ΪO(N + N*log2N)��
 * @author Administrator
 * 
 */
public class _2_03_PostingMost {

	public static void main(String[] args) {
//		int[] array = { 6, 2, 1, 7, 8, 1, 1, 1, 1, 4, 1 };
		int[] array = {1,2,1,2,2,3,2,2};
		System.out.println(findPostingMost(array));
		int[] array2={1,1,1,5,6,5,5,3,3,3};
		findPostingMostThree(array2);
	}

	/**
	 * �ýⷨ�Ĳ��Ծ����Ƕ�սһ�������Ǽ������ţ�����Ҫ�����������˵���ս��
	 * ������У���Ҫ�˳�������һ����ֱ������ʤ�ߡ�
	 * @param array
	 * @return
	 */
	private static int findPostingMost(int[] array) {
		int result = 0;
		int times = 0;// ���ֵĴ���
		
		for (int i = 0; i < array.length; i++) {
			// �����������0,����ָ�����
			if (times == 0) {
				result = array[i];
				times = 1;
				
			} else {
				if (result == array[i]) {
					++times;
				} else {
					--times;
				}
			}
		}
//		System.out.println(times);
		return result;
	}
	/**
	 * ��չ���⣺����Tango�ķ�չ������Ա���֣�������ˮ����û���ˡ�ͳ�ƽ��������
	 * ��3�������ܶ��ID���ǵķ�����Ŀ����������������ĿN��1/4�����ܴӷ���ID�б��п����ҳ����ǵ�ID��
	 * �����չ���⻹�����������ġ����֡����⣬�������������IDͬʱӦս������������ID֮�䲢����ս��
	 * ��������ܿ�õ������
	 * �����������ǳ�����.
	 * @param array
	 */
	private static void findPostingMostThree(int[] array) {
		int result[] = new int[3];
		int times[] = new int[3];

		for (int i = 0; i < array.length; i++) {
			if (result[0] == array[i]) {
				times[0]++;
			} else if (result[1] == array[i]) {
				times[1]++;
			} else if (result[2] == array[i]) {
				times[2]++;
			} else if (times[0] == 0) {
				times[0] = 1;
				result[0] = array[i];
			} else if (times[1] == 0) {
				times[1] = 1;
				result[1] = array[i];
			} else if (times[2] == 0) {
				times[2] = 1;
				result[2] = array[i];
			} else {
				times[0]--;
				times[1]--;
				times[2]--;
			}
		}
		System.out.println("�������������˵� id��:");
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
	}
}
