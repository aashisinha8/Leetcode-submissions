class Solution {
    public int rob(int[] nums) {
      int n=nums.length;
      if(n==1) return nums[0];
      int[] dp1=new int[n];
      Arrays.fill(dp1,-1); 
      int[] dp2=new int[n];
      Arrays.fill(dp2,-1);
      int ans=Math.max(solve(0,n-2,nums,dp1),solve(1,n-1,nums,dp2));
      return ans;
    }
    private int solve(int i,int j,int[] nums,int[] dp){
        if(i<0 || i>j) return 0;
        if(dp[i]!=-1) return dp[i];
        int pick=nums[i]+solve(i+2,j,nums,dp);
        int skip=solve(i+1,j,nums,dp);
        return dp[i]=Math.max(pick,skip);
    }
}