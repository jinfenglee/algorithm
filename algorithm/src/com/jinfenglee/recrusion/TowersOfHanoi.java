package com.jinfenglee.recrusion;

/**
 * 
 * towers of Hanoi
 * 
 * @author LJF ,2013-12-02 13:32:52 <br />
 * <br />
 *         使用递归算法打印 Hanoi Tower
 * 
 *         每次只能移动立柱上面的一个盘子
 *
 */
public class TowersOfHanoi {

	private int totalDisks;
	private int count;

	public TowersOfHanoi(int numDisks) {
		totalDisks = numDisks;
		count = 0;
	}

	public void solve() {
		moveTower(totalDisks, 1, 3, 2);
	}

	/**
	 * 汉诺塔赌鬼实现原理
	 * 
	 * @param numDisks
	 *            盘子数
	 * @param start
	 *            开始柱子
	 * @param end
	 *            结束柱子
	 * @param temp
	 *            经由柱子
	 */
	private void moveTower(int numDisks, int start, int end, int temp) {
		if (numDisks == 1) {
			moveOneDisk(start, end);
		} else {
			moveTower(numDisks - 1, start, temp, end);
			moveOneDisk(start, end);
			moveTower(numDisks - 1, temp, end, start);
		}
	}

	private void moveOneDisk(int start, int end) {
		count = count + 1;
		System.out.println("Move one disk from " + start + " to " + end
				+ " - total Move " + count);
	}

	public static void main(String[] args) {
		TowersOfHanoi tower = new TowersOfHanoi(3);

		// 这儿可能是因为只写在一个 .java 文件中，可以直接使用类名TowersOfHanoi.方法 来完成目标
		tower.solve();
		System.out.println("total move:" + tower.count);
	}
}
