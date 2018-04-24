// Given a collection of numbers that might contain duplicates, return all possible unique permutations.

// Example:

// Input: [1,1,2]
// Output:
// [
//   [1,1,2],
//   [1,2,1],
//   [2,1,1]
// ]


class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);                              //Sort!
        if (nums == null || nums.length == 0) return list;
        boolean[] used = new boolean[nums.length];
        helper(list,new ArrayList<Integer>(), nums, used);
        return list;
    }
    
    public void helper(List<List<Integer>> list, List<Integer> subList, int[] nums, boolean[] used) {
        if (subList.size() == nums.length) {
            list.add(new ArrayList<>(subList));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] || i > 0 && nums[i - 1] == nums[i] && !used[i - 1]) {
                continue;
            }
            subList.add(nums[i]);
            used[i] = true;
            helper(list,subList,nums,used);
            used[i] = false;
            subList.remove(subList.size() - 1);
        }
    }
}