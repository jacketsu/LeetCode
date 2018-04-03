// Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

// For example,
// Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.

// Window position                Max
// ---------------               -----
// [1  3  -1] -3  5  3  6  7       3
//  1 [3  -1  -3] 5  3  6  7       3
//  1  3 [-1  -3  5] 3  6  7       5
//  1  3  -1 [-3  5  3] 6  7       5
//  1  3  -1  -3 [5  3  6] 7       6
//  1  3  -1  -3  5 [3  6  7]      7
// Therefore, return the max sliding window as [3,3,5,5,6,7].

// Note: 
// You may assume k is always valid, ie: 1 ≤ k ≤ input array's size for non-empty array.

// Follow up:
// Could you solve it in linear time?
// 


class Solution {
    public void inQueue(Deque<Integer> q, int num) {
        while (!q.isEmpty() && num > q.peekLast()) {                //Deque
            q.pollLast();
        }
        q.offerLast(num);
    }
    
    public void outQueue(Deque<Integer> q, int num) {               //
        if (num == q.peekFirst()) {
            q.pollFirst();
        }
    }
    
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];
        Deque<Integer> q = new ArrayDeque<>();                      //Deque
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < k - 1; i++) {
            inQueue(q, nums[i]);
        }
        
        for (int i = k - 1; i < nums.length; i++) {
            inQueue(q, nums[i]);
            res[i - k + 1] = q.peekFirst();                 // i - k + 1
            outQueue(q, nums[i - k + 1]);
        }
        
        return res;
    }
}