import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 
 */

/**
 * @author TheOBPGuy
 *
 */
public class DepthFirstSearch {

	private static HashMap<Integer, LinkedList<Node>> map = new HashMap<Integer, LinkedList<Node>>();
	
	static class Node {
		private int data;
		public Node(int data) {
			this.data = data;
		}
	}
	
	public static void add(int parent, int child) {
		if (!map.containsKey(parent)) {
			// First time entering the element
			LinkedList<Node> list = new LinkedList<Node>();
			list.add(new Node(child));
			map.put(parent, list);
		} else {
			LinkedList<Node> list = map.get(parent);
			list.add(new Node(child));
			map.put(parent, list);
		}
	}
	
	public static void dfsRecursive(int start, LinkedList<Integer> visited) {
		// 1. Create a stack to put all values
		// 2. Create a visited array to put all visited variables. This will ensure we do not run into infinite loops
		
		// Base Case
		if (visited.contains(start)) {
			return;
		}
		
		// If the element is new then add it to the visited array
		visited.add(start);
		System.out.println(start);
		
		if (map.get(start) != null) {
			for (Node node : map.get(start)) {
				
				dfsRecursive(node.data, visited);
			}
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		LinkedList<Integer> visted = new LinkedList<Integer>();
		
		add(1,2);
		add(2,4);
		add(4,5);
		add(1,3);
		
		dfsRecursive(1,visted);
	}

}
