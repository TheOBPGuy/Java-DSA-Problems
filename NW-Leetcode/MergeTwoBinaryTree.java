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

 public class MergeTwoBinaryTree {

    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        // Base conditions
        if (t1 == null) {
            return t2;
        } 
        if (t2 == null) {
            return t1;
        }

        // Sum the "current" values for nodes
        t1.val  = t1.val + t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1,right, t2.right);
        return t1;
    }

    public static void main(String[] args) {

    }
 }