class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;

        if (n < 4) return ans;

        Arrays.sort(nums);

        for (int i = 0; i < n - 3; i++) {

            // Skip duplicates for i
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            for (int j = i + 1; j < n - 2; j++) {

                // Skip duplicates for j
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                int k = j + 1;
                int l = n - 1;

                while (k < l) {

                    long sum = (long) nums[i] + nums[j] + nums[k] + nums[l];

                    if (sum == target) {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));

                        k++;
                        l--;

                        // Skip duplicates for k
                        while (k < l && nums[k] == nums[k - 1]) k++;

                        // Skip duplicates for l
                        while (k < l && nums[l] == nums[l + 1]) l--;

                    } else if (sum < target) {
                        k++;
                    } else {
                        l--;
                    }
                }
            }
        }
        return ans;
    }
}
