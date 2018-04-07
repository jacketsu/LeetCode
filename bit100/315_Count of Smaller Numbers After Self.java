// You are given an integer array nums and you have to return a new counts array. The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].

// Example:

// Given nums = [5, 2, 6, 1]

// To the right of 5 there are 2 smaller elements (2 and 1).
// To the right of 2 there is only 1 smaller element (1).
// To the right of 6 there is 1 smaller element (1).
// To the right of 1 there is 0 smaller element.
// Return the array [2, 1, 1, 0].
// 


class Solution {
    public List<Integer> countSmaller(int[] nums) {
        Integer[] res = new Integer[nums.length];
        List<Integer> list = new ArrayList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            int index = findIndex(list, nums[i]);
            res[i] = index;
            list.add(index, nums[i]);
        }
        
        return Arrays.asList(res);
    }
    
    public int findIndex(List<Integer> list, int target) {
        if (list.size() == 0) return 0;
        int start = 0;
        int end = list.size() - 1;
        if (list.get(start) >= target) {
                return start;
        } else if (list.get(end) < target) {
                return end + 1;
        }
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (list.get(mid) >= target) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        
        if (list.get(start) >= target) {
            return start;
        } else {
            return end;
        }
    }
}

