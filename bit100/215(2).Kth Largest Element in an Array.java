// Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
// For example,
// Given [3,2,1,5,6,4] and k = 2, return 5.

// Note: 
// You may assume k is always valid, 1 ≤ k ≤ array's length.

// Credits:
// Special thanks to @mithmatt for adding this problem and creating all test cases.
// 


class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        int lo = 0, hi = n -1;
        while (lo <= hi) {
            int pos = partition(nums, lo, hi);
            if (pos + 1 == k) {
                return nums[pos];
            } else if (pos + 1 > k) {
                hi = pos - 1;
            } else {
                lo = pos + 1;
            }
        }
        return 0;
    }

    public int partition(int[] nums, int lo, int hi) {
        int pivot = nums[lo];
        int l = lo + 1, r = hi;
        while (l <= r) {
            if (nums[l] < pivot && nums[r] > pivot) {
                swap(nums, l++, r--);
            }
            if (nums[l] >= pivot) {
                l++;
            }
            if (nums[r] <= pivot) {
                r--;
            }
        }
        swap(nums, lo, r);
        return r;
    }
    
    
    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}