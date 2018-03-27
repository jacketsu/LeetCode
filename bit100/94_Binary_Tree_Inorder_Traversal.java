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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> s = new Stack<>();
        while(root != null) {
            s.push(root);
            root = root.left;
        }
        
        while (!s.isEmpty()) {
            TreeNode node = s.pop();
            list.add(node.val);
            if (node.right != null) {
                TreeNode right = node.right;
                while (right != null) {
                    s.push(right);
                    right = right.left;
                }
            }
        }
        
        return list;
    }
}
