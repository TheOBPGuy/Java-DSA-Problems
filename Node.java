/**
 * 
 */

/**
 * @author TheOBPGuy
 *
 */
public class Node {

	Node left, right;
	int data;
	
	public Node(int data) {
		this.data = data;
	}
	
	public void insert(int value) {
		if (value <= data) {
			if (left == null) {
				left = new Node(value);
			} else {
				left.insert(value);
			}
		} else {
			if (right == null) {
				right = new Node(value);
			} else {
				right.insert(value);
			}
		}
	}
	
	public void delete(Node root, int value) {
		// Case 1: Node is a leaf
		if (isLeaf(root, value)) {
			// a. Get the Parent
			// b. Make the entry null
			Node parent = getParent(root, value);
			if (parent.left.data == value) {
				parent.left = null;
			} else if (parent.right.data == value) {
				parent.right = null;
			}
		}
		// Case 2: Node has 1 child
		else if (hasOneChild(root, value)) {
			// a. Get the Parent
			// b. Get the Node to be deleted
			// c. Make the parent.next = node.child
			// d. node = null
			Node parent = getParent(root, value);
			Node nodeToDelete = getNodeToBeDeleted(root, value);
			if (parent.right.data == value) {
				if (nodeToDelete.right == null) {
					parent.right = nodeToDelete.left;
					nodeToDelete = null;
				} else if (nodeToDelete.left == null) {
					parent.right = nodeToDelete.right;
					nodeToDelete = null;
				}
			} else if (parent.left.data == value) {
				if (nodeToDelete.right == null) {
					parent.left = nodeToDelete.left;
					nodeToDelete = null;
				} else if (nodeToDelete.left == null) {
					parent.left = nodeToDelete.right;
					nodeToDelete = null;
				}
			}
		}
		// Case 3: Node has 2 children
		else if (hasTwoChildren(root, value)) {
			// a. Get the Parent Node, i.e. parentOfDeleted
			// b. Get the Node to be deleted, i.e. toBeDeleted
			// c. Find the minimum Node of the Right Sub Tree, i.e. toBeMoved
			// d. Get the Parent of toBeMoved, i.e. parentOfTobeMoved
			// e. if toBeMoved is Leaf -> parentOfTobeMoved.left = null
			// f. if toBeMoved has Right Child -> parentOfTobeMoved.left = toBeMoved.right
			Node parentOfDeleted = getParent(root, value);
			Node toBeDeleted = getNodeToBeDeleted(root, value);
			Node toBeMoved = minimumRightSubTree(toBeDeleted.right);
			Node parentOfToBeMoved = getParent(root, toBeMoved.data);
			
			if (parentOfDeleted == null) {
				if (isLeaf(root, toBeMoved.data)) {
					// printInOrder(root);
					// System.out.println("============================");
					root.data = toBeMoved.data;
					toBeDeleted.right = null;
				} else if (toBeMoved.right != null) {
					root.data = toBeMoved.data;
					toBeMoved.data = toBeMoved.right.data;
					toBeMoved.right = null;
				}
			}
 			else if (parentOfDeleted.right.data == value) {
				if (isLeaf(root, toBeMoved.data)) {
					toBeDeleted.data = toBeMoved.data;
					parentOfToBeMoved.left = null;
					
				} else if (toBeMoved.right != null) {
					toBeDeleted.data = toBeMoved.data;
					// parentOfToBeMoved.left = null;
					// parentOfToBeMoved.left = toBeMoved.right;
					toBeMoved.data = toBeMoved.right.data;
					toBeMoved.right = null;
				}
			} else if (parentOfDeleted.left.data == value) {
				if (isLeaf(root, toBeMoved.data)) {
					toBeDeleted.data = toBeMoved.data;
					toBeDeleted.right = null;
					
				} else if (toBeMoved.right != null) {
					toBeDeleted.data = toBeMoved.data;
					toBeMoved.data = toBeMoved.right.data;
					toBeMoved.right = null;
				}
			}
			
		}
	}
	
	public Node getParent(Node root, int target) {
		if (root == null ) {
			return null;
		}
		if (root.left == null || root.right == null) {
			return null;
		} else {
			if (root.data < target) {
				if (root.right.data == target) {
					return root;
				} else {
					return getParent(root.right, target);
				}
			} else {
				if (root.left.data == target) {
					return root;
				} else {
					return getParent(root.left, target);
				}
			}
		}
		
	}
	
	
	public Node minimumRightSubTree(Node root) {
		if (root == null) {
			return null;
		} else {
			if (root.left != null) {
				return minimumRightSubTree(root.left);
			} else if (root.left == null) {
				return root;
			}
		}
		
		return null;
	}
	
	
	public Node getNodeToBeDeleted(Node root, int value) {
		if (root == null) {
			return null;
		}
		if (root.data < value) {
			return getNodeToBeDeleted(root.right, value);
		} else if (root.data > value) {
			return getNodeToBeDeleted(root.left, value);
		} else if (root.data == value) {
			return root;
		}
		return null;
	}
	
	
	public boolean hasOneChild(Node root, int value) {
		if (root == null) {
			return false;
		}
		if (root.data < value) {
			// The target will be on the right hand side
			return hasOneChild(root.right, value);
		} else if (root.data > value) {
			// The target will be on the left hand side
			return hasOneChild(root.left, value);
		} else {
			if (root.right != null && root.left == null) {
				return true;
			} else if (root.left != null && root.right == null) {
				return true;
			} else if (root.left != null && root.right != null) {
				return false;
			}
		}
		
		return false;
	}
	
	
	public boolean hasTwoChildren(Node root, int value) {
		if (root == null) {
			return false;
		}
		if (root.data < value) {
			return hasTwoChildren(root.right, value);
		} else if (root.data > value) {
			return hasTwoChildren(root.left, value);
		} else {
			if (root.data == value) {
				if (root.right != null && root.left != null) {
					return true;
				} else {
					return false;
				}
			}
		}
		return false;
	}
	
	
	public void printInOrder(Node node) {
		if (node.left != null) {
			printInOrder(node.left);
		}
		System.out.println(node.data);
		if (node.right != null) {
			printInOrder(node.right);
		}
	}
	
	private boolean isLeaf(Node root, int value) {
		if (root.data < value) {
			// The value is stored on the right hand side of the tree
			if (root.right == null) { return false; }
			return isLeaf(root.right, value);
		} else if (root.data > value) {
			if (root.left == null) { return false; }
			return isLeaf(root.left, value);
		} else {
			if  (root.data == value) {
				if (root.left == null && root.right == null) {
					return true;
				} else {
					return false;
				}
			}
		}
		return false;
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node node = new Node(3);
		node.insert(1);
		node.insert(2);
		node.insert(5);
		node.insert(4);
		node.insert(6);
		node.insert(7);
		node.insert(0);
		
		// node.insert(2);
		// node.insert(5);
		
		node.printInOrder(node);
		
		// Test the Is Leaf function
		// System.out.println(node.isLeaf(node, 5));
		
		// Test the Get Parent function - When Node is a Leaf
		// System.out.println(node.getParent(node, 6).data);
	
		System.out.println("============================");
		
		// Test the delete function
		//node.delete(node, 4);
		//node.printInOrder(node);
		
		// Test the Has One Child Function
		// System.out.println(node.hasOneChild(node, 1));
		
		// Test Get Node To Be Deleted Fuction
		// System.out.print(node.getNodeToBeDeleted(node, 5).right.right.data);
		
		// Test the delete Fuction - When Node has 1 child
		// node.delete(node, 1);
		// node.printInOrder(node);
		
		// Test the Has Two Children Method
		// System.out.println(node.hasTwoChildren(node, 4));
		
		// Test Minimum Right Sub Tree
		// System.out.println(node.right.data);
		// System.out.println(node.minimumRightSubTree(node).data);
		
		// Test the delete function - When Node has 2 Children
		node.delete(node, 1);
		node.printInOrder(node);
	}

}
