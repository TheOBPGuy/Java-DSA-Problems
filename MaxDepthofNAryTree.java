import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 
 */

/**
 * @author farhanibrahim
 *
 */
public class MaxDepthofNAryTree {

	// This is a global variable which we will update at every iteration of our DFS search
	private static int maxDepth;
	
	public static class Node {
		public int val;
		public List<Node> children;
		
		public Node() {}
		
		public Node(int _val) {
			this.val = _val;
		}
		
		public Node(int val, List<Node> _children) {
			this.val = val;
			this.children = _children;
		}
		
	}
	
	public static void insert(Node root, int parent, int child, LinkedList<Integer> visited) {
		if (root == null) {
			Node newNode = new Node(parent);
			newNode.children.add(new Node(child));
		}
		
		// Get the Parent Node
		Node parentNode = getDFSParent(root, new Node(parent), visited);
		
		// 1. If the parentNode already has children then just add to list
		// 2. Otherwise ; create a new list of children and add to that list
		if (parentNode.children == null) {
			List<Node> adjacencies = new LinkedList<Node>();
			adjacencies.add(new Node(child));
			parentNode.children = adjacencies;
		} else {
			parentNode.children.add(new Node(child));
		}
	}
	
	private static Node getDFSParent(Node start, Node target, LinkedList<Integer> visited) {
		// 1. Base case
		if (visited.contains(start.val)) {
			return null;
		}
		
		// 2. If this is a new variable then add it to the visited list
		visited.add(start.val);
		// 3. Check if any of the children's value is the target Node's value
		if (start.children != null) {
			for (Node children : start.children) {
				if (children.val == target.val) {
					return start;
				}
			}
		}
		
		// 4. If the parent has not been found, then continue to further go down the stack
		if (start.children != null) {
			for (Node child : start.children) {
				return getDFSParent(child, target, visited);
			}
		}
		
		return null;
	}
	
	
	public static int maxDepthBFS(Node root) {
		LinkedList<Integer> visited = new LinkedList<Integer>();
		Queue<Node> queue = new LinkedList<Node>();
		
		
		Node current = root;
		queue.add(current);
		
		int depth = 0;
		
		while (!queue.isEmpty()) {
			
			int size = queue.size();
			current = queue.poll();
			visited.add(current.val);
			
			for (int i = 0; i < size; i++) {
				if (current.children != null) {
					for (Node child : current.children) {
						queue.offer(child);
					}
					current = queue.poll();
				}
			}
			depth++;
		}
		
		return depth;
	}
	
	
	public static void maxDepthDFS(Node start, LinkedList<Integer> visited, int depth) {
		if (start == null || visited.contains(start.val)) {
			return;
		}
		
		visited.add(start.val);
		// Do some max depth manipulation here
		maxDepth = Math.max(maxDepth, depth);
		
		if (start.children != null) {
			for (Node child : start.children) {
				maxDepthDFS(child, visited, depth+1);
			}
		}
		
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Create the list of nodes
		Node root = new Node(1);
		Node root3 = new Node(3);
		Node root2 = new Node(2);
		Node root4 = new Node(4);
		Node root5 = new Node(5);
		Node root6 = new Node(6);
		
		// Attach the nodes
		List<Node> list1 = new LinkedList<Node>();
		list1.add(root3); list1.add(root4); list1.add(root2);
		root.children = list1;
		
		List<Node> list3 = new LinkedList<Node>();
		list3.add(root5); list3.add(root6);
		root3.children = list3;
		
		LinkedList<Integer> visited = new LinkedList<Integer>();
		
		// Test out the getDFS Parent Function -> helper
		// System.out.println(getDFSParent(root, root2, visited).val);
		
		// Test out the max Depth BFS Function
		// System.out.println(maxDepthBFS(root));
		
		// Test out the max Depth DFS Function
		maxDepthDFS(root, visited, 1);
		System.out.println(maxDepth);
	}

}
