class Solution {

    public int numberOfGoodPartitions(int[] nums) {

        int mod = 1_000_000_007;

        Map<Integer, Integer> last = new HashMap<>();

        int n = nums.length;

        // store last occurrence
        for (int i = 0; i < n; i++) {
            last.put(nums[i], i);
        }

        int groups = 0;

        int end = 0;

        for (int i = 0; i < n; i++) {

            end = Math.max(end, last.get(nums[i]));

            // one partition completed
            if (i == end) {
                groups++;
            }
        }

        long ans = 1;

        // 2^(groups-1)
        for (int i = 0; i < groups - 1; i++) {
            ans = (ans * 2) % mod;
        }

        return (int) ans;
    }
}