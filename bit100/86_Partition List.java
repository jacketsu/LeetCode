// Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

// You should preserve the original relative order of the nodes in each of the two partitions.

// Example:

// Input: head = 1->4->3->2->5->2, x = 3
// Output: 1->2->2->4->3->5

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode smallHead = new ListNode(0);
        ListNode bigHead = new ListNode(0);
        ListNode small = smallHead;
        ListNode big = bigHead;
        while (head != null) {
            ListNode tmp = new ListNode(head.val);
            if (head.val < x) {
                small.next = tmp;
                small = small.next;
            } else {
                big.next = tmp;
                big= big.next;
            }
            head = head.next;
        }
        small.next = bigHead.next;
        return smallHead.next;
    }
}