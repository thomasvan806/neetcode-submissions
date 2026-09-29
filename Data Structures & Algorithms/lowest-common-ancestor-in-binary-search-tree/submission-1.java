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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return traverse(root, Math.min(p.val, q.val), Math.max(p.val, q.val));
    }

    private TreeNode traverse(TreeNode curr, int min, int max) {
        if (curr.val > max) return traverse(curr.left, min, max);
        if (curr.val < min) return traverse(curr.right, min, max);
        return curr;
    }
}
