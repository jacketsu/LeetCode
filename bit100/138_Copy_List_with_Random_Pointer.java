/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode tmpHead = head;
        while (tmpHead != null) {
            RandomListNode clone = new RandomListNode(tmpHead.label);
            map.put(tmpHead, clone);
            tmpHead = tmpHead.next;
        }
        
        tmpHead = head;
        while (tmpHead != null) {
            map.get(tmpHead).next = map.get(tmpHead.next);
            map.get(tmpHead).random = map.get(tmpHead.random);
            tmpHead = tmpHead.next;
        }
        
        return map.get(head);
    }
}
