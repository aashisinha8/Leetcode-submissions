class Solution {
    public int maxProduct(int[] nums) {
        int max=Integer.MIN_VALUE;
        int left=1,right=1;
        for(int i=0;i<nums.length;i++){
            left*=nums[i];
             max=Math.max(max,left);
            if(left==0){
                left=1;
            }
           
            right*=nums[nums.length-1-i];
             max=Math.max(max,right);
           if(right==0){
            right=1;
           }
           
        }
return max;
        
    }
}