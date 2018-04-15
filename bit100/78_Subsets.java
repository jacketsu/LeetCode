// Given a set of distinct integers, nums, return all possible subsets (the power set).

// Note: The solution set must not contain duplicate subsets.

// For example,
// If nums = [1,2,3], a solution is:

// [
//   [3],
//   [1],
//   [2],
//   [1,2,3],
//   [1,3],
//   [2,3],
//   [1,2],
//   []
// ]


class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> subList = new ArrayList<>();
        helper(nums, ans, subList, 0);
        return ans;
    }
    
    public void helper(int[] nums, List<List<Integer>> ans, List<Integer> subList, int index) {
        ans.add(new ArrayList<>(subList));
        for (int i = index; i < nums.length; i++) {
            subList.add(nums[i]);
            helper(nums, ans, subList, i + 1);
            subList.remove(subList.size() - 1);
        }
    }
}