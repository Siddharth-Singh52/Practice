/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        
        // No nodes left in the main tree, so subRoot cannot be found
        if(root == null) return false;

        // Check if subRoot starts from the current node and matches all nodes.check if both trees are identical and store it.
        boolean res = sameTree(root, subRoot);
        if(res == true) return true; // If all nodes matched, we found subRoot inside the main tree.

        // subRoot didn't start here,
        // so search in the left part of the main tree.
        boolean leftSide = isSubtree(root.left, subRoot);

        // Also search in the right part of the main tree.
        boolean rightSide = isSubtree(root.right, subRoot);

        // If found on either side, return true.
        if(leftSide == true || rightSide == true) return true;

        return false;
    }
    
    boolean sameTree(TreeNode root, TreeNode subRoot){

        if(root == null && subRoot == null) return true;

        if(root == null || subRoot == null) return false;

        if(root.val != subRoot.val) return false;

        boolean res1 = sameTree(root.left, subRoot.left);
        boolean res2 = sameTree(root.right, subRoot.right);

        if(res1 == true && res2 == true) return true;

        return false;
    }
}
