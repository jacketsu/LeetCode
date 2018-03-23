class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        for (int i = 0;  i < nums.length - 2; i++) {
            if (nums[i] > 0) continue;
            while (i != 0 && i < nums.length - 2 && nums[i - 1] == nums[i]) {               //duplicate rm
                i++;
            }
            twoSum(nums, res, i + 1, nums.length - 1, nums[i]);
        }
        
        return res;
    }
    
    public void twoSum(int[] nums, List<List<Integer>> res, int lo, int hi, int target) {
        while (lo < hi) {
            if (nums[lo] + nums[hi] == -target) {
                res.add(Arrays.asList(target, nums[lo], nums[hi]));
                lo++;
                hi--;
                while (lo < nums.length && nums[lo - 1] == nums[lo]) {                 //rm du plicate, corner cases
                    lo++;
                }
                while (hi > 0 && nums[hi] == nums[hi + 1]) {
                    hi--;
                }
            } else if (nums[lo] + nums[hi] > -target) {                                 //sign
                hi--;
            } else {
                lo++;
            }
        }
    }
}
