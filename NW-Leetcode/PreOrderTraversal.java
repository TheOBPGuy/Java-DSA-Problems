import java.util.*;
import java.util.LinkedList;

class Node2 {
    public int val;
    public List<Node2> children;

    public Node2() {};
    public Node2(int _val, List<Node2> _children) {
        this.val = _val;
        this.children = _children;
    }
}

public class PreOrderTraversal {

    public static List<Integer> preOrderTraversal(Node2 root) {
        // DFS approach using Stacks will be used here
        // Iterative method using Stack
        Stack<Node2> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();

        // Base condition
        if (root == null) {
            return new LinkedList<>();
        }
        stack.add(root);
        while (!stack.isEmpty()) {
            Node2 parent = stack.pop();
            res.add(parent.val);
            Collections.reverse(parent.children);
            for (Node2 child : parent.children) {
                stack.add(child);
            }
        }

        return res;
    }

    public static void main(String[] args) {

    }
}
