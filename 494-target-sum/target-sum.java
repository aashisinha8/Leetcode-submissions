/*
DP Trick ⭐

Maan lo:

P = positive numbers ka sum
N = negative numbers ka sum

Then:

P - N = target

Aur:P + N = totalSum

Dono equations add karo:

2P = target + totalSum

So:

P = (target + totalSum) / 2
*/
class Solution {

    public int findTargetSumWays(int[] nums, int target) {

        int total = 0;

        for (int num : nums) {
            total += num;
        }

        if (Math.abs(target) > total) {
            return 0;
        }

        if ((target + total) % 2 != 0) {
            return 0;
        }

        int subsetSum = (target + total) / 2;

        int[] dp = new int[subsetSum + 1];

        dp[0] = 1;

        for (int num : nums) {

            for (int j = subsetSum;
                 j >= num;
                 j--) {

                dp[j] += dp[j - num];
            }
        }

        return dp[subsetSum];
    }
}