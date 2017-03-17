// Given a list of numbers, return all possible permutations.

// For nums = [1,2,3], the permutations are:

// [
//   [1,2,3],
//   [1,3,2],
//   [2,1,3],
//   [2,3,1],
//   [3,1,2],
//   [3,2,1]
// ]

class Solution {
    /**
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public List<List<Integer>> permute(int[] nums) {
        ArrayList<List<Integer>> results = new ArrayList<List<Integer>>();
        if (nums == null) {
            return results;
        }
        
        if (nums.length == 0) {
            results.add(new ArrayList<Integer>());
            return results;
        }
        
        ArrayList<Integer> sublist = new ArrayList<Integer>();
        listHelper(nums, sublist, results);
        
        return results;
    }
    
    public void listHelper(int[] nums, ArrayList<Integer> sublist,
        ArrayList<List<Integer>> results) {
        if (sublist.size() == nums.length) {
            results.add(new ArrayList<Integer>(sublist));
        }
        
        for(int i = 0; i < nums.length; i++) {
            if (sublist.contains(nums[i])) {
                continue;
            }
            
            sublist.add(nums[i]);
            listHelper(nums, sublist, results);
            sublist.remove(sublist.size() - 1);
        }
    }
}
