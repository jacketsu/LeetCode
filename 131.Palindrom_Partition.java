// Given a string s, partition s such that every substring of the partition is a palindrome.

// Return all possible palindrome partitioning of s.

// Given s = "aab", return:

// [
//   ["aa","b"],
//   ["a","a","b"]
// ]




public class Solution {
    /**
     * @param s: A string
     * @return: A list of lists of string
     */
    public List<List<String>> partition(String s) {
        // write your code here
        List<List<String>> result = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return result;
        }
        List<String> partition = new ArrayList<>();
        helper(s, 0, partition, result);
        return result;
    }
    
    private void helper(String s, 
                        int startIndex, 
                        List<String> partition, 
                        List<List<String>> result) {
        if (startIndex == s.length()) {
            result.add(new ArrayList<String>(partition));
        }
        for (int i = startIndex; i < s.length(); i++) {
            String sub = s.substring(startIndex, i + 1);
            if (!palindrome(sub)) {
                continue;
            }
            partition.add(sub);
            helper(s, i + 1, partition, result);
            partition.remove(partition.size() - 1);
        }
    }
    
    private boolean palindrome(String sub) {
        for (int i = 0, j = sub.length() - 1;
             i < j;
             i++, j--) {
            if (sub.charAt(i) != sub.charAt(j)) {
                return false;
            }         
        }
        return true;
    }
}