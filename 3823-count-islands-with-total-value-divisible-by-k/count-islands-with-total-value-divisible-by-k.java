class Solution {

    public int countIslands(int[][] grid, int k) {

        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if (grid[i][j] > 0) {

                    long sum = dfs(grid, i, j);

                    if (sum % k == 0) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    private long dfs(int[][] grid, int i, int j) {

        // boundary / water / visited
        if (i < 0 || i >= grid.length ||
            j < 0 || j >= grid[0].length ||
            grid[i][j] == 0) {

            return 0;
        }

        // current value
        long sum = grid[i][j];

        // mark visited
        grid[i][j] = 0;

        sum += dfs(grid, i + 1, j); // down
        sum += dfs(grid, i - 1, j); // up
        sum += dfs(grid, i, j + 1); // right
        sum += dfs(grid, i, j - 1); // left

        return sum;
    }
}