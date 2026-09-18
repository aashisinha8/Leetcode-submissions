class Solution {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];

        // {value, index}
        PriorityQueue<int[]> pq =
            new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));

        for (int i = 0; i < n; i++) {

            pq.offer(new int[]{nums[i], i});

            // Remove elements outside current window
            while (!pq.isEmpty() && pq.peek()[1] <= i - k) {
                pq.poll();
            }

            // Window formed
            if (i >= k - 1) {
                result[i - k + 1] = pq.peek()[0];
            }
        }

        return result;
    }
}