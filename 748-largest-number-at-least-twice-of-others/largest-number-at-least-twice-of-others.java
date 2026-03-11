class Solution {
    public int dominantIndex(int[] nums) {

        int maxNum = -1;
        int index = -1;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] > maxNum){
                maxNum = nums[i];
                index = i;
            }
        }

        for(int i = 0; i < nums.length; i++){
            if(i != index && maxNum < 2 * nums[i]){
                return -1;
            }
        }

        return index;
    }
}