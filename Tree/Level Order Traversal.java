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

    public List<List<Integer>> levelOrder(TreeNode root) {

        // Final answer:
        // Each inner list stores nodes belonging to one level.
        List<List<Integer>> res = new ArrayList<>();

        // Queue is used to process nodes level by level.
        Queue<TreeNode> queue = new LinkedList<>();

        levelOrder(root, queue, res);

        return res;
    }

    void levelOrder(TreeNode root,
                    Queue<TreeNode> queue,
                    List<List<Integer>> res){

        // No tree exists.
        if(root == null){
            return;
        }

        // Root is the first node of Level 0.
        queue.offer(root);

        // Continue until every node of the tree is processed.
        while(!queue.isEmpty()){

            // Stores all node values of the current level.
            List<Integer> temp = new ArrayList<>();

            /*
             * Important:
             * At this moment, queue contains ONLY the nodes
             * of the current level.
             *
             * Example:
             * Queue = [9, 20]
             * size = 2
             *
             * This means we are currently processing Level 1.
             */
            int size = queue.size();

            /*
             * Process all nodes of the current level.
             * After processing them, their children are added
             * into the queue, which automatically forms the
             * next level.
             */
            while(size > 0){

                // Remove one node from current level.
                TreeNode node = queue.poll();

                // Store its value in current level list.
                temp.add(node.val);

                /*
                 * Children of the current node belong to
                 * the next level of the tree.
                 */

                // Add left child to next level.
                if(node.left != null){
                    queue.offer(node.left);
                }

                // Add right child to next level.
                if(node.right != null){
                    queue.offer(node.right);
                }

                // One node of current level is processed.
                size--;
            }

            /*
             * Entire current level is completed.
             * Store it in the final answer.
             */
            res.add(temp);
        }
    }
}
