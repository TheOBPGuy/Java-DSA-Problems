import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 
 */

/**
 * @author TheOBPGuy
 *
 */
public class BreathFirstSearch {

	private static HashMap<Integer, LinkedList<Node>> map = new HashMap<Integer, LinkedList<Node>>();
	
	static class Node {
		private int data;
		
		public Node(int data) {
			this.data = data;
		}
	}
	
	public static void add(int parent, int child) {
		// 1.Check if map already contains parent
		
		if (!map.containsKey(parent)) {
			LinkedList<Node> list = new LinkedList<Node>();
			list.add(new Node(child));
			map.put(parent, list);
		} else {
			LinkedList<Node> list = map.get(parent);
			list.add(new Node(child));
			map.put(parent, list);
		}
	}
	
	public static void bfs(int start) {
		// 1. Initiate a queue
		// 2. Put the very first element into the queue
		// 3. Keep iterating over the queue until it is empty
		// 4. Keep printing each of the dequeued elements of the queue
		// 5. Add elements to the queue 
		
		// 6. A visited Node will also be introduced.
		// 		This will ensure we tackle the situation of an undirected graph
		
		LinkedList<Integer> visited = new LinkedList<Integer>();
		
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(start);
		
		while (!queue.isEmpty()) {
			// a. Take out the first element from the queue
			// b. Print out the dequeued value
			// c. Loop through all values inside that particular key
			// d. Add all the values to the queue
			int parent = queue.poll();
			System.out.print(parent);
			
			// e. Add the element to the visited array. This will prevent us from 
			// 		revising the node again
			visited.add(parent);
			
			if (map.get(parent) != null) {
				for (Node child : map.get(parent)) {
					if (!visited.contains(child.data)) {
						queue.add(child.data);
						
					}
				}
			}
			
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		add(1,2);
		add(1,3);
		add(2,4);
		add(2,5);
		add(3,6);
		add(3,7);
		
		bfs(1);
	}

}
