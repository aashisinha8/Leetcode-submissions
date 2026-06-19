class Solution {
    public long minimumReplacement(int[] nums) {

        long operations = 0;

        int prev = nums[nums.length - 1];

        for (int i = nums.length - 2; i >= 0; i--) {

            if (nums[i] <= prev) {
                prev = nums[i];
                continue;
            }

            long parts = (nums[i] + prev - 1L) / prev;

            operations += parts - 1;

            prev = (int)(nums[i] / parts);
        }

        return operations;
    }
}