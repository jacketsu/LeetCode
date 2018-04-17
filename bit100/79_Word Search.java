// Given a 2D board and a word, find if the word exists in the grid.

// The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

// For example,
// Given board =

// [
//   ['A','B','C','E'],
//   ['S','F','C','S'],
//   ['A','D','E','E']
// ]
// word = "ABCCED", -> returns true,
// word = "SEE", -> returns true,
// word = "ABCB", -> returns false.

class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, visited, m, n, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean dfs(char[][] board, String word, boolean[][] visited, int m, int n, int i, int j, int index) {
        if (index == word.length()) {
            return true;
        }
        if (i >= 0 && i < m && j >= 0 && j < n && visited[i][j] == false && word.charAt(index) == board[i][j]) {
            visited[i][j] = true;
            boolean search = (dfs(board, word, visited, m, n, i + 1, j, index + 1) || dfs(board, word, visited, m, n, i - 1, j, index + 1) || dfs(board, word, visited, m, n, i, j + 1, index + 1) || dfs(board, word, visited, m, n, i, j - 1, index + 1));
            visited[i][j] = false;
            return search;
        }
        return false;
    }
}