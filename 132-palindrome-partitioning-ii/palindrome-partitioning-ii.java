class Solution {
    public int minCut(String s) {
        int n=s.length();
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        return solve(0,s,dp)-1;
    }
    private int solve(int i,String s, int[] dp){
        if(i==s.length()) return 0;
        if(dp[i]!=-1) return dp[i];
        int minCuts=Integer.MAX_VALUE;
        for(int j=i;j<=s.length()-1;j++){
            if(isPalindrome(s,i,j)){
                int cuts=1+solve(j+1,s,dp);
                minCuts=Math.min(minCuts,cuts);
            }
        }
       dp[i]=minCuts;
        return minCuts;
    }
    private boolean isPalindrome(String s,int left, int right){
        while(left<right){
            if(s.charAt(left)!=s.charAt(right)){
                return false;
            }
                left++;
                right--;
            
        }
        return true;
    }
}