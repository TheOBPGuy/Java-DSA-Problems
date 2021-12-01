import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Node2 {
    public int val;
    public List<Node2> children;

    public Node2() {};
    public Node2(int _val, List<Node2> _children) {
        this.val = _val;
        this.children = _children;
    }
}

public class NaryTreePostorderTraversal {

    /**
     * Given the root of an n-ary tree, return the postorder traversal of its nodes' values.
     *
     * Nary-Tree input serialization is represented in their level order traversal. Each group of children is separated by the null value (See examples)
     * @param root
     * @return
     *
     * Input: root = [1,null,3,2,4,null,5,6]
     * Output: [5,6,3,2,4,1]
     *
     */
    public static List<Integer> postOrder(Node2 root) {
        // DFS approach using Stacks will be used here
        List<Node2> stack = new LinkedList<Node2>();
        List<Integer> res = new LinkedList<Integer>();

        stack.add(root);
        while(!stack.isEmpty()) {
            // Get the first element
            Node2 parent = stack.remove(0);
            res.add(parent.val);

            // Go to all the children of the parent and put them on the stack
            for (Node2 child : parent.children) {
                stack.add(child);
            }
        }

        return res;
    }

    public static void main(String[] args) {

    }
}
