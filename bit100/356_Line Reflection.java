// Given n points on a 2D plane, find if there is such a line parallel to y-axis that reflect the given points.

// Example 1:
// Given points = [[1,1],[-1,1]], return true.

// Example 2:
// Given points = [[1,1],[-1,-1]], return false.

// Follow up:
// Could you do better than O(n2)?

// Credits:
// Special thanks to @memoryless for adding this problem and creating all test cases.


class Solution {
    public boolean isReflected(int[][] points) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        Set<String> set = new HashSet<>();
        for (int[] pair : points) {
            min = Math.min(min, pair[0]);
            max = Math.max(max, pair[0]);
            set.add(pair[0] + "," + pair[1]);
        }
        int sum = max + min;
        for (int[] pair : points) {
            if (!set.contains(sum - pair[0] + "," + pair[1])) {
                return false;
            }
        }
        return true;
    }
}