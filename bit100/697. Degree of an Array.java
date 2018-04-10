// Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum frequency of any one of its elements.

// Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.

// Example 1:
// Input: [1, 2, 2, 3, 1]
// Output: 2
// Explanation: 
// The input array has a degree of 2 because both elements 1 and 2 appear twice.
// Of the subarrays that have the same degree:
// [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
// The shortest length is 2. So return 2.
// Example 2:
// Input: [1,2,2,3,1,4,2]
// Output: 6
// Note:

// nums.length will be between 1 and 50,000.
// nums[i] will be an integer between 0 and 49,999.
// 


class Solution {
    public int findShortestSubArray(int[] nums) {
        if (nums == null || nums.length <= 0) return 0;
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer[]> mapRan = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) > max) {
                max = map.get(num);
            }
            if (!mapRan.containsKey(num)) mapRan.put(num, new Integer[2]);
            Integer[] range = mapRan.get(num);
            if (range[0] == null) range[0] = i;
            range[1] = i;
        }
        
        int minLen = nums.length;
        for (int num : nums) {
            if (map.get(num) == max) {
                Integer[] range = mapRan.get(num);
                minLen = Math.min(minLen, range[1] - range[0] + 1);
            }
        }
        
        return minLen;
    }
}