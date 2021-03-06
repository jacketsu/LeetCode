tion for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        if (l1 == null && l2 == null) return head;
        while (l1 != null || l2 != null) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            head.next = new ListNode(sum % 10);
            carry = sum / 10;
            head = head.next;
        }
        
        if (carry != 0) head.next = new ListNode(1);
        return dummy.next;
    }
}
