// Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
// For example,
// Given [3,2,1,5,6,4] and k = 2, return 5.

// Note: 
// You may assume k is always valid, 1 ≤ k ≤ array's length.

// Credits:
// Special thanks to @mithmatt for adding this problem and creating all test cases.

class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        int p = quickSelect(nums, 0, n - 1, n - k + 1);
        return nums[p];
    }
    
    public int quickSelect(int[] nums, int lo, int hi, int k) {
        int pivot = nums[hi];
        int i = lo, j = hi;
        while (i < j) {
            if (nums[i++] > pivot) {                //Remember this form, this procedure!!!
                swap(nums, --i, --j);
            }
        }
        swap(nums, i, hi);
        
        int m = i - lo + 1;
        if (m == k) {
            return i;
        } else if (m > k) {
            return quickSelect(nums, lo, i - 1, k);
        } else {
            return quickSelect(nums, i + 1, hi, k - m);
        }
    }
    
    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}