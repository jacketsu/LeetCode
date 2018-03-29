class LRUCache {
    class DLinkedNode {
        int key;
        int val;
        DLinkedNode pre;
        DLinkedNode next;
    }
    
    private int count;
    private int capacity;
    private DLinkedNode head;
    private DLinkedNode tail;
    private Map<Integer, DLinkedNode> map = new HashMap<>();
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.count = 0;
        this.head = new DLinkedNode();
        this.tail = new DLinkedNode();
        this.head.pre = null;
        this.tail.next = null;
        this.head.next = this.tail;
        this.tail.pre = this.head;
    }
    
    public void remove(DLinkedNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }
    
    public void add(DLinkedNode node) {
        node.pre = this.head;
        node.next = this.head.next;
        this.head.next.pre = node;
        this.head.next = node;
    }
    
    public void moveToHead(DLinkedNode node) {
        this.remove(node);
        this.add(node);
    }
    
    public void popTail() {
        DLinkedNode node = this.tail.pre;
        this.remove(node);
        this.count--;
        this.map.remove(node.key);
    }
    
    public int get(int key) {
        if (!this.map.containsKey(key)) {
            return -1;
        } else {
            DLinkedNode node = this.map.get(key);
            this.moveToHead(node);
            return node.val;
        }
    }
    
    public void put(int key, int val) {
        if (this.map.containsKey(key)) {
            DLinkedNode node = this.map.get(key);           //put,update, move to head
            node.val = val;
            this.moveToHead(node);
        } else {
            DLinkedNode node = new DLinkedNode();
            node.key = key;
            node.val = val;
            this.add(node);
            this.map.put(key, node);
            this.count++;
            if (this.count > this.capacity) {
                this.popTail();
            }
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
