// Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

// Note:

// The solution set must not contain duplicate triplets.

// Example:

// Given array nums = [-1, 0, 1, 2, -1, -4],

// A solution set is:
// [
//   [-1, 0, 1],
//   [-1, -1, 2]
// ]


class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length == 0) return ans;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) continue;                  //remove duplicate combinations
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                if (nums[j] + nums[k] == -nums[i]) {
                    ans.add(Arrays.asList(nums[i], nums[j], nums[k]));       //remember the APIs
                    while(j < k && nums[j] == nums[j + 1]) j++;
                    while(k > j && nums[k] == nums[k - 1]) k--;
                    j++;
                    k--;
                } else if (nums[j] + nums[k] > -nums[i]) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return ans;
    }
}