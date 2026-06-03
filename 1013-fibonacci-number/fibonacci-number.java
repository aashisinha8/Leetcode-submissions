class Solution {
    public int fib(int n) {
       int[] dp=new int[n+1];
       Arrays.fill(dp,-1);
       return fibonacci(n,dp);
    }
    private int fibonacci(int n,int[] dp){
        if(n<=1) return dp[n]=n;
        if(dp[n]!=-1) return dp[n];
        int ans=fib(n-1)+fib(n-2);
        return dp[n]=ans;
    }
}
