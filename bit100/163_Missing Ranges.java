// Given a sorted integer array nums, where the range of elements are in the inclusive range [lower, upper], return its missing ranges.

// Example:

// Input: nums = [0, 1, 3, 50, 75], lower = 0 and upper = 99,
// Output: ["2", "4->49", "51->74", "76->99"]


class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> ans = new ArrayList<>();
        int next = lower;
        if (lower == Integer.MAX_VALUE) return ans;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < next) {
                continue;
            } else if (nums[i] == next) {
                next++;
                continue;
            } else {
                ans.add(getRange(next, nums[i] - 1));
                if (nums[i] == Integer.MAX_VALUE) return ans;
                next = nums[i] + 1;
            }
        }
        if (next <= upper) {
            ans.add(getRange(next, upper));
        }
        return ans;
    }
    
    public String getRange(int lo, int hi) {
        if (lo == hi) {
            return String.valueOf(lo);
        } else {
            return lo + "->" + hi;
        }
    }
}