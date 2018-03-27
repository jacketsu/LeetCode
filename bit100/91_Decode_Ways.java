class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        
        for (int i = 2; i <= s.length(); i++) {
            if ((Integer.parseInt(s.substring(i - 2, i))) <= 26 && (Integer.parseInt(s.substring(i - 2, i))) >= 10) {
                dp[i] += dp[i - 2];
            }
            
            if ((Integer.parseInt(s.substring(i - 1, i))) != 0) {
                dp[i] += dp[i - 1];
            }
        }
        
        return dp[s.length()];
    }
}
