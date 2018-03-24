class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        if (n <= 0) return ans;
        helper(ans, "", n, n);
        return ans;
    }
    
    public void helper(List<String> ans, String s, int left, int right) {
        if (left == 0 && right == 0) {
            ans.add(s);
            return;
        }
        if (left < 0 || right < 0 || left > right) return;
        helper(ans, s + "(", left - 1, right);
        helper(ans, s + ")", left, right - 1);
    }
}
