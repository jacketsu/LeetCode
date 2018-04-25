// Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

// Example:

// Input: 3
// Output:
// [
//  [ 1, 2, 3 ],
//  [ 8, 9, 4 ],
//  [ 7, 6, 5 ]
// ]


class Solution {
    public int[][] generateMatrix(int n) {
        if (n <= 0) return new int[0][0];
        int[][] matrix = new int[n][n];
        int num = 1;
        int rowBegin = 0, rowEnd = n - 1, colBegin = 0, colEnd = n - 1;
        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            for (int i = colBegin; i <= colEnd; i++) {
                matrix[rowBegin][i] = num++;
            }
            rowBegin++;
            
            for (int i = rowBegin; i<= rowEnd; i++) {
                matrix[i][colEnd] = num++;
            }
            colEnd--;
            
            for (int i = colEnd; i >= colBegin; i--) {
                matrix[rowEnd][i] = num++;
            }
            rowEnd--;
            
            for (int i = rowEnd; i >= rowBegin; i--) {
                matrix[i][colBegin] = num++;
            }
            colBegin++;
        }
        
        return matrix;
    }
}