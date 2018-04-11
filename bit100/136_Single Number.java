// Given an array of integers, every element appears twice except for one. Find that single one.

// Note:
// Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

// Seen this question in a real interview before?  


class Solution {
    public int singleNumber(int[] nums) {
        int single = nums[0];
        for (int i = 1; i < nums.length; i++) {
            single = single ^ nums[i];
        }
        return single;
    }
}