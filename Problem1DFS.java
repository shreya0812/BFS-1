// Time Complexity : O(n), where n is the number of nodes in the tree
// Space Complexity : O(h), where h is the height of the tree (for recursion stack); in the worst case (skewed tree), it can be O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach:
// uses a Depth-First Search (DFS) strategy to perform a level order traversal of the binary tree.
// We recursively traverse the tree and maintain the level of each node.
// If we're visiting a level for the first time, we add a new list to the result list.
// For each node, we add its value to the corresponding list based on its level.
// We recurse first into the left subtree, then the right subtree, incrementing the level by 1 each time.

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
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return result;
        helper(root, 0);
        return result;
    }
    private void helper(TreeNode root, int level){
        if(root == null ) return;
        if(result.size() == level){
            result.add(new ArrayList<Integer>());
        }
        result.get(level).add(root.val);
        helper(root.left,level+1);
        helper(root.right, level+1);

    }
}