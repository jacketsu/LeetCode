// Given a string, determine if a permutation of the string could form a palindrome.

// For example,
// "code" -> False, "aab" -> True, "carerac" -> True.

// Seen this question in a real interview before?  


class Solution {
    public boolean canPermutePalindrome(String s) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (!set.contains(s.charAt(i))) {
                set.add(s.charAt(i));                   //add
            } else {
                set.remove(s.charAt(i));                //remove
            }
        }
        if (set.size() <= 1) {
            return true;
        }
        return false;
    }
}