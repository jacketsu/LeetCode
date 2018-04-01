// Implement a basic calculator to evaluate a simple expression string.

// The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .

// You may assume that the given expression is always valid.

// Some examples:
// "1 + 1" = 2
// " 2-1 + 2 " = 3
// "(1+(4+5+2)-3)+(6+8)" = 23
// Note: Do not use the eval built-in library function.


class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int result = 0, num = 0, sign = 1;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                num = num * 10 + (int)(c - '0');
            } else if (c == '+') {
                result += num * sign;
                num = 0;
                sign = 1;
            } else if (c == '-') {
                result += num * sign;
                num = 0;
                sign = -1;
            } else if (c == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } else if (c == ')') {                                      //number * sign !
                result += num * sign;
                result = stack.pop() * result + stack.pop();
                num = 0;
                sign = 1;
            }
        }
        
        if (num != 0) result += num * sign;
        return result;
    }
}