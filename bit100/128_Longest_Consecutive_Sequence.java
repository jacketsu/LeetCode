class Solution {
    public int longestConsecutive(int[] nums) {
        int maxLen = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {                                //skip duplicates
            if (!map.containsKey(n)) {
                int left = map.containsKey(n - 1) ? map.get(n - 1) : 0;
                int right = map.containsKey(n + 1) ? map.get(n + 1) : 0;
                int sum = left + right + 1;
                maxLen = Math.max(maxLen, sum);
                map.put(n, sum);
                map.put(n - left, sum);
                map.put(n + right, sum);
            } else {
                continue;
            }
        }
        
        return maxLen;
    }
}
