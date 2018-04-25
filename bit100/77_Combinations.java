// Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

// Example:

// Input: n = 4, k = 2
// Output:
// [
//   [2,4],
//   [3,4],
//   [2,3],
//   [1,2],
//   [1,3],
//   [1,4],
// ]

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        if (n <= 0 || k <= 0) return ans;
        helper(ans, new ArrayList<>(), 1, n, k);
        return ans;
    }
    
    public void helper(List<List<Integer>> ans, List<Integer> subList, int start, int n, int k) {
        if (subList.size() == k) {
            ans.add(new ArrayList<>(subList));
            return;
        }
        for (int i = start; i <= n; i++) {
            subList.add(i);
            helper(ans, subList, i + 1, n, k);              // i + 1 !!
            subList.remove(subList.size() - 1);
        }
    }
}