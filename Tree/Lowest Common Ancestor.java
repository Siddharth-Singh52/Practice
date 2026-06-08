class Solution {
    TreeNode ans = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        fun(root, p, q);
        return ans; // Return the node whose subtree contains both target nodes
    }

    int fun(TreeNode root, TreeNode p, TreeNode q){
        if(root == null) return 0; // Empty subtree contains 0 target nodes

        // Count how many target nodes are present in the left side of the tree 
        int left = fun(root.left, p, q);

        // Count how many target nodes are present in the right side of the tree
        int right = fun(root.right, p, q);

        // Check if the current node itself is one of the target nodes(p, q)
        int self = 0;
        if(root == p || root == q) self = 1;

        // Total target nodes present in the current subtree
        int total = left + right + self;

        // Example:
        //        3
        //       / \
        //      5   1
        //
        // p = 5, q = 1
        // left = 1
        // right = 1
        // self = 0
        // total = 2
        // This subtree contains both p and q and total is 2
        if(total == 2 && ans == null){
            ans = root;
        }

        // Return how many target nodes were found in this subtree
        return total;
    }
}
