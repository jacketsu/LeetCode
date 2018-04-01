// Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

// Note: 
// You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

// Follow up:
// What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?

// Credits:
// Special thanks to @ts for adding this problem and creating all test cases.
// 

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
    public int kthSmallest(TreeNode root, int k) {
        int leftcount = countNodes(root.left);
        if (leftcount < k - 1) {
            return kthSmallest(root.right, k - leftcount - 1);
        } else if (leftcount > k - 1) {
            return kthSmallest(root.left, k);
        } else {
            return root.val;                        //root.val  instead of root !
        }
    }
    
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}