import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 */

/**
 * @author TheOBPGuy
 *
 */
public class RangeSumofBST {

	//private static TreeNode node;
	
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		
		public TreeNode() {};
		
		public TreeNode(int val) {
			this.val = val;
		}
		
		public TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val; this.left = left; this.right = right;
		}
	}
	
	public static void insert(TreeNode node, int value) {
		if (node.val <= value) {
			if (node.right == null) {
				node.right = new  TreeNode(value);
			} else {
				insert(node.right, value);
			}
		} else {
			if (node.left == null) {
				node.left = new TreeNode(value);
			} else {
				insert(node.left, value);
			}
		}
	}
	
	/**
	 * Function to print out the Sum of a BST using BreadthFirstSearch Algorithm
	 * @param root
	 * @return
	 */
	public static int sumBSTBFS(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		// LinkedList<Integer> visited = new LinkedList<Integer>();
		int sum = 0;
		
		queue.add(root);
		while (!queue.isEmpty()) {
			// 1. Dequeue out of the queue
			// 2. Add to visited array
			// 3. Add value of TreeNode onto "sum"
			TreeNode current = queue.poll();
			// visited.add(current.val);
			sum = sum + current.val;
			
			if (current.left != null) queue.add(current.left);
			if (current.right != null) queue.add(current.right);
		}
		
		return sum;
	}
	
	/**
	 * Function to print out the Range Sum of a BST using BreadthFirstSearch Algorithm
	 * @param root
	 * @return
	 */
	public static int rangeSumBSTBFS(TreeNode root, int low, int high) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		
		int sum = 0;
		queue.add(root);
		
		while (!queue.isEmpty()) {
			TreeNode current = queue.poll();
			
			// 1. Check if the current's value is within range 
			// 2. If within range then only Add the value
			if (current.val >= low && current.val <= high) {
				sum = sum + current.val;
			}
			
			if (current.left != null) queue.offer(current.left);
			if (current.right != null) queue.offer(current.right);
		}
		
		return sum;
	}
	
	private static int summ;
	
	public static void sumBSTDFS(TreeNode root, LinkedList<Integer> visited, int low, int high) {
		// Base case
		if (visited.contains(root.val)) {
			return;
		}
		
		visited.add(root.val);
		if (root.val >= low && root.val <= high) summ = summ + root.val;
		
		if (root.left != null) sumBSTDFS(root.left, visited, low, high);
		if (root.right != null) sumBSTDFS(root.right, visited, low, high);
		
		//return;
	}
	
	
	public static void printInOrder(TreeNode root) {
		if (root.left != null) {
			printInOrder(root.left);
		}
		System.out.println(root.val);
		if (root.right != null) {
			printInOrder(root.right);
		}
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
		
		// Testing the insert and print function
		// printInOrder(root);
		
		// Testing the sumBSTBFS method
		System.out.println(sumBSTBFS(root));
		
		// Testing the rangeSumBSTBFS method
		System.out.println(rangeSumBSTBFS(root, 7, 15));
		
		// Testing the sumBSTDFS Method
		LinkedList<Integer> visited = new LinkedList<Integer>();
		sumBSTDFS(root, visited, 7, 15);
		System.out.println(summ);
		// System.out.println(sumBSTDFS(root, visited));
	}

}
