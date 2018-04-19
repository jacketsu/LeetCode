// Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

// Example:

// Given array nums = [-1, 2, 1, -4], and target = 1.

// The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).


class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int close = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                i++;
            }
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                if (Math.abs(close - target) > Math.abs(nums[i] + nums[j] + nums[k] - target)) {
                    close = nums[i] + nums[j] + nums[k];
                }
                if (nums[i] + nums[j] + nums[k] > target) {
                    k--;
                } else if (nums[i] + nums[j] + nums[k] < target) {
                    j++;
                } else {
                    return target;
                }
            }
        }
        return close;
    }
}