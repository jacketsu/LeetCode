// Given a string representing an expression of fraction addition and subtraction, you need to return the calculation result in string format. The final result should be irreducible fraction. If your final result is an integer, say 2, you need to change it to the format of fraction that has denominator 1. So in this case, 2 should be converted to 2/1.

// Example 1:
// Input:"-1/2+1/2"
// Output: "0/1"
// Example 2:
// Input:"-1/2+1/2+1/3"
// Output: "1/3"
// Example 3:
// Input:"1/3-1/2"
// Output: "-1/6"
// Example 4:
// Input:"5/3+1/3"
// Output: "2/1"
// Note:
// The input string only contains '0' to '9', '/', '+' and '-'. So does the output.
// Each fraction (input and output) has format ±numerator/denominator. If the first input fraction or the output is positive, then '+' will be omitted.
// The input only contains valid irreducible fractions, where the numerator and denominator of each fraction will always be in the range [1,10]. If the denominator is 1, it means this fraction is actually an integer in a fraction format defined above.
// The number of given fractions will be in the range [1,10].
// The numerator and denominator of the final result are guaranteed to be valid and in the range of 32-bit int.


class Solution {
    public String fractionAddition(String expression) {
        List<String> strs = new ArrayList<>();
        int i = 0, j = 0;
        while (j <= expression.length()) {
            if (j == expression.length() || j != i && (expression.charAt(j) == '+' || expression.charAt(j) == '-')) {
                if (expression.charAt(i) == '+') {
                    strs.add(expression.substring(i + 1, j));
                } else {
                    strs.add(expression.substring(i, j));
                }
                i = j;
            }
            j++;
        }
        
        String result = "0/1";
        
        for (String num : strs) {
            result = addFraction(result, num);
        }
        
        return result;
    }
    
    public String addFraction(String s1, String s2) {
        String[] s1Arr = s1.split("/");
        String[] s2Arr = s2.split("/");
        int n1 = Integer.parseInt(s1Arr[0]);
        int d1 = Integer.parseInt(s1Arr[1]);
        int n2 = Integer.parseInt(s2Arr[0]);
        int d2 = Integer.parseInt(s2Arr[1]);
        
        int n = n1 * d2 + n2 * d1;
        int d = d1 * d2;
        
        boolean negative = n * d < 0;
        
        n = Math.abs(n);
        d = Math.abs(d);
        if (n == 0) return "0/1";                       //instead of n < d
        int gcd = comGCD(n, d);
        return (negative ? "-" : "") + n / gcd + "/" + d /gcd;
    }
    
    public int comGCD(int n, int d) {
        if (n == 0 || d == 0) return n + d;
        return comGCD(d, n % d);
    }
}