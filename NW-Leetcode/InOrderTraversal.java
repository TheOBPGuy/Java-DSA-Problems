import java.util.*;
import java.util.LinkedList;

public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }

public class InOrderTraversal {

    public static List<Integer> inorderRecurive(TreeNode root) {
        if (root == null) {
            return new LinkedList<>();
        }
        return helper(root, new LinkedList<>());
    }

    private static List<TreeNode> helper(TreeNode root, List<Integer> list) {
        if (root == null) { return new LinkedList<>(); }

        helper(root.left, list);
        list.add(root.val);
        helper(root.right,list);
    }

    public static List<Integer> inOrderTraversal(TreeNode root) {
        // DFS approach using Stacks will be used here
        // Iterative method using Stack
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();

        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            // Iterate all the way to the left most child
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            res.add(current.val);
            current = current.right;
        }

        return res;
    }

    public static void main(String[] args) {

    }
}
