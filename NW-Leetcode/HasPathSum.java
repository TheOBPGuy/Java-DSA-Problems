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

public class HasPathSum {

    /**
     * Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.
     *
     * A leaf is a node with no children.
     *
     * Example:
     * 
     * Input: root = [1,2,3], targetSum = 5
     * Output: false
     * Explanation: There two root-to-leaf paths in the tree:
     * (1 --> 2): The sum is 3.
     * (1 --> 3): The sum is 4.
     * There is no root-to-leaf path with sum = 5.
     * @param root
     * @param sum
     * @return
     */
    public static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) { return false; }
        Stack<TreeNode> node_stack = new Stack<>();
        Stack<Integer> sum_stack = new Stack<>();

        node_stack.add(root);
        sum_stack.add(sum - root.val);

        while (!node_stack.isEmpty()) {
            TreeNode currentNode = node_stack.pop();
            int currentSum = sum_stack.pop();

            if (currentNode.left == null && currentNode.right == null && currentSum == 0) {
                return true;
            }

            if (currentNode.left != null) {
                node_stack.add(currentNode.left);
                sum_stack.add(currentSum - currentNode.left.val);
            }
            if (currentNode.right != null) {
                node_stack.add(currentNode.right);
                sum_stack.add(currentSum - currentNode.right.val);
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
