import java.util.HashMap;
import java.util.Map;

/**
 * 
 */

/**
 * @author TheOBPGuy
 *
 */
public class Trie {

	private class TrieNode {
		Map<Character, TrieNode> children;
		boolean endOfWord;
		
		public TrieNode() {
			children = new HashMap<>();
			endOfWord = false;
		}
	}
	
	private final TrieNode root;
	public Trie() {
		root = new TrieNode();
	}
	
	/**
	 * Iterative Approach to Insert 
	 * @param str
	 */
	public void insert(String str) {
		TrieNode current = root;
		for (int i = 0; i < str.length(); i++) {
			Character c = str.charAt(i);
			
			TrieNode currentNode = current.children.get(c);
			if (currentNode == null) {
				currentNode = new TrieNode();
				current.children.put(c, currentNode);
			}
			current = currentNode;
		}
		
		current.endOfWord = true;
	}
	
	/**
	 * Recursive Approach to Insert
	 * @param str
	 */
	public void recursiveInsert(TrieNode root, String str, int index) {
		if (str.length() == 0) {
			root.endOfWord = true;
			return;
		}
		Character c = str.charAt(index);
		TrieNode current = root.children.get(c);
		if (current == null) {
			current = new TrieNode();
			root.children.put(c, current);
		}
		recursiveInsert(current, str, index+1);
	}
	
	/**
	 * Iterative Search Function
	 * @param str
	 * @return
	 */
	public boolean iterativeSearchWhole(TrieNode root, String str) {
		TrieNode current = root;
		for (int i = 0; i < str.length(); i++) {
			Character c = str.charAt(i);
			TrieNode node = current.children.get(c);
			if (node == null) {
				if (node.endOfWord == false) {
					return false;
				}
			} else {
				current = node;
			}
		}
		return current.endOfWord;
	}
	
	/**
	 * Recursive Search Function
	 * @param root
	 * @param str
	 * @return
	 */
	public boolean recursiveSearch(TrieNode root, String str, int index) {
		if (str.length() == 0) {
			return root.endOfWord;
		}
		
		Character c = str.charAt(index);
		TrieNode current = root.children.get(c);
		if (current == null) {
			return false;
		}
		
		return recursiveSearch(current, str, index+1);
	}
	
	
	public boolean delete(TrieNode root, String str, int index) {
		if (str.length() == 0) {
			// If end of word reached, then ONLY delete if current.endOfWord = true
			if (root.endOfWord == false) {
				return false;
			}
			
			// If the endOfWord == true -> then we convert endOfWord == false
			// If endOfWord is false, then search wont return anything for that word
			root.endOfWord = false;
			if (root.children.size() == 0) {
				// There are no more characters left on the TrieNode. So we can delete the entire reference
				return true;
			} else {
				return false;
			}
		}
		
		Character c = str.charAt(index);
		TrieNode current = root.children.get(c);
		if (current == null) {
			return false;
		}
		
		boolean shouldDeleteCurrentNode = delete(current, str, index+1);
		
		if (shouldDeleteCurrentNode == true) {
			current.children.remove(c);
			return current.children.size() == 0;
		}
		
		return false;
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
