// Given an encoded string, return it's decoded string.

// The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

// You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

// Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].

// Examples:

// s = "3[a]2[bc]", return "aaabcbc".
// s = "3[a2[c]]", return "accaccacc".
// s = "2[abc]3[cd]ef", return "abcabccdcdcdef".

class Solution {
    public String decodeString(String s) {
        if (s == null || s.length() == 0) return "";
        Stack<Integer> countStack = new Stack<>();
        Stack<String> strStack = new Stack<>();
        int index = 0;
        String res = "";
        while (index < s.length()) {
            if (Character.isDigit(s.charAt(index))) {
                int count = 0;
                while (Character.isDigit(s.charAt(index))) {
                    count = count * 10 + s.charAt(index) - '0';
                    index++;
                }
                countStack.push(count);
            } else if (s.charAt(index) == '[') {
                strStack.push(res);
                res = "";
                index++;
            } else if (s.charAt(index) == ']') {
                StringBuilder tmp = new StringBuilder(strStack.pop());
                int times = countStack.pop();
                for (int i = 0; i < times; i++) {
                    tmp.append(res);
                }
                res = tmp.toString();
                index++;
            } else {
                res = res + s.charAt(index);
                index++;
            }
        }
        
        return res;
    }
}