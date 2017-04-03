// Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

// Example 1:

// 11110
// 11010
// 11000
// 00000
// Answer: 1

// Example 2:

// 11000
// 11000
// 00100
// 00011
// Answer: 3

public class Solution {
	public class Coordinate {
		public int x, y;         // must be public to access in the following precedure.
		public Coordinate(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

    public int numIslands(char[][] grid) {
    	int sum = 0;
    	if (grid == null || grid.length == 0 || grid[0].length == 0) {
    		return sum;
    	}
    	int m = grid.length;
    	int n = grid[0].length;
    	for (int i = 0; i < m; i++) {
    		for (int j = 0; j < n; j++) {
    			if (grid[i][j] == '1') {
    				sum++;
    				makedByBFS(i, j, grid);
    			}
    		}
    	}
    	return sum;
    }

    private void makedByBFS(int i, int j, char[][] grid) {
    	int[] directX = {0, 0, 1, -1};
    	int[] directY = {1, -1, 0, 0};
    	Queue<Coordinate> queue = new LinkedList<>();
    	grid[i][j] = '0';									//设为 0 的顺序一定要这样， 不然会超时
    	queue.offer(new Coordinate(i, j));
    	while (!queue.isEmpty()) {
 			// int size = queue.size();                     // level traverse is necessary.
	    	for (int k = 0; k < queue.size(); i++) {
	    		Coordinate cor = queue.poll();
	    		grid[cor.x][cor.y] = '0';
	    		for (int l = 0; l < 4; l++) {
	    			int cor_x = cor.x + directX[l];
	    			int cor_y = cor.y + directY[l];
	    			if (inBound(cor_x, cor_y, grid) && grid[cor_x][cor_y] == '1') {
	    				queue.offer(new Coordinate(cor_x, cor_y));
	    				grid[cor_x][cor_y] = '0';			//设为 0 的顺序一定要这样， 不然会超时
	    			}
	    		}
	    	}
	    }
    }

    private boolean inBound(int x, int y, char[][] grid) {
    	int m = grid.length;
    	int n = grid[0].length;
    	return (0 <= x && x < m && 0 <= y && y < n);
    }
}