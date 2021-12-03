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

public class MaxDepthofBinaryTree {


    /**
     * Given the root of a binary tree, return its maximum depth.
     *
     * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
     * @param root
     * @return
     *
     * Input: root = [3,9,20,null,null,15,7]
     * Output: 3
     */
    // First appraoch
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return 1+ Math.max(left, right);
    }

    private static int answer;
    public static void maxDepth2(TreeNode root, int depth) {
        // Base condition 1
        if (root == null) {
            return;
        }
        // Base condition 2
        if (root.left != null && root.right != null) {
            answer = Math.max(answer, depth);
        }

        maxDepth2(root.left, depth+1);
        maxDepth2(root.right, depth+1);
    }

    public static void main(String[] args) {

    }
}
