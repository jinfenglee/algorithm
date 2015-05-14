package com.jinfenglee.search;

import java.util.*;
/***
 * 二叉查找树 Binary Search Tree  时间复杂度 O(log n)
 * @author LJF 
 */
public class BinarySearchTree {
	
	class Node {
		Object key;
		Object value;
		Node left;
		Node right;

		Node(Object key, Object value, Node left, Node right) {
			this.key = key;
			this.value = value;
			this.left = left;
			this.right = right;
		}

		Node(Object key, Object value) {
			this(key, value, null, null);
		}

		public String toString() {
			return "(" + key + ":" + value + ")";
		}
	}
	
	Node root;
	private Comparator<Object> cmp;

	public BinarySearchTree(Comparator<Object> cmp) {
		this.cmp = cmp;
	}

	// 默认输出是中序遍历
	public String toString() {
		return inOrderString();
	}

	private String inOrderString() {
		StringBuilder sb = new StringBuilder();
		inOrder(sb, root);
		return sb.toString();
	}

	/**
	 * 中序遍历
	 * @param sb
	 * @param node
	 */
	private void inOrder(StringBuilder sb, Node node) {
		if (node.left != null)
			inOrder(sb, node.left);
		sb.append(node + " ");
		if (node.right != null)
			inOrder(sb, node.right);
	}

	private boolean insert(Node node) {
		if (root == null) {
			root = node;
			return true;
		}
		Node n = root;
		Node parent = n;
		boolean isLeft = false;
		while (n != null) {
			int result = cmp.compare(node.key, n.key);
			if (result == 0)
				return false;
			else if (result > 0) {
				parent = n;
				n = n.right;
				isLeft = false;
			} else { // result > 0
				parent = n;
				n = n.left;
				isLeft = true;
			}
		}
		if (isLeft)
			parent.left = node;
		else
			parent.right = node;
		return true;
	}
	
	/**
	 * 层序遍历二叉树
	 * @return
	 */
	private String levelOrderString() {
		if(root == null) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		Queue<Object> queue = new LinkedList<Object>();
		queue.add(root);
		Node node;
		while (null != (node = (Node) queue.poll())) {
			sb.append(node + " ");
			if (node.left != null)
				queue.add(node.left);
			if (node.right != null)
				queue.add(node.right);
		}
		return sb.toString();
	}

	/**
	 * 在二叉树中根据key 查找元素
	 * @param key
	 * @return
	 */
	public Node find(Object key) {
		Node n = root;
		while (n != null) {
			int result = cmp.compare(key, n.key);
			if (result == 0) {
				return n;	
			} else if (result > 0) {
				n = n.right;
			} else {
				n = n.left;
			}	
		}
		return null;
	}

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree(new Comparator<Object>() {
			public int compare(Object o1, Object o2) {
				if (!(o1 instanceof Integer) || !(o2 instanceof Integer))
					throw new RuntimeException("compare() parameter is not integer");
				return ((Integer) o1).compareTo((Integer) o2);
			}
		});
		
		bst.insert(bst.new Node(0, 0));
		bst.insert(bst.new Node(50, 50));
		bst.insert(bst.new Node(100, 100));
		
		bst.insert(bst.new Node(50,50));
		bst.insert(bst.new Node(39,17));
		bst.insert(bst.new Node(35,13));
		
		bst.insert(bst.new Node(43,42));	
		bst.insert(bst.new Node(45,84));
		bst.insert(bst.new Node(56,29));
		bst.insert(bst.new Node(69,39));
		bst.insert(bst.new Node(78,7));
		bst.insert(bst.new Node(84,51));
		System.out.println("中序遍历输出二叉树为:");
		System.out.println(bst);
		System.out.println(bst.find(39));
		System.out.println(bst.find(20));
		System.out.println("层序遍历二叉树：");
		System.out.println(bst.levelOrderString());
	}

}