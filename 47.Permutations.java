
// Given a collection of numbers that might contain duplicates, return all possible unique permutations.

// For example,
// [1,1,2] have the following unique permutations:
// [
//   [1,1,2],
//   [1,2,1],
//   [2,1,1]
// ]

class Solution {
    /**
     * @param nums: A list of integers.
     * @return: A list of unique permutations.
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        ArrayList<List<Integer>> results = new ArrayList<List<Integer>>();
        if (nums == null) {
            return results;
        }
        
        if (nums.length == 0) {
            results.add(new ArrayList<Integer>());
            return results;
        }
        int[] visited = new int[nums.length];
        
        for (int i = 0; i < nums.length; i++) {
            visited[i] = 0;
        }
        
        Arrays.sort(nums);
        
        ArrayList<Integer> sublist = new ArrayList<Integer>();
        listHelper(nums, sublist, results, visited);
        
        return results;
    }
    
    public void listHelper(int[] nums, ArrayList<Integer> sublist,
        ArrayList<List<Integer>> results, int[] visited) {
        if (sublist.size() == nums.length) {
            results.add(new ArrayList<Integer>(sublist));
            return;
        }
        
        for(int i = 0; i < nums.length; i++) {
            if (visited[i] == 1 || (i != 0 && nums[i] == nums[i - 1] && visited[i - 1] == 0)d) {
                continue;
            }
            visited[i] = 1;
            sublist.add(nums[i]);
            listHelper(nums, sublist, results, visited);
            sublist.remove(sublist.size() - 1);
            visited[i] = 0;
        }
    } 
}
