class Solution {
    public int climbStairs(int n) {
       int[] dp=new int[n+1];
       Arrays.fill(dp,-1);
       return fib(n,dp);
    }
    private int fib(int n,int[] dp){
        if(n<=2) dp[n]=n;
        if(dp[n]!=-1) return dp[n];
        int ans=fib(n-1,dp)+fib(n-2,dp);
        return dp[n]=ans;
    }
}