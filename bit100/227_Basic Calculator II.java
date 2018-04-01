// Implement a basic calculator to evaluate a simple expression string.

// The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.

// You may assume that the given expression is always valid.

// Some examples:
// "3+2*2" = 7
// " 3/2 " = 1
// " 3+5 / 2 " = 5
// Note: Do not use the eval built-in library function.

// Credits:
// Special thanks to @ts for adding this problem and creating all test cases.


class Solution {
    public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        int sign = '+';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + (int)(c - '0');
            }
            
            if (!Character.isDigit(c) && c != ' ' || i == s.length() - 1) {         //num = 0, sign = c only code for a one time
                if (sign == '+') {
                    stack.push(num);
                } else if (sign == '-') {
                    stack.push(- num);
                } else if (sign == '*') {
                    stack.push(stack.pop() * num);
                } else if (sign == '/') {
                    stack.push(stack.pop() / num);
                }
                
                num = 0;
                sign = c;
            }
        }
        
        int re = 0;
        for (int n : stack) {
            re += n;
        }
        
        return re;
    }
}