package com.jinfenglee.tree;

/**
 * 二叉树的节点
 * 
 * @author li.jf
 * @date 2017-10-25
 *
 */
public class BinaryTreeNode {
	BinaryTreeNode left;
	BinaryTreeNode right;
	int value;

	public BinaryTreeNode(int value) {
		this.value = value;
		left = null;
		right = null;
	}
}
