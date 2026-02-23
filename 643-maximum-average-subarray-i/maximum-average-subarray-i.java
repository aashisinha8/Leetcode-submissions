class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int l=0;
        double sum=0,max=Double.NEGATIVE_INFINITY;
        for(int r=0;r<nums.length;r++){
            sum+=nums[r];
            while(r-l+1==k){
            max=Math.max(sum,max);
            sum-=nums[l];
             l++;

            }
            

        }
        return max/k;
    }
}