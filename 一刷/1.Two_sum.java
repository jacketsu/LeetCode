// Given an array of integers, return indices of the two numbers such that they add up to a specific target.

// You may assume that each input would have exactly one solution, and you may not use the same element twice.

// Example:
// Given nums = [2, 7, 11, 15], target = 9,

// Because nums[0] + nums[1] = 2 + 7 = 9,
// return [0, 1].
// Show Company Tags
// Show Tags
// Show Similar Problems


public class Solution {
    public int[] twoSum(int[] nums, int target) {
    	int[] result = new int[2];
   		if (nums == null || nums.length == 0) {
   			return result;
   		}

   		HashMap<Integer, Integer> map = new HashMap<>();
   		for (int i = 0; i < nums.length; i++) {
   			if (map.containsKey(nums[i])) {
   				result[0] = map.get(nums[i]);
   				result[1] = i;
   			} else {
   				map.put(target - nums][i], i)；
   			}
   		}
    }
}