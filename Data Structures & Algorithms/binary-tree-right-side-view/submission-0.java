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
    public List<Integer> rightSideView(TreeNode root) {
        // bfs and just return the last thing of each queue
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        while (!queue.isEmpty()) {
            int layerSize = queue.size();

            for (int i = 0; i < layerSize; i ++) {
                TreeNode currNode = queue.remove();
                if (currNode.left != null) queue.add(currNode.left);
                if (currNode.right != null) queue.add(currNode.right);

                if (i == layerSize - 1) result.add(currNode.val);
            }
        }

        return result;
    }
}
