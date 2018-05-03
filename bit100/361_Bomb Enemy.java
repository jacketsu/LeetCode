// Given a 2D grid, each cell is either a wall 'W', an enemy 'E' or empty '0' (the number zero), return the maximum enemies you can kill using one bomb.
// The bomb kills all the enemies in the same row and column from the planted point until it hits the wall since the wall is too strong to be destroyed.
// Note that you can only put the bomb at an empty cell.

// Example:
// For the given grid

// 0 E 0 0
// E 0 W E
// 0 E 0 0

// return 3. (Placing a bomb at (1,1) kills 3 enemies)


class Solution {
    public int maxKilledEnemies(char[][] grid) {
        int max = 0;
        if (grid == null || grid.length == 0 || grid[0].length == 0) return max;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '0') {
                    max = Math.max(max, bomb(grid, i, j));
                }
            }
        }
        return max;
    }
    
    public int bomb(char[][] grid, int x, int y) {a
        int kills = 0;
        for (int i = x + 1; i < grid.length; i++) {
            if (grid[i][y] == 'E') {
                kills++;
            } else if (grid[i][y] == 'W') {
                break;
            }
        }
        for (int j = x - 1; j >= 0; j--) {
            if (grid[j][y] == 'E') {
                kills++;
            } else if (grid[j][y] == 'W') {
                break;
            }
        }
        for (int i = y + 1; i < grid[0].length; i++) {
            if (grid[x][i] == 'E') {
                kills++;
            } else if (grid[x][i] == 'W') {
                break;
            }
        }
        for (int j = y - 1; j >= 0; j--) {
            if (grid[x][j] == 'E') {
                kills++;
            } else if (grid[x][j] == 'W') {
                break;
            }
        }
        return kills;
    }
}