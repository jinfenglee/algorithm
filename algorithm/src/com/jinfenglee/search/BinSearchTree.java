package com.jinfenglee.search;

/**
 * 二叉查找树的各项操作。
 * @author lijinfeng
 *
 */
public class BinSearchTree {
	public class Node {
		Node left;
		Node right;
		int value;

		public Node(int value) {
			this.value = value;
			left = null;
			right = null;
		}
	}

	private Node root;

	public BinSearchTree() {
		root = null;
	}

	public BinSearchTree(int[] arr) {
		for (int i : arr) {
			insert(i);
		}
	}

	private void insert(int value) {
		root = insert(root, value);

	}

	/**
	 * 插入节点
	 * 
	 * @param root
	 * @param value
	 * @return
	 */
	private Node insert(Node root, int value) {
		if (root == null) {
			root = new Node(value);
		} else if (value <= root.value) {
			if (root.left == null) {
				root.left = new Node(value);
			} else {
				insert(root.left, value);
			}

		} else {
			if (root.right == null) {
				root.right = new Node(value);
			} else {
				insert(root.right, value);
			}
		}

		return root;

	}

	// 中序遍历
	public void inOrder(Node tree) {
		if (tree != null) {
			inOrder(tree.left);
			System.out.println(tree.value + " ");
			inOrder(tree.right);
		}
	}

	// 前序遍历
	public void preOrder(Node tree) {
		if (tree != null) {
			System.out.println(tree.value + " ");
			preOrder(tree.left);
			preOrder(tree.right);
		}
	}

	// 后序遍历
	public void postOrder(Node tree) {
		if (tree != null) {
			postOrder(tree.left);
			postOrder(tree.right);
			System.out.println(tree.value + " ");

		}
	}
	
	/**
	 * 递归实现查找
	 * @param tree
	 * @param value
	 * @return
	 */
	public Node search(Node tree,int value) {
		if(tree == null || tree.value == value) {
			return tree;
		}
		if(value <= tree.value) {
			return search(tree.left, value);
		} else {
			return search(tree.right,value);
		}
		
	}
	
	/**
	 * 非递归实现查找
	 * @param tree
	 * @param value
	 * @return
	 */
	public Node searchNoRecrusion(Node root, int value) {
		while(root != null && root.value != value) {
			if(value<=root.value) {
				root = root.left;
			} else {
				root = root.right;
			}
		}
		if(root == null) {
			throw new NullPointerException("NullPointer" + value);
		} else {
			return root;
		}
	}
	
	/**
	 * 最小值节点
	 * @param root
	 * @return
	 */
	public Node minMode(Node root){
		while(root.left != null) {
			root = root.left;
		}
		
		return root;
	}
	
	/**
	 * 最大值节点
	 * @param root
	 * @return
	 */
	public Node maxNode (Node root) {
		while(root.right != null) {
			root = root.right;
		}
		return root;
	}
	
	public Node insertNode(Node root, Node unKnown) {
		if(root == null) {
			return new Node(unKnown.value);
		}
		
		if(unKnown.value <= root.value) {
			root.left = insertNode(root.left, unKnown);
		} else {
			root.right = insertNode(root.right, unKnown);
		}
		
		return root;	
	}
	
	public Node remove(Node root, int value) {
		if(root == null) {
			return root;
		}
		
		if(value < root.value) {
			root.left = remove(root.left, value);
		} else if(value > root.value) {
			root.right = remove(root.right, value);
		} else if(root.left != null && root.right != null) {
			root.value = minMode(root.right).value;
			root.right = remove(root.right, root.value);
		} else {
			if(root.left !=null) {
				root = root.left;
			} else {
				root = root.right;
			}
		}
		return root;
	}


}
