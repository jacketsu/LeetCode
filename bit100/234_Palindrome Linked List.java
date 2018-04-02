// Given a singly linked list, determine if it is a palindrome.

// Follow up:
// Could you do it in O(n) time and O(1) space?

// Seen this question in a real interview before?  


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        if (fast != null) {
            slow = slow.next;
        }
        
        slow = reverse(slow);
        fast = head;
        while (slow != null) {
            if (fast.val != slow.val) return false;
            fast = fast.next;
            slow = slow.next;
        }
        
        return true;
    }
    
    public ListNode reverse(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode next= head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        
        return pre;
    }
}