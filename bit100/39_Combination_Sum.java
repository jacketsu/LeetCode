class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return ans;
        List<Integer> subList = new ArrayList<>();
        helper(candidates, ans, subList, 0, 0, target);                 //position parameters to remove duplicate solutions
        return ans;
    }
    
    public void helper(int[] candidates, List<List<Integer>> ans, List<Integer> subList, int pos, int sum, int target) {
        if (sum == target) {
            ans.add(new ArrayList<Integer>(subList));
            return;
        } else if (sum > target) {
            return;
        } else {
            for (int i = pos; i < candidates.length; i++) {
                subList.add(candidates[i]);
                helper(candidates, ans, subList, i, sum + candidates[i], target);
                subList.remove(subList.size() - 1);
            }
        }
    }
}
