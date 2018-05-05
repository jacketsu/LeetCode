// Given two strings s and t which consist of only lowercase letters.

// String t is generated by random shuffling string s and then add one more letter at a random position.

// Find the letter that was added in t.

// Example:

// Input:
// s = "abcd"
// t = "abcde"

// Output:
// e

// Explanation:
// 'e' is the letter that was added.


class Solution {
    public char findTheDifference(String s, String t) {
        int xor = 0;
        for (char ch : s.toCharArray()) {
            xor ^= (int)ch;
        }
        for (char ch : t.toCharArray()) {
            xor ^= (int)ch;
        }
        return (char)xor;
    }
}