// Given a string array words, find the maximum value of length(word[i]) * length(word[j]) where the two words do not share common letters. You may assume that each word will contain only lower case letters. If no such two words exist, return 0.

// Example 1:
// Given ["abcw", "baz", "foo", "bar", "xtfn", "abcdef"]
// Return 16
// The two words can be "abcw", "xtfn".

// Example 2:
// Given ["a", "ab", "abc", "d", "cd", "bcd", "abcd"]
// Return 4
// The two words can be "ab", "cd".

// Example 3:
// Given ["a", "aa", "aaa", "aaaa"]
// Return 0
// No such pair of words.

// Credits:
// Special thanks to @dietpepsi for adding this problem and creating all test cases.


class Solution {
    public int maxProduct(String[] words) {
        if (words == null || words.length == 0) return 0;
        int maxLen = 0;
        int[] vals = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                vals[i] |= (1 << (words[i].charAt(j) - 'a'));
            }
        }
        
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if ((vals[i] & vals[j]) == 0) {                                     // & operation should be add parenthesis..
                    maxLen = Math.max(maxLen, words[i].length() * words[j].length());
                }
            }
        }
        
        return maxLen;
    }
}