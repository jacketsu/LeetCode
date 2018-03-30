class Solution {
    public int maxProduct(int[] nums) {
        int r = nums[0];
        int imax = r;
        int imin = r;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                int tmp = imax;
                imax = imin;
                imin = tmp;
            }
            
            imax = Math.max(nums[i], imax * nums[i]);
            imin = Math.min(nums[i], imin * nums[i]);
            
            r = Math.max(r, imax);
        }
        
        return r;
    }
    
}
