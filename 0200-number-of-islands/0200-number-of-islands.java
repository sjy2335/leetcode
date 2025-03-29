class Solution {
    private int m, n;
    private boolean[][] visited;
    private final int[] dr = {-1, 0, 0, 1};
    private final int[] dc = {0, -1, 1, 0};

    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m][n];
        
        int islands = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '0') continue;
                if (visited[i][j]) continue;
                dfs(grid, i, j);
                islands++;
            }
        }

        return islands;
    }

    private void dfs(char[][] grid, int r, int c) {
        visited[r][c] = true;
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (nr < 0 || nc < 0 || nr >= m || nc >= n) continue;
            if (grid[nr][nc] == '0') continue;
            if (visited[nr][nc]) continue;
            dfs(grid, nr, nc);
        }
    }
}