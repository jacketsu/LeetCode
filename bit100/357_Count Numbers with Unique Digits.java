// Given a non-negative integer n, count all numbers with unique digits, x, where 0 ≤ x < 10n.

// Example:
// Given n = 2, return 91. (The answer should be the total numbers in the range of 0 ≤ x < 100, excluding [11,22,33,44,55,66,77,88,99])

// Credits:
// Special thanks to @memoryless for adding this problem and creating all test cases.


class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n < 1) return 1;                                //figure out the corner case at the very beginning
        int res = 10;
        int uniqueDigits = 9;
        int availableNumbers = 9;
        while (n-- > 1 && availableNumbers > 0) {
            uniqueDigits = uniqueDigits * availableNumbers;
            res += uniqueDigits;
            availableNumbers--;
        }
        
        return res;
    }
}