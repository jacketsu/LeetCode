class MinStack {
    long min;
    Stack<Long> stack;
    /** initialize your data structure here. */
    public MinStack() {
        this.stack = new Stack<>();
    }
    
    public void push(int x) {
        if (stack.isEmpty()) {
            stack.push(0L);
            this.min = x;
        } else {
            stack.push(x - this.min);
            if (x < this.min) {
                this.min = x;
            }
        }
    }
    
    public void pop() {
        long pop = stack.pop();
        if (pop < 0) {
            this.min -= pop;
        }
    }
    
    public int top() {                                          //tricky
        long peek = stack.peek();
        if (peek >= 0) {
            return (int)(peek + this.min);
        } else {
            return (int)this.min;
        }
    }
    
    public int getMin() {
        return (int)this.min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
