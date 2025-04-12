// Time Complexity : O(n), where n is the number of nodes in the tree
// Space Complexity : O(n), for the queue used in BFS and the final result list
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach:
// Uses a Breadth-First Search (BFS)strategy to perform a level order traversal of the binary tree.
// A queue is used to keep track of nodes at the current level.
// For each level, we extract the number of nodes the size of queue, iterate through them, and enqueue their children.
// The values of the current level are added to a temporary list and then added to the final result.
// This continues until the queue is empty i.e all levels are processed.


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
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                temp.add(curr.val);
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
            result.add(temp);
        }

        return result;
    }
}