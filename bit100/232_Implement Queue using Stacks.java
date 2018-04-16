// Implement the following operations of a queue using stacks.

// push(x) -- Push element x to the back of queue.
// pop() -- Removes the element from in front of queue.
// peek() -- Get the front element.
// empty() -- Return whether the queue is empty.
// Notes:
// You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size, and is empty operations are valid.
// Depending on your language, stack may not be supported natively. You may simulate a stack by using a list or deque (double-ended queue), as long as you use only standard operations of a stack.
// You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty queue).


// class MyQueue {
//     Stack<Integer> queue;
//     /** Initialize your data structure here. */
//     public MyQueue() {
//         this.queue = new Stack<>();
//     }
    
//     /** Push element x to the back of queue. */
//     public void push(int x) {
//         Stack<Integer> tmp = new Stack<>();
//         while (!this.queue.isEmpty()) {
//             tmp.push(this.queue.pop());
//         }
//         this.queue.push(x);
//         while (!tmp.isEmpty()) {
//             this.queue.push(tmp.pop());
//         }
//     }
    
//     /** Removes the element from in front of queue and returns that element. */
//     public int pop() {
//         return this.queue.pop();
//     }
    
//     /** Get the front element. */
//     public int peek() {
//         return this.queue.peek();
//     }
    
//     /** Returns whether the queue is empty. */
//     public boolean empty() {
//         return this.queue.isEmpty();
//     }
// }

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 * 
 */


class MyQueue {
    Stack<Integer> stack_1;
    Stack<Integer> stack_2;
    /** Initialize your data structure here. */
    public MyQueue() {
        stack_1 = new Stack<>();
        stack_2 = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        while (!this.stack_2.isEmpty()) {
            this.stack_1.push(stack_2.pop());
        }
        this.stack_1.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while (!stack_1.isEmpty()) {
            stack_2.push(stack_1.pop());
        }
        return stack_2.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        while (!stack_1.isEmpty()) {
            stack_2.push(stack_1.pop());
        }
        return stack_2.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return (this.stack_1.isEmpty() && this.stack_2.isEmpty());
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */