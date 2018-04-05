class NumMatrix {
    int[][] nums;
    int[][] tree;
    int m;
    int n;
    
    public NumMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
        this.m = matrix.length;
        this.n = matrix[0].length;
        this.nums = new int[m][n];
        this.tree = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                update(i, j, matrix[i][j]);
            }
        }
    }
    
    public void update(int row, int col, int val) {
        if (this.m == 0 || this.n == 0) return;
        int diff = val - this.nums[row][col];
        this.nums[row][col] = val;
        for (int i = row + 1; i <= this.m; i += (i & (-i))) {
            for (int j = col + 1; j <= this.n; j += (j & (-j))) {
                this.tree[i][j] += diff;
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (this.m == 0 || this.n == 0) return 0;                       //corner cases
        return sum(row2 + 1, col2 + 1) + sum(row1, col1) - sum(row1, col2 + 1) - sum(row2 + 1, col1);
    }
    
    public int sum(int row, int col) {
        int sum = 0;
        for (int i = row; i > 0; i -= (i & (-i))) {
            for (int j = col; j > 0; j -= (j & (-j))) {
                sum += (this.tree[i][j]);
            }
        }
        
        return sum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * obj.update(row,col,val);
 * int param_2 = obj.sumRegion(row1,col1,row2,col2);
 */