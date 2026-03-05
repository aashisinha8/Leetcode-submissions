class Solution {
    public int splitArray(int[] nums, int k) {

        int low = 0;
        int high = 0;

        for(int num : nums){
            low = Math.max(low, num); // largest element
            high += num;              // total sum
        }

        while(low < high){

            int mid = low + (high - low)/2;

            if(canSplit(nums, k, mid)){
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private boolean canSplit(int[] nums, int k, int maxSum){

        int parts = 1;
        int currentSum = 0;

        for(int num : nums){

            if(currentSum + num > maxSum){
                parts++;
                currentSum = num;
            } else {
                currentSum += num;
            }
        }

        return parts <= k;
    }
}