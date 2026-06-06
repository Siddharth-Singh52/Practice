class Solution {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {

        // Both nodes are null -> trees match at this position
        if(root1 == null && root2 == null) return true;

        // One node is null and the other is not -> cannot be equivalent
        if(root1 == null || root2 == null) return false;

        // Current node values must be equal
        if(root1.val != root2.val) return false;

        boolean noFlip = false;
        boolean flip = false;

        // CASE 1 : Compare without flipping
        // Example:
        //      1               1
        //     / \             / \
        //    2   3           2   3
        //
        // Compare:
        // root1.left  ↔ root2.left
        // root1.right ↔ root2.right
        boolean leftSame = flipEquiv(root1.left, root2.left);
        boolean rightSame = flipEquiv(root1.right, root2.right);

        // No-flip case succeeds only if both comparisons succeed
        if(leftSame == true && rightSame == true){
            noFlip = true;
        }

        // CASE 2 : Compare after flipping
        // Example:
        //      1               1
        //     / \             / \
        //    2   3           3   2
        //
        // Compare:
        // root1.left  ↔ root2.right
        // root1.right ↔ root2.left
        boolean leftFlip = flipEquiv(root1.left, root2.right);
        boolean rightFlip = flipEquiv(root1.right, root2.left);

        // Flip case succeeds only if both mirror comparisons succeed
        if(leftFlip == true && rightFlip == true){
            flip = true;
        }

        // Trees are flip equivalent if either:
        // 1. No-flip comparison works
        // 2. Flip comparison works
        if(noFlip == true || flip == true) return true;

        // Neither possibility worked
        return false;
    }
}
