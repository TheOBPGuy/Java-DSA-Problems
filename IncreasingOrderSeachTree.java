import java.util.Arrays;
import java.util.LinkedList;

import RangeSumofBST.TreeNode;

/**
 * 
 */

/**
 * @author farhanibrahim
 *
 */
public class IncreasingOrderSeachTree {

	static class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;
		
		public TreeNode() {};
		
		public TreeNode(int data) {
			this.data = data;
		}
		
		public TreeNode(int data, TreeNode left, TreeNode right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}
	
	public static void insert(TreeNode root, int val) {
		if (root.data <= val) {
			if (root.right == null) {
				root.right = new TreeNode(val);
			} else {
				insert(root.right, val);
			}
		} else {
			if (root.left == null) {
				root.left = new TreeNode(val);
			} else {
				insert(root.left, val);
			}
		}
	}
	
	private static LinkedList<Integer> list = new LinkedList<Integer>();
	
	public static TreeNode createTree(TreeNode root, LinkedList<Integer> visited) {
		// 1. Get the range of values in the current BST
		// 2. Sort the arrays; or just traverse from smallest to largest
		// 3. Create a separate array based on the array traversal
		dfsHelper(root, visited);
		System.out.println(Arrays.toString(list.toArray()));
		
		// Sort the arrays in Ascending order
		
		return null;
	}
	
	
	private static void dfsHelper(TreeNode root, LinkedList<Integer> visited) {
		if (visited.contains(root.data)) {
			return;
		}
		
		visited.add(root.data);
		list.add(root.data);
		
		if (root.left != null) dfsHelper(root.left, visited);
		if (root.right != null) dfsHelper(root.right, visited);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		insert(root, 5);
		insert(root, 15);
		insert(root, 3);
		insert(root, 7);
		insert(root, 18);
		
		LinkedList<Integer> visited = new LinkedList<Integer>(); 
		createTree(root, visited);

	}

}
