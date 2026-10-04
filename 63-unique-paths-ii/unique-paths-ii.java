
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] dp = new int[m][n];

        // Starting cell is an obstacle
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        dp[0][0] = 1;

        // First row
        for (int j = 1; j < n; j++) {

            if (obstacleGrid[0][j] == 0) {
                dp[0][j] = dp[0][j - 1];
            }
        }

        // First column
        for (int i = 1; i < m; i++) {

            if (obstacleGrid[i][0] == 0) {
                dp[i][0] = dp[i - 1][0];
            }
        }

        // Remaining cells
        for (int i = 1; i < m; i++) {

            for (int j = 1; j < n; j++) {

                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                }
                else {
                    dp[i][j] =
                        dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }

        return dp[m - 1][n - 1];
    }
}
/* ```

### 🔥 Dry run

For:

```text
0 0 0
0 1 0
0 0 0
```

DP becomes:

```text
1 1 1
1 0 1
1 1 2
```

So answer:

```text
2
```

There are 2 paths around the obstacle.

### Interview mein yaad rakhna

Bas ye 3 rules:

```text
Obstacle → dp[i][j] = 0

Normal cell → top + left

Start → 1
```

And:

```java
dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
```

**Time:** `O(m × n)`
**Space:** `O(m × n)`

 */
