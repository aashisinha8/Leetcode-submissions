class Solution {

    public int maxAreaOfIsland(int[][] grid) {

        int maxArea = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if (grid[i][j] == 1) {
                    int area = dfs(grid, i, j);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }

        return maxArea;
    }

    private int dfs(int[][] grid, int row, int col) {

        // Boundary check or water
        if (row < 0 || row >= grid.length ||
            col < 0 || col >= grid[0].length ||
            grid[row][col] == 0) {

            return 0;
        }

        // Mark visited
        grid[row][col] = 0;

        int area = 1;

        // Up
        area += dfs(grid, row - 1, col);

        // Down
        area += dfs(grid, row + 1, col);

        // Left
        area += dfs(grid, row, col - 1);

        // Right
        area += dfs(grid, row, col + 1);

        return area;
    }
}