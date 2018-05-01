// You are given a m x n 2D grid initialized with these three possible values.

// -1 - A wall or an obstacle.
// 0 - A gate.
// INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
// Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.

// For example, given the 2D grid:
// INF  -1  0  INF
// INF INF INF  -1
// INF  -1 INF  -1
//   0  -1 INF INF
// After running your function, the 2D grid should be:
//   3  -1   0   1
//   2   2   1  -1
//   1  -1   2  -1
//   0  -1   3   4


class Solution {
    class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0 || rooms[0].length == 0) {
            return;
        }
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    bfs(rooms, i, j);
                }
            }
        }
    }
    
    public void bfs(int[][] rooms, int x, int y) {
        int[] _x = new int[]{1, -1, 0, 0};
        int[] _y = new int[]{0, 0, -1, 1};
        Queue<Point> q = new LinkedList<>();
        int step = 0;
        q.offer(new Point(x, y));
        while (!q.isEmpty()) {
            int size = q.size();
            step++;
            for (int i = 0; i < size; i++) {
                Point p = q.poll();
                for (int k = 0; k < 4; k++) {               //Pay attention to variable name
                    int n_x = p.x + _x[k];
                    int n_y = p.y + _y[k];
                    if (n_x >= 0 && n_x < rooms.length && n_y >= 0 && n_y < rooms[0].length && rooms[n_x][n_y] != -1 && step < rooms[n_x][n_y]) {
                        rooms[n_x][n_y] = step;
                        q.offer(new Point(n_x, n_y));
                    }
                }
            }
        }
    }
}