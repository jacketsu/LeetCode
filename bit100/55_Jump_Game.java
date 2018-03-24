class Solution {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length <= 1) return true;
        int last = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (i + nums[i] >= last) last = i;
        }
        
        return last <= 0;
    }
}
