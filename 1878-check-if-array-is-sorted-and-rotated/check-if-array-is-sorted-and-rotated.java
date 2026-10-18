class Solution {
    public boolean check(int[] nums) {

        int count = 0;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] > nums[(i + 1) % nums.length]) {
                count++;
            }

            if (count > 1) { //exactly one break at apoint to check if itis in order and rotated
                return false;
            }
        }

        return true;
    }
}