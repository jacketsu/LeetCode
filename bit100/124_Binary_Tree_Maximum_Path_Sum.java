/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int maxValue = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxDown(root);
        return maxValue;
    }
    
    public int maxDown(TreeNode root) {
        if (root == null) return 0;
        int left = Math.max(0, maxDown(root.left));
        int right = Math.max(0, maxDown(root.right));
        maxValue = Math.max(left + right + root.val, maxValue);
        return Math.max(left, right) + root.val;
    }
}
