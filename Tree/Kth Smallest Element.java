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

    // Stores the inorder traversal values not required for solving the problem, added only for understanding.
    List<Integer> element = new ArrayList<>();

    int ans = 0; // Store the Kth Smallest element

    int count = 0; // Keeps track of how many nodes have been visited during inorder traversal
    public int kthSmallest(TreeNode root, int k) {
        
        // InOrder traversal arranged the element in ascending order in BST
        inOrder(root, k);
        return ans;
    }

    void inOrder(TreeNode root, int k){

        if(root == null) return;

        inOrder(root.left, k); // Visit all smaller elements first.
        
        element.add(root.val); // Current node is visited in sorted order
        count++; // Increase count because one more node has been visited in sorted order
        if(count == k) ans = root.val; // When count becomes k, current node is the kth smallest element.

        inOrder(root.right, k); // Visit larger elements
    }
}
