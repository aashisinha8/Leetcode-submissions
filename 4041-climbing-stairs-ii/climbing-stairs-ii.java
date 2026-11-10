class Solution {
    public int climbStairs(int n, int[] costs) {

        int[] dp = new int[n + 1];

        // dp[0] = 0
        // Starting from step 0 costs nothing.

        for (int j = 1; j <= n; j++) {

            dp[j] = Integer.MAX_VALUE;

            // Jump from j - 1
            if (j - 1 >= 0) {
                dp[j] = Math.min(
                    dp[j],
                    dp[j - 1] + costs[j - 1] + 1// j is 1 indexed but array is 0 indexed so take cost[j-1];j-i=j-(j-1_)
                );
            }

            // Jump from j - 2
            if (j - 2 >= 0) {
                dp[j] = Math.min(
                    dp[j],
                    dp[j - 2] + costs[j - 1] + 4 // j-i=j-(j-2)
                );
            }

            // Jump from j - 3
            if (j - 3 >= 0) {
                dp[j] = Math.min(
                    dp[j],
                    dp[j - 3] + costs[j - 1] + 9 //j-i=j-(j-3)
                );
            }
        }

        return dp[n];
    }
}