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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot != null) return false;
        if (root != null && subRoot == null) return false;
        if (equals(root, subRoot)) return true;

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean equals(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 != null) return false;
        if (root1 != null && root2 == null) return false;
        if (root1 == root2) return true;
        
        return root1.val == root2.val && equals(root1.left, root2.left) && equals(root1.right, root2.right);
    }
}
