// Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

// If the fractional part is repeating, enclose the repeating part in parentheses.

// For example,

// Given numerator = 1, denominator = 2, return "0.5".
// Given numerator = 2, denominator = 1, return "2".
// Given numerator = 2, denominator = 3, return "0.(6)".
// Credits:
// Special thanks to @Shangrila for adding this problem and creating all test cases.

class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";
        StringBuilder sb = new StringBuilder();
        if ((numerator > 0) ^ (denominator > 0)) sb.append("-");
        long n = Math.abs((long)numerator);
        long d = Math.abs((long)denominator);
        sb.append(n / d);
        n %= d;
        if (n == 0) return sb.toString();
        sb.append(".");
        Map<Long, Integer> map = new HashMap<>();                               //Remember the sequence!
        map.put(n, sb.length());
        while (n != 0) {
            n *= 10;
            sb.append(n / d + "");
            n %= d;
            if (map.containsKey(n)) {
                int index = map.get(n);
                sb.insert(index, "(");
                sb.append(")");
                return sb.toString();
            } else {
                map.put(n, sb.length());
            }
        }
        
        return sb.toString();
    }
}