class Solution {
    int maxLen = 1;
    int maxStart = 0;
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";
        for (int i = 0; i < s.length(); i++) {
            extend(s, i, i);
            extend(s, i, i + 1);
        }
        
        return s.substring(maxStart, maxStart + maxLen);
    }
    
    public void extend(String s, int start, int end) {
        if (start < 0 || end >= s.length() || start > end) return;
        if (s.charAt(start) == s.charAt(end)) {
            if (maxLen < (end - start + 1)) {
                maxLen = end - start + 1;
                maxStart = start;
            }
            extend(s, start - 1, end + 1);
        }
    }
}
