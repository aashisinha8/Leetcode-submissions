class Solution {
    Boolean [][] dp;
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int num:nums){
            sum+=num;
        }
        if(sum%2!=0) return false;
        dp=new Boolean[nums.length][sum/2+1];
        return solve(nums,nums.length-1,sum/2);
    }
    private boolean solve(int[] nums,int i,int target){
        if(i<0) return false;
        if(target==0) return true;
        if(dp[i][target]!=null) return dp[i][target];
        boolean notTake=solve(nums,i-1,target);
        boolean take=false;
        if(nums[i]<=target){
            take=solve(nums,i-1,target-nums[i]);
            
        }
        return dp[i][target]=take||notTake;
    }
}