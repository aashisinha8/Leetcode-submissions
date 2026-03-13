class Solution {

    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {

        long low = 1;
        long high = (long)1e18;   // safe upper bound
        long ans = high;

        while (low <= high) {

            long mid = low + (high - low) / 2;

            if (canFinish(mid, mountainHeight, workerTimes)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    private boolean canFinish(long time, int mountainHeight, int[] workerTimes) {

        long totalHeight = 0;

        for (int t : workerTimes) {

            // Solve: t * x(x+1)/2 <= time
            // x(x+1) <= 2*time/t

            long val = (2 * time) / t;

            long x = (long)((Math.sqrt(1 + 4.0 * val) - 1) / 2);//solve quadratic equation

            totalHeight += x;

            if (totalHeight >= mountainHeight)
                return true;
        }

        return false;
    }
}