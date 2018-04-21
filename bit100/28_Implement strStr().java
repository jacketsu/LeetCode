// Implement strStr().

// Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

// Example 1:

// Input: haystack = "hello", needle = "ll"
// Output: 2
// Example 2:

// Input: haystack = "aaaaa", needle = "bba"
// Output: -1
// Clarification:

// What should we return when needle is an empty string? This is a great question to ask during an interview.

// For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().


class Solution {
    public int strStr(String haystack, String needle) {
        //String comparision used "equals"
        if (needle.equals("")) return 0;
        if (haystack == null) return -1;
        for (int i = 0; i < haystack.length(); i++) {
            if (match(haystack, i, needle)) {
                return i;
            }
        }
        
        return -1;
    }
    
    public boolean match(String haystack, int start, String needle) {
        int i = 0;
        while (start < haystack.length() && i < needle.length()) {
            if (haystack.charAt(start) != needle.charAt(i)) {
                return false;
            }
            start++;
            i++;
        }
        return i == needle.length();
    }
}