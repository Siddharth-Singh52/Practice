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
    public boolean isSymmetric(TreeNode root) {

        // Create two roots:
        // root1 represents the left subtree
        // root2 represents the right subtree
        TreeNode root1 = root.left;
        TreeNode root2 = root.right;

        // Check if both subtrees are mirror images of each other
        boolean res = symmetric(root1, root2);
        return res;
    }

    boolean symmetric(TreeNode root1, TreeNode root2){

        // Both nodes are null -> mirror positions match
        if(root1 == null && root2 == null) return true;

        // One node is null and the other is not -> not symmetric
        if(root1 == null || root2 == null) return false;

        // Values at mirror positions must be equal
        if(root1.val != root2.val) return false;

        // compare the left side of the left subtree with the right side of the right subtree to see mirror image
        // Example:
        //       2       2
        //      / \     / \
        //     3   4   4   3
        //     ↑           ↑
        // root1.left  root2.right
        boolean res1 = symmetric(root1.left, root2.right);

        // Compare the right side of the left subtree with the left side of the right subtree
        // Example:
        //       2       2
        //      / \     / \
        //     3   4   4   3
        //         ↑ ↑
        // root1.right root2.left
        boolean res2 = symmetric(root1.right, root2.left);

        // Tree is symmetric only if both mirror images(both cases res1 and res2) comparisons are true
        // Example:
        //     2     2
        //    / \   / \
        //   3   4 4   3
        //
        // Outer pair: 3 ↔ 3
        // Inner pair: 4 ↔ 4
        // Both must match for symmetry
        if(res1 == true && res2 == true){
            return true;
        }

        // If either comparison fails, tree is not symmetric
        return false;
    }
}
