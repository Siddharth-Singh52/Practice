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
    public List<Double> averageOfLevels(TreeNode root) {

        // Stores nodes that need to be processed level by level
        Queue<TreeNode> queue = new LinkedList<>();

        // Stores the average value of all levels
        List<Double> res = new ArrayList<>();
        levelOrder(root, queue, res);

        return res;
    }

    void levelOrder(TreeNode root, Queue<TreeNode> queue, List<Double> res){

        // Empty tree has no levels
        if(root == null){
            return;
        }

        queue.offer(root); // Root forms the first level of the tree

        // Continue until all levels have been processed
        while(!queue.isEmpty()){

            // Number of nodes present in the current level
            int size = queue.size();
            int levelsize = size;

            // Stores the sum of values of the current level
            long sum = 0;

            // Visit every node belonging to the current level
            while(size > 0){

                TreeNode node = queue.poll();

                // Include current node's value in the level sum
                sum += node.val;

                // Left child belongs to the next level
                if(node.left != null){
                    queue.offer(node.left);
                }

                // Right child belongs to the next level
                if(node.right != null){
                    queue.offer(node.right);
                }

                size--;
            }

            // Average value of all nodes in the current level
            double average = (double)sum / levelsize;

            // Store this level's average
            res.add(average);
        }
    }
}
