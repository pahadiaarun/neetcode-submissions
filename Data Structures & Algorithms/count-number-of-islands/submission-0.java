class Solution {
    private void isIsland(char[][] grid, int i, int j, int m, int n) {
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return;
        }
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {i, j});
        while (!q.isEmpty()) {
            int[] index = q.poll();
            int x = index[0];
            int y = index[1];

            if (x + 1 < m && grid[x + 1][y] == '1') {
                grid[x + 1][y] = '0';
                q.offer(new int[] {x + 1, y});
            }

            if (x - 1 >= 0 && grid[x - 1][y] == '1') {
                grid[x - 1][y] = '0';
                q.offer(new int[] {x - 1, y});
            }

            if (y + 1 < n && grid[x][y + 1] == '1') {
                grid[x][y + 1] = '0';
                q.offer(new int[] {x, y + 1});
            }

            if (y - 1 >= 0 && grid[x][y - 1] == '1') {
                grid[x][y - 1] = '0';
                q.offer(new int[] {x, y - 1});
            }
        }
    }
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    isIsland(grid, i, j, m, n);
                    res++;
                }
            }
        }
        return res;
    }
}
