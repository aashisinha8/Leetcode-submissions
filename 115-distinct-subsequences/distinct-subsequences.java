class Solution {
    public int numDistinct(String s, String t) {
         int[][] dp = new int[s.length()][t.length()];
         for (int[] row : dp)
         Arrays.fill(row, -1);
        return solve(dp,0, 0, s, t);
    }

    private int solve(int[][] dp, int i, int j, String s, String t) {

        if (j == t.length())
            return 1;

        if (i == s.length())
            return 0;

        if (dp[i][j] != -1)
            return dp[i][j];

        if (s.charAt(i) == t.charAt(j)) {
            dp[i][j] = solve(dp,i + 1, j + 1, s, t)
                     + solve(dp,i + 1, j, s, t);
        } else {
            dp[i][j] = solve(dp,i + 1, j, s, t);
        }

        return dp[i][j];
    }
}
    