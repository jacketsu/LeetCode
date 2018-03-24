class Solution {
    int maxVal = Integer.MIN_VALUE;
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return maxVal;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            maxVal = Math.max(maxVal, sum);
            if (sum < 0) sum = 0;
        }
        
        return maxVal;
    }
}
