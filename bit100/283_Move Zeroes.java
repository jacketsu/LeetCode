public class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                continue;
            }
            int j = i;
            while (j < nums.length && nums[j] == 0) {              //sequence matters!!!! easily lead to index out fo bound
                j++;
            }
            if (j == nums.length) {
                return;
            }
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}