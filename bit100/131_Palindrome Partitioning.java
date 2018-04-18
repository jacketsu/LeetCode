// Given a string s, partition s such that every substring of the partition is a palindrome.

// Return all possible palindrome partitioning of s.

// For example, given s = "aab",
// Return

// [
//   ["aa","b"],
//   ["a","a","b"]
// ]

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        if (s == null || s.length() == 0) return ans;
        List<String> subList = new ArrayList<>();
        helper(ans, subList, s, 0);
        return ans;
    }
    
    public void helper(List<List<String>> ans, List<String> subList, String s, int index) {
        if (index == s.length()) {
            ans.add(new ArrayList<>(subList));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            String subStr = s.substring(index, i + 1);
            if (palindrome(subStr)) {
                subList.add(subStr);
                helper(ans, subList, s, i + 1);
                subList.remove(subList.size() - 1);
            }
        }
    }
    
    public boolean palindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    
    
}