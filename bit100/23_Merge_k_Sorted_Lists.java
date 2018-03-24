class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode l1, ListNode l2) {
                if (l1.val < l2.val) {
                    return -1;
                } else if (l1.val == l2.val) {
                    return 0;
                } else {
                    return 1;
                }
            }
        });
        
        for (ListNode list : lists) {
            if (list != null) {                                 //tell if list is null
                pq.offer(list);
            }
        }
        
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while (!pq.isEmpty()) {
            ListNode pop = pq.poll();
            head.next = new ListNode(pop.val);
            head = head.next;
            if (pop.next != null) {
                pq.offer(pop.next);
            }
        }
        
        return dummy.next;
    }
}
