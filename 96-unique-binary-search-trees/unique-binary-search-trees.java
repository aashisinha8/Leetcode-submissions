class Solution {

    public int numTrees(int n) {

        int[] dp = new int[n + 1];

        Arrays.fill(dp, -1);

        return solve(n, dp);
    }

    private int solve(int n, int[] dp) {

        if (n <= 1)
            return 1;

        if (dp[n] != -1)
            return dp[n];

        int ans = 0;

        for (int root = 1; root <= n; root++) {

            int left = root - 1;
            int right = n - root;

            ans += solve(left, dp)
                 * solve(right, dp);
        }

        return dp[n] = ans;
    }
}