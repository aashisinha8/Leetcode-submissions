class Solution {

    public boolean hasValidPath(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];

        return dfs(grid, 0, 0, visited);
    }

    private boolean dfs(int[][] grid, int r, int c,
                        boolean[][] visited) {

        int m = grid.length;
        int n = grid[0].length;

        if (r == m - 1 && c == n - 1) {
            return true;
        }

        visited[r][c] = true;

        int type = grid[r][c];

        // left, right, up, down
        int[][] directions = {
            {0, -1},
            {0, 1},
            {-1, 0},
            {1, 0}
        };

        for (int[] dir : directions) {

            int nr = r + dir[0];
            int nc = c + dir[1];

            if (nr < 0 || nr >= m ||
                nc < 0 || nc >= n ||
                visited[nr][nc]) {
                continue;
            }

            if (canMove(type, grid[nr][nc], dir[0], dir[1])) {

                if (dfs(grid, nr, nc, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean canMove(int current, int next,
                            int dr, int dc) {

        // Moving LEFT
        if (dr == 0 && dc == -1) {
            return hasLeft(current) && hasRight(next);
        }

        // Moving RIGHT
        if (dr == 0 && dc == 1) {
            return hasRight(current) && hasLeft(next);
        }

        // Moving UP
        if (dr == -1 && dc == 0) {
            return hasUp(current) && hasDown(next);
        }

        // Moving DOWN
        return hasDown(current) && hasUp(next);
    }

    private boolean hasLeft(int type) {
        return type == 1 || type == 3 || type == 5;
    }

    private boolean hasRight(int type) {
        return type == 1 || type == 4 || type == 6;
    }

    private boolean hasUp(int type) {
        return type == 2 || type == 5 || type == 6;
    }

    private boolean hasDown(int type) {
        return type == 2 || type == 3 || type == 4;
    }
}