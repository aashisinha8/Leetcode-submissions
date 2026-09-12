class Solution {

    PriorityQueue<Integer> small =
        new PriorityQueue<>(Collections.reverseOrder());

    PriorityQueue<Integer> large =
        new PriorityQueue<>();

    HashMap<Integer, Integer> delayed =
        new HashMap<>();

    int smallSize = 0;
    int largeSize = 0;

    public double[] medianSlidingWindow(int[] nums, int k) {

        int n = nums.length;
        double[] ans = new double[n - k + 1];

        for (int i = 0; i < k; i++) {
            add(nums[i]);
        }

        ans[0] = median(k);

        for (int i = k; i < n; i++) {

            add(nums[i]);
            remove(nums[i - k]);

            ans[i - k + 1] = median(k);
        }

        return ans;
    }

    private void add(int num) {

        if (small.isEmpty() || num <= small.peek()) {
            small.offer(num);
            smallSize++;
        } else {
            large.offer(num);
            largeSize++;
        }

        balance();
    }

    private void remove(int num) {

        delayed.put(num,
                delayed.getOrDefault(num, 0) + 1);

        if (num <= small.peek()) {
            smallSize--;

            if (num == small.peek()) {
                prune(small);
            }

        } else {
            largeSize--;

            if (!large.isEmpty() &&
                num == large.peek()) {
                prune(large);
            }
        }

        balance();
    }

    private void balance() {

        if (smallSize > largeSize + 1) {

            large.offer(small.poll());

            smallSize--;
            largeSize++;

            prune(small);

        } else if (smallSize < largeSize) {

            small.offer(large.poll());

            largeSize--;
            smallSize++;

            prune(large);
        }
    }

    private void prune(PriorityQueue<Integer> heap) {

        while (!heap.isEmpty()) {

            int num = heap.peek();

            if (!delayed.containsKey(num)) {
                break;
            }

            heap.poll();

            int count = delayed.get(num);

            if (count == 1) {
                delayed.remove(num);
            } else {
                delayed.put(num, count - 1);
            }
        }
    }

    private double median(int k) {

        prune(small);
        prune(large);

        if (k % 2 == 1) {
            return small.peek();
        }

        return ((double) small.peek()
              + (double) large.peek()) / 2.0;
    }
}