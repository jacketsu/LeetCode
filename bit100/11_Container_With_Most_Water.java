class Solution {
    public int maxArea(int[] height) {
        int maxA = 0;
        int lo = 0, hi = height.length - 1;
        while (lo < hi) {
            maxA = Math.max(maxA, Math.min(height[lo], height[hi]) * (hi - lo));
            if (height[lo] <= height[hi]) {
                lo++;
            } else {
                hi--;
            }
        }
        
        return maxA;
    }
}
