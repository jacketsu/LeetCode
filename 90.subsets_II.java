// Given a collection of integers that might contain duplicates, nums, return all possible subsets.

// Note: The solution set must not contain duplicate subsets.

// For example,
// If nums = [1,2,2], a solution is:

// [
//   [2],
//   [1],
//   [1,2,2],
//   [2,2],
//   [1,2],
//   []
// ]


class Solution {
    /**
     * @param nums: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] nums) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        if (nums == null || nums.length == 0) {
            return results;
        }
        
        ArrayList<Integer> subset = new ArrayList<Integer>();
        Arrays.sort(nums);
        subsetsHelper(nums, 0, subset, results);
        
        return results;
    }
    
    private void subsetsHelper(int[] nums, int startIndex, ArrayList<Integer> subset,
        ArrayList<ArrayList<Integer>> results) {
        results.add(new ArrayList<Integer>(subset));
        
        for (int i = startIndex; i < nums.length; i++) {
            if(i > startIndex && nums[i] == nums[i - 1]) {
                continue;
            }
            
            subset.add(nums[i]);
            subsetsHelper(nums, i + 1, subset, results);
            subset.remove(subset.size() - 1);
        }
    }
}
