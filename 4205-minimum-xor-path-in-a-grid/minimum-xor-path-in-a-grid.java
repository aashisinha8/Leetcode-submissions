class Solution {

    int m, n;
    int ans = Integer.MAX_VALUE;

    boolean[][][] visited;

    public int minCost(int[][] grid) {

        m = grid.length;
        n = grid[0].length;

        visited = new boolean[m][n][1024];//1024 max value for xor

        dfs(grid, 0, 0, 0);

        return ans;
    }

    private void dfs(int[][] grid, int i, int j, int xor) {

        xor = xor ^ grid[i][j];

        // Same state already processed
        if (visited[i][j][xor]) {
            return;
        }

        visited[i][j][xor] = true;

        // Destination
        if (i == m - 1 && j == n - 1) {
            ans = Math.min(ans, xor);
            return;
        }

        // Down
        if (i + 1 < m) {
            dfs(grid, i + 1, j, xor);
        }

        // Right
        if (j + 1 < n) {
            dfs(grid, i, j + 1, xor);
        }
    }
}