package com.jinfenglee.programmingbeauty;

/**
 * 2.3 寻找发帖“水王” ，“水王”发的帖子数目超过帖子总数的一半，如何把“水王”找出来.
 * 
 * <p>
 * 大致思路：假设每个ID都有可能是水王，那么在遍历时这个水王就要遇到一种挑战，可能自己的帖子数是会增加的，
 * 也可能是遇到挑战的，帖子数要减少的。这样遍历下来，只有水王的帖子增加的减去遇到挑战的帖子数会是大于0的。
 * 其他任何帖子假设为水王时都是禁不起挑战的。  时间复杂度为O(n),非常好.
 * 
 * 相反，如果先排序，然后统计每个数出现的次数，就太傻瓜了，复杂度为O(N + N*log2N)。
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
	 * 该解法的策略就像是对战一样，就是加入你很牛，你就要经得起其他人的挑战，
	 * 如果不行，就要退出，换下一个，直到最后的胜者。
	 * @param array
	 * @return
	 */
	private static int findPostingMost(int[] array) {
		int result = 0;
		int times = 0;// 出现的次数
		
		for (int i = 0; i < array.length; i++) {
			// 如果次数等于0,重新指定结果
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
	 * 拓展问题：随着Tango的发展，管理员发现，“超级水王”没有了。统计结果表明，
	 * 有3个发帖很多的ID他们的发帖数目都超过了帖子总数目N的1/4。你能从发帖ID列表中快速找出他们的ID吗？
	 * 这个扩展问题还是上题所述的”对手”问题，不过这次是三个ID同时应战，但是这三个ID之间并不对战。
	 * 所以问题很快得到解决。
	 * 与上面的问题非常相似.
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
		System.out.println("发帖最多的三个人的 id是:");
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
	}
}
