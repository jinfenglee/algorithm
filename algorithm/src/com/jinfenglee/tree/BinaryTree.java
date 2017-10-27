package com.jinfenglee.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的各项操作: 查找,是否存在某节点，插入，删除， 节点数，最大节点,最小节点,节点最大最小值，层数， 遍历（前,中，后，层）
 * 
 * @author li.jf
 * @date 2017-10-25
 */
public class BinaryTree {
	private BinaryTreeNode root;

	public BinaryTree() {
		root = null;
	}

	public BinaryTree(int[] arr) {
		for (int i : arr) {
			insert(i);
		}
	}

	private void insert(int value) {
		root = insert(root, value); // root是根节点，每次从根节点查找待插入的节点
	}

	/**
	 * 插入节点
	 * 
	 * @param root
	 * @param value
	 * @return
	 */
	private BinaryTreeNode insert(BinaryTreeNode root, int value) {
		if (root == null) {
			root = new BinaryTreeNode(value);
		} else if (value <= root.value) {
			if (root.left == null) {
				root.left = new BinaryTreeNode(value);
			} else {
				insert(root.left, value);
			}

		} else {
			if (root.right == null) {
				root.right = new BinaryTreeNode(value);
			} else {
				insert(root.right, value);
			}
		}

		return root;

	}

	/**
	 * 中序遍历
	 * 
	 * @param tree
	 */
	public void inOrder(BinaryTreeNode tree) {
		if (tree != null) {
			inOrder(tree.left);
			System.out.print(tree.value + " ");
			inOrder(tree.right);
		}
	}

	/**
	 * 前序遍历
	 * 
	 * @param tree
	 */
	public void preOrder(BinaryTreeNode tree) {
		if (tree != null) {
			System.out.print(tree.value + "  ");
			preOrder(tree.left);
			preOrder(tree.right);
		}
	}

	/**
	 * 后序遍历
	 * 
	 * @param tree
	 */
	public void postOrder(BinaryTreeNode tree) {
		if (tree != null) {
			postOrder(tree.left);
			postOrder(tree.right);
			System.out.print(tree.value + " ");

		}
	}

	/**
	 * 层序遍历二叉树，用队列实现，先将根节点入队列，只要队列不为空，然后出队列，并访问，接着讲访问节点的左右子树依次入队列 <br/>
	 * refer: http://blog.csdn.net/kerryfish/article/details/24309617
	 * 
	 * @param tree
	 */
	public void levelOrder(BinaryTreeNode tree) {
		if (tree == null) {
			return;
		}

		Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
		q.add(root);
		while (!q.isEmpty()) {
			BinaryTreeNode temp = q.poll();
			System.out.print(temp.value + " ");

			if (temp.left != null)
				q.add(temp.left);

			if (temp.right != null)
				q.add(temp.right);
		}

	}

	/**
	 * 递归实现查找
	 * 
	 * @param tree
	 * @param value
	 * @return
	 */
	public BinaryTreeNode search(BinaryTreeNode tree, int value) {
		if (tree == null || tree.value == value) {
			return tree;
		}
		if (value <= tree.value) {
			return search(tree.left, value);
		} else {
			return search(tree.right, value);
		}

	}

	/**
	 * 非递归实现查找
	 * 
	 * @param tree
	 * @param value
	 * @return
	 */
	private BinaryTreeNode searchNoRecrusion(BinaryTreeNode root, int value) {
		while (root != null && root.value != value) {
			if (value <= root.value) {
				root = root.left;
			} else {
				root = root.right;
			}
		}
		if (root == null) {
			throw new NullPointerException("NullPointer" + value);
		} else {
			return root;
		}
	}

	/**
	 * 二叉树里面是否存在 为某个值的节点.
	 * 
	 * @param tree
	 * @param value
	 * @return
	 */
	private boolean isExistNode(BinaryTreeNode tree, int value) {
		// if(tree != null) {
		// return false;
		// }

		if (search(tree, value) != null) {
			return true;
		}

		return false;
	}

	/**
	 * 最小值节点
	 * 
	 * @param root
	 * @return
	 */
	public BinaryTreeNode minMode(BinaryTreeNode root) {
		while (root.left != null) {
			root = root.left;
		}
		return root;
	}

	/**
	 * 最大值节点
	 * 
	 * @param root
	 * @return
	 */
	public BinaryTreeNode maxNode(BinaryTreeNode root) {
		while (root.right != null) {
			root = root.right;
		}
		return root;
	}

	/**
	 * 获取二叉树的节点总数
	 * 
	 * @param root
	 * @return
	 */
	private int getTotalNodeNum(BinaryTreeNode root) {
		if (root == null) {
			return 0;
		}

		return getTotalNodeNum(root.left) + getTotalNodeNum(root.right) + 1;
	}
	
	/**
	 * 获取二叉树中叶子节点的个数;
	 * 
	 * @param root
	 * @return
	 */
	private int getLeafNodeNum(BinaryTreeNode root) {
		if(root == null) {
			return 0;
		}
		if(root.left == null && root.right == null) {
			return 1;
		}
		
		int leafNumLeft = getLeafNodeNum(root.left);
		int leafNumRight = getLeafNodeNum(root.right);
		
		return leafNumLeft + leafNumRight;
	}

	/**
	 * 二叉树的层数(深度)
	 * 
	 * @param root
	 * @return
	 */
	private int getBinaryTreeDepth(BinaryTreeNode root) {
		if (root == null) {
			return 0;
		}

		int depthLeft = getBinaryTreeDepth(root.left);
		int depthRight = getBinaryTreeDepth(root.right);

		return depthLeft > depthRight ? (depthLeft + 1) : (depthRight + 1);
	}

	private BinaryTreeNode insertNode(BinaryTreeNode root, BinaryTreeNode unKnown) {
		if (root == null) {
			return new BinaryTreeNode(unKnown.value);
		}

		if (unKnown.value <= root.value) {
			root.left = insertNode(root.left, unKnown);
		} else {
			root.right = insertNode(root.right, unKnown);
		}

		return root;
	}

	/**
	 * 移除二叉树中的某个元素
	 * 
	 * @param root
	 * @param value
	 * @return
	 */
	private BinaryTreeNode remove(BinaryTreeNode root, int value) {
		if (root == null) {
			return root;
		}

		if (value < root.value) {
			root.left = remove(root.left, value);
		} else if (value > root.value) {
			root.right = remove(root.right, value);
		} else if (root.left != null && root.right != null) {
			root.value = minMode(root.right).value;
			root.right = remove(root.right, root.value);
		} else {
			if (root.left != null) {
				root = root.left;
			} else {
				root = root.right;
			}
		}
		return root;
	}
	
	

	public static void main(String[] args) {
		int arr[] = { 3, 5, 10, 6, 4, 12, 8, 9, 7, 2 };
		BinaryTree binaryTree = new BinaryTree(arr);
//		binaryTree.insert(binaryTree.root, 5);

		// System.out.println(bitree.search(bitree.root, 5).value);
		// bitree.in_order_traves(bitree.root);
		// bitree.inOrder(bitree.root);

		// bitree.preOrder(bitree.root);

		// bitree.inOrder(bitree.root);
		// bitree.postOrder(bitree.root);
		binaryTree.levelOrder(binaryTree.root);

		System.out.println();
		System.out.println(binaryTree.maxNode(binaryTree.root).value);

		System.out.println(binaryTree.getTotalNodeNum(binaryTree.root));
		System.out.println(binaryTree.getBinaryTreeDepth(binaryTree.root));

		System.out.println(binaryTree.search(binaryTree.root, 12));
		System.out.println(binaryTree.isExistNode(binaryTree.root, 12));
		System.out.println(binaryTree.getLeafNodeNum(binaryTree.root));
	}

}
