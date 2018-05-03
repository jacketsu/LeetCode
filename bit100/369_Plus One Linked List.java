// Given a non-negative integer represented as non-empty a singly linked list of digits, plus one to the integer.

// You may assume the integer do not contain any leading zero, except the number 0 itself.

// The digits are stored such that the most significant digit is at the head of the list.

// Example:
// Input:
// 1->2->3

// Output:
// 1->2->4

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode plusOne(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        int carry = 1;
        ListNode pre = null;
        while (!stack.isEmpty()) {
            int sum = carry + stack.pop();
            ListNode newNode = new ListNode(sum % 10);
            carry = sum / 10;
            newNode.next = pre;
            pre = newNode;
        }
        if (carry > 0) {
            ListNode newNode = new ListNode(carry);
            newNode.next = pre;
            pre = newNode;
        }
        return pre;
    }
}