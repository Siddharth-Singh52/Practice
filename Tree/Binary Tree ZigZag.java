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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        
        Queue<TreeNode> queue = new LinkedList<>(); // Queue is used to process nodes level by level.

        levelOrder(root, queue, res);
        return res;
    }

    void levelOrder(TreeNode root, Queue<TreeNode> queue, List<List<Integer>> res){

        // Empty tree has no levels
        if(root == null){
            return;
        }

        queue.offer(root); // Root starts the first level
        int level = 0; // Maintain level to find which level is to be reverse

        while(!queue.isEmpty()){

            // Stores all nodes of the current level
            List<Integer> temp = new ArrayList<>();

            // Number of nodes present in the current level
            int size = queue.size();

            // Process every node of the current level
            while(size > 0){
                TreeNode node = queue.poll();

                // Store current node value
                temp.add(node.val);

                // Children become part of the next level
                if(node.left != null){
                    queue.offer(node.left);
                }

                if(node.right != null){
                    queue.offer(node.right);
                }
                size--;
            }

            // Odd levels are stored in reverse order
            if(level % 2 != 0){
                Collections.reverse(temp);
            }

            level++; // Move to the next level
            res.add(temp); // Current level completed
        }
    }
}
