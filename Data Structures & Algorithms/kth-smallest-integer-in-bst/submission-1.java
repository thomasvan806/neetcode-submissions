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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> elements = new ArrayList<>();

        dfs(root, elements);
        return elements.get(k - 1);
    }

    private void dfs(TreeNode curr, List<Integer> elements) {
        if (curr == null) return;

        dfs(curr.left, elements);
        elements.add(curr.val);
        dfs(curr.right, elements);
    }
}
