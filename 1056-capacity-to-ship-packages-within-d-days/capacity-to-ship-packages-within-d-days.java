class Solution {
    public int shipWithinDays(int[] weights, int days) {

        int low = 0, high = 0;

        for(int w : weights){
            low = Math.max(low, w);
            high += w;
        }

        while(low < high){
            int mid = low + (high - low) / 2;

            if(canShip(weights, days, mid)){
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private boolean canShip(int[] weights, int days, int cap){
        int daysUsed = 1;
        int curr = 0;

        for(int w : weights){
            if(curr + w > cap){
                daysUsed++;
                curr = 0;
            }
            curr += w;
        }

        return daysUsed <= days;
    }
}