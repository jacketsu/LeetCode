// Find the nth digit of the infinite integer sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...

// Note:
// n is positive and will fit within the range of a 32-bit signed integer (n < 231).

// Example 1:

// Input:
// 3

// Output:
// 3
// Example 2:

// Input:
// 11

// Output:
// 0

// Explanation:
// The 11th digit of the sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... is a 0, which is part of the number 10.

class Solution {
    public int findNthDigit(int n) {
        int start = 1;
        long base = 9L;                             //base have to be long, in case of overflow
        int count = 1;
        while (n > base * count) {
            n -= (base * count);
            base *= 10;
            start *= 10;
            count += 1;
        }
        int target = start + (n - 1) / count;
        return String.valueOf(target).charAt((n - 1) % count) - '0';
    }
}