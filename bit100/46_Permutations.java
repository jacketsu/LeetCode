// Given a collection of distinct integers, return all possible permutations.

// Example:

// Input: [1,2,3]
// Output:
// [
//   [1,2,3],
//   [1,3,2],
//   [2,1,3],
//   [2,3,1],
//   [3,1,2],
//   [3,2,1]
// ]

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length == 0) return ans;
        helper(ans, new ArrayList<>(), nums);
        return ans;
    }
    
    public void helper(List<List<Integer>> ans, List<Integer> subList, int[] nums) {
        if (subList.size() == nums.length) {
            ans.add(new ArrayList<>(subList));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (subList.contains(nums[i])) continue;
            subList.add(nums[i]);
            helper(ans, subList, nums);
            subList.remove(subList.size() - 1);
        }
    }
}