class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        // Count frequency
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Min heap based on frequency
        PriorityQueue<Integer> pq =
            new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));

        for(int key : map.keySet()) {

            pq.offer(key);

            if(pq.size() > k) {
                pq.poll();
            }
        }

        int[] result = new int[k];

        for(int i = 0; i < k; i++) {
            result[i] = pq.poll();
        }

        return result;
    }
}