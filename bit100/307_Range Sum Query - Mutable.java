// Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

// The update(i, val) function modifies nums by updating the element at index i to val.
// Example:
// Given nums = [1, 3, 5]

// sumRange(0, 2) -> 9
// update(1, 2)
// sumRange(0, 2) -> 8
// Note:
// The array is only modifiable by the update function.
// You may assume the number of calls to update and sumRange function is distributed evenly.
// 


class NumArray {
    int[] nums;
    int[] tree;
    int n;
    public NumArray(int[] nums) {
        this.n = nums.length;
        this.nums = new int[this.n];
        this.tree = new int[this.n + 1];
        for (int i = 0; i < this.n; i++) {
            this.update(i, nums[i]);
        }
    }
    
    public void update(int i, int val) {
        int diff = val - this.nums[i];
        this.nums[i] = val;
        int j = i + 1;
        for (; j <= this.n; j += (j & (-j))) {
            tree[j] += diff;
        }
    }
    
    public int sumRange(int i, int j) {
        return sum(j + 1) - sum(i);
    }
    
    public int sum(int k) {
        int sum = 0;
        for (int i = k; i > 0; i -= (i & (-i))) {
            sum += tree[i];
        }
        
        return sum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */