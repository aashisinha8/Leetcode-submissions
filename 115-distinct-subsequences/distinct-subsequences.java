class Solution {

    public int numDistinct(String s, String t) {

        int n = s.length();
        int m = t.length();

        int[] next = new int[m + 1];

        next[m] = 1;

        for (int i = n - 1; i >= 0; i--) {

            int[] curr = new int[m + 1];

            curr[m] = 1;

            for (int j = m - 1; j >= 0; j--) {

                if (s.charAt(i) == t.charAt(j)) {

                    curr[j] = next[j + 1] + next[j];

                } else {

                    curr[j] = next[j];
                }
            }

            next = curr;
        }

        return next[0];
    }
}