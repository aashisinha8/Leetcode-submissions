class Solution {
    public long maximumMedianSum(int[] nums) {
        Arrays.sort(nums);

        int n = nums.length;
        int left = 0;
        int right = n - 1;

        long sum = 0;

        while (left < right) {
            sum += nums[right - 1];

            left++;
            right -= 2;
        }

        return sum;
    }
}