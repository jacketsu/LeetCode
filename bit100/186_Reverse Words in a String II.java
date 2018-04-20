// Given an input string, reverse the string word by word. A word is defined as a sequence of non-space characters.

// The input string does not contain leading or trailing spaces and the words are always separated by a single space.

// For example,
// Given s = "the sky is blue",
// return "blue is sky the".

// Could you do it in-place without allocating extra space?

// Related problem: Rotate Array

// Update (2017-10-16):
// We have updated the function signature to accept a character array, so please reset to the default code definition by clicking on the reload button above the code editor. Also, Run Code is now available!

class Solution {
    public void reverseWords(char[] str) {
        reverse(str, 0, str.length - 1);
        int i = 0, j = 0;
        while (j <= str.length) {
            if (j == str.length || str[j] == ' ') {
                reverse(str, i, j - 1);
                i = j + 1;
            }
            j++;
        }
    }
    
    public void reverse(char[] str, int lo, int hi) {
        while (lo < hi) {
            char tmp = str[lo];
            str[lo] = str[hi];
            str[hi] = tmp;
            lo++;
            hi--;
        }
    }
}