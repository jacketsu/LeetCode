// Given an integer matrix, find the length of the longest increasing path.

// From each cell, you can either move to four directions: left, right, up or down. You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).

// Example 1:

// nums = [
//   [9,9,4],
//   [6,6,8],
//   [2,1,1]
// ]
// Return 4
// The longest increasing path is [1, 2, 6, 9].

// Example 2:

// nums = [
//   [3,4,5],
//   [3,2,6],
//   [2,2,1]
// ]
// Return 4
// The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.

// Credits:
// Special thanks to @dietpepsi for adding this problem and creating all test cases.
// 


class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int[][] cache = new int[m][n];
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int max = dfs(matrix, i, j, Integer.MIN_VALUE, m, n, cache);
                res = Math.max(res, max);
            }
        }
        
        return res;
    }
    
    public int dfs(int[][] matrix, int i, int j, int min, int m, int n, int[][] cache) {
        if (i < 0 || j < 0 || i >= m || j >= n || matrix[i][j] <= min) return 0;
        if (cache[i][j] != 0) {
            return cache[i][j];
        }
        min = matrix[i][j];
        int a = dfs(matrix, i + 1, j, min, m, n, cache) + 1;                // +1
        int b = dfs(matrix, i - 1, j , min, m, n, cache) + 1;
        int c = dfs(matrix, i, j + 1, min, m, n, cache) + 1;
        int d = dfs(matrix, i, j - 1, min, m, n, cache) + 1;
        int max = Math.max(a, Math.max(b, Math.max(c, d)));
        cache[i][j] = max;
        return max;
    }
}