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

    public List<Integer> inorderTraversal(TreeNode root) {

        // This list will store nodes in Inorder sequence
        List<Integer> res = new ArrayList<>();

        // Start traversal from the root of the tree
        inOrder(root, res);

        return res;
    }

    void inOrder(TreeNode root, List<Integer> res){

        // Reached beyond a leaf node
        if(root == null)
            return;

        // Inorder Rule:
        // Visit all nodes of the left subtree first
        inOrder(root.left, res);

        // After completely exploring the left subtree,
        // visit the current node
        res.add(root.val);

        // After visiting the current node,
        // explore all nodes of the right subtree
        inOrder(root.right, res);
    }
}
