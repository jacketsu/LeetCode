// Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

// Each number in candidates may only be used once in the combination.

// Note:

// All numbers (including target) will be positive integers.
// The solution set must not contain duplicate combinations.
// Example 1:

// Input: candidates = [10,1,2,7,6,1,5], target = 8,
// A solution set is:
// [
//   [1, 7],
//   [1, 2, 5],
//   [2, 6],
//   [1, 1, 6]
// ]
// Example 2:

// Input: candidates = [2,5,2,1,2], target = 5,
// A solution set is:
// [
//   [1,2,2],
//   [5]
// ]


class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return ans;
        }
        Arrays.sort(candidates);
        helper(ans, new ArrayList<Integer>(), candidates, 0, target);
        return ans;
    }
    
    public void helper(List<List<Integer>> ans, List<Integer> subList, int[] candidates, int index, int target) {
        if (target < 0) return;
        if (0 == target) {
            ans.add(new ArrayList<>(subList));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            subList.add(candidates[i]);
            helper(ans, subList, candidates, i + 1, target - candidates[i]);
            subList.remove(subList.size() - 1);
        }
    }
}