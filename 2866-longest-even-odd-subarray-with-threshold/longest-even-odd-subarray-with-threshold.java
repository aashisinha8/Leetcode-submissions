class Solution {
    public int longestAlternatingSubarray(int[] nums, int threshold) {
       int maxLen = 0;
int currLen = 0;

for (int i = 0; i < nums.length; i++) {

    if (nums[i] > threshold) {
        currLen = 0;
        continue;
    }

    if (currLen == 0) {
        if (nums[i] % 2 == 0) {
            currLen = 1;
            maxLen = Math.max(maxLen, currLen);
        }
        continue;
    }

    if ((nums[i] % 2) != (nums[i - 1] % 2)) {
        currLen++;
    } else {
        currLen = (nums[i] % 2 == 0) ? 1 : 0;
    }

    maxLen = Math.max(maxLen, currLen);
}
return maxLen;
    }
}