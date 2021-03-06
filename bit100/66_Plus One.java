// Given a non-empty array of digits representing a non-negative integer, plus one to the integer.

// The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.

// You may assume the integer does not contain any leading zero, except the number 0 itself.

// Example 1:

// Input: [1,2,3]
// Output: [1,2,4]
// Explanation: The array represents the integer 123.
// Example 2:

// Input: [4,3,2,1]
// Output: [4,3,2,2]
// Explanation: The array represents the integer 4321.


class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 0;
        int n = digits.length;
        int sum = digits[n - 1] + 1;
        carry = sum / 10;
        digits[n - 1] = sum % 10;
        for (int i = n - 2; i >= 0; i--) {
            sum = carry + digits[i];
            carry = sum / 10;
            digits[i] = sum % 10;
        }
        if (carry > 0) {
            int[] res = new int[n + 1];
            res[0] = 1;
            for (int i = 1; i < n + 1; i++) {
                res[i] = digits[i - 1];
            }
            return res;
        }
        return digits;
    }
}