class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return ans;
        int rowBegin = 0, rowEnd = matrix.length - 1, colBegin = 0, colEnd = matrix[0].length - 1;
        while (rowBegin <= rowEnd && colBegin <= colEnd) {              // equal symbol!!
            if (rowBegin <= rowEnd) {
                for (int i = colBegin; i <= colEnd; i++) {
                    ans.add(matrix[rowBegin][i]);
                }
                rowBegin++;
            }
            if (colBegin <= colEnd) {
                for (int i = rowBegin; i <= rowEnd; i++) {
                    ans.add(matrix[i][colEnd]);
                }
                colEnd--;
            }
            if (rowBegin <= rowEnd) {
                for (int i = colEnd; i >= colBegin; i--) {
                    ans.add(matrix[rowEnd][i]);
                }
                rowEnd--;
            }
            if (colBegin <= colEnd) {
                for (int i = rowEnd; i >= rowBegin; i--) {
                    ans.add(matrix[i][colBegin]);
                }
                colBegin++;
            }
        }
        
        return ans;
        
    }
}
