class Solution {

    public int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;

        int[] result = new int[n - k + 1];

        Deque<Integer> dq = new LinkedList<>();

        int idx = 0;

        for (int i = 0; i < n; i++) {

            // remove indexes out of current window
            while (!dq.isEmpty() &&
                    dq.peekFirst() <= i - k) {

                dq.pollFirst();
            }

            // remove smaller elements
            while (!dq.isEmpty() &&
                    nums[dq.peekLast()] < nums[i]) {

                dq.pollLast();
            }

            // add current index
            dq.offerLast(i);

            // window formed
            if (i >= k - 1) {

                result[idx++] = nums[dq.peekFirst()];
            }
        }

        return result;
    }
}