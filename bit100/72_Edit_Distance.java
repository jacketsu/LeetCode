class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] cost = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            cost[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            cost[0][j] = j;
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    cost[i + 1][j + 1] = cost[i][j];
                } else {
                    int insertion = cost[i + 1][j];
                    int deletion = cost[i][j + 1];
                    int substitution = cost[i][j];

                    int min = Math.min(insertion, Math.min(deletion, substitution));
                    cost[i + 1][j + 1] = min + 1;
                }
            }
        }
        
        return cost[m][n];
    }
}
