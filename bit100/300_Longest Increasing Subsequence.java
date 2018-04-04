// Given an unsorted array of integers, find the length of longest increasing subsequence.

// For example,
// Given [10, 9, 2, 5, 3, 7, 101, 18],
// The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may be more than one LIS combination, it is only necessary for you to return the length.

// Your algorithm should run in O(n2) complexity.

// Follow up: Could you improve it to O(n log n) time complexity?

// Credits:
// Special thanks to @pbrother for adding this problem and creating all test cases.


class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int len = 0;
        int[] tails = new int[nums.length];
        tails[len] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (tails[0] > nums[i]) {
                tails[0] = nums[i];
            } else if (tails[len] < nums[i]) {
                tails[++len] = nums[i];
            } else {
                tails[binarySearch(nums, tails, 0, len, nums[i])] = nums[i];
            }
        }
        
        return len + 1;
    }
    
    public int binarySearch(int[] nums, int[] tails, int lo, int hi, int target) {
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (tails[mid] == target) {
                return mid;
            } else if (tails[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return lo;
    }
    
    
}