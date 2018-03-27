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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int zigzag = 0;
        while (!q.isEmpty()) {
            int qsize = q.size();
            List<Integer> subList = new ArrayList<>();
            for (int i = 0; i < qsize; i++) {
                TreeNode node = q.poll();
                if (zigzag % 2 == 0) {
                    subList.add(node.val);
                } else {
                    subList.add(0, node.val);                       //(index, node.val)
                }
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
            res.add(subList);
            zigzag++;
        }
        
        return res;
    }
}
