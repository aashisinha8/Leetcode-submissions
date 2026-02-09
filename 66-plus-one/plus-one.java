class Solution {
    public int[] plusOne(int[] digits) {

        // start from last digit
        for (int i = digits.length - 1; i >= 0; i--) {

            if (digits[i] < 9) {
                digits[i]++;
                return digits; // no carry, done
            }

            // digit is 9 → becomes 0, carry continues
            digits[i] = 0;
        }

        // if we reach here, all digits were 9
        int[] result = new int[digits.length + 1];
        result[0] = 1; // e.g., 999 → 1000
        return result;
    }
}
