class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp=new int[amount+1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for(int coin:coins){
            for(int sum=coin;sum<=amount;sum++){
                dp[sum] =Math.min(dp[sum],1 + dp[sum - coin]);
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}


