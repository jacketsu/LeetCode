// Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

// You may assume no duplicates in the array.

// Example 1:

// Input: [1,3,5,6], 5
// Output: 2
// Example 2:

// Input: [1,3,5,6], 2
// Output: 1
// Example 3:

// Input: [1,3,5,6], 7
// Output: 4
// Example 4:

// Input: [1,3,5,6], 0
// Output: 0

class Solution {
    public int searchInsert(int[] nums, int target) {
        // int start = 0, end = nums.length - 1;
        // while (start + 1 < end) {
        //     int mid = start + (end - start) / 2;
        //     if (nums[mid] == target) {
        //         return mid;
        //     } else if (nums[mid] < target) {
        //         start = mid;
        //     } else {
        //         end = mid;
        //     }
        // }
        // if (target <= nums[start]) {
        //     return start;
        // } else if (target <= nums[end]) {
        //     return end;
        // } else {
        //     return end + 1;
        // }
        
        int start = 0, end = nums.length - 1;
        while (start <= end) {                              //"=" for the index can out of line
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }
}