class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {

        int n = nums.length;

        // =========================
        // PART 1: Every k-window sum
        // =========================

        int m = n - k + 1;
        int[] sum = new int[m];

        int windowSum = 0;

        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }

        sum[0] = windowSum;

        for (int i = k; i < n; i++) {
            windowSum += nums[i];
            windowSum -= nums[i - k];

            sum[i - k + 1] = windowSum;
        }


        // =========================
        // PART 2: Best window from LEFT
        // =========================

        int[] left = new int[m];

        int best = 0;

        for (int i = 0; i < m; i++) {

            if (sum[i] > sum[best]) {
                best = i;
            }

            left[i] = best;
        }


        // =========================
        // PART 3: Best window from RIGHT
        // =========================

        int[] right = new int[m];

        best = m - 1;

        for (int i = m - 1; i >= 0; i--) {

            if (sum[i] >= sum[best]) {
                best = i;
            }

            right[i] = best;
        }


        // =========================
        // PART 4: Decide MIDDLE
        // =========================

        int maxTotal = 0;
        int[] answer = new int[3];

        for (int mid = k; mid < m - k; mid++) {

            int leftIndex = left[mid - k];
            int rightIndex = right[mid + k];

            int total = sum[leftIndex]
                      + sum[mid]
                      + sum[rightIndex];

            if (total > maxTotal) {
                maxTotal = total;

                answer[0] = leftIndex;
                answer[1] = mid;
                answer[2] = rightIndex;
            }
        }

        return answer;
    }
}