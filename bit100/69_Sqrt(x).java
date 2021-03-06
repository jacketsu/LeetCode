// Implement int sqrt(int x).

// Compute and return the square root of x.

// x is guaranteed to be a non-negative integer.


// Example 1:

// Input: 4
// Output: 2
// Example 2:

// Input: 8
// Output: 2
// Explanation: The square root of 8 is 2.82842..., and since we want to return an integer, the decimal part will be truncated.


class Solution {
    public int mySqrt(int x) {
        if (x <= 0) return 0;
        int lo = 1;
        int hi = x;
        while (lo <= hi) {
            long mid = lo + (hi - lo) / 2;
            if (mid * mid == x) {
                return (int)mid;
            } else if (mid * mid > x) {
                hi = (int)mid - 1;
            } else {
                lo = (int)mid + 1;
            }
        }
        if (hi * hi < x) {
            return hi;
        } else {
            return lo;
        }
    }
}