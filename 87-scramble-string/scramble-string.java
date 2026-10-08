class Solution {

    HashMap<String, Boolean> dp = new HashMap<>();

    public boolean isScramble(String s1, String s2) {

        if (s1.length() != s2.length()) {
            return false;
        }

        return solve(s1, s2);
    }

    private boolean solve(String s1, String s2) {

        // Same string
        if (s1.equals(s2)) {
            return true;
        }

        String key = s1 + "#" + s2;

        if (dp.containsKey(key)) {
            return dp.get(key);
        }

        // Frequency check
        int[] freq = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            freq[s1.charAt(i) - 'a']++;
            freq[s2.charAt(i) - 'a']--;
        }

        for (int count : freq) {
            if (count != 0) {
                dp.put(key, false);
                return false;
            }
        }

        int n = s1.length();

        // Try every possible split
        for (int i = 1; i < n; i++) {

            // Case 1: No swap
            boolean noSwap =
                    solve(s1.substring(0, i), s2.substring(0, i))
                    &&
                    solve(s1.substring(i), s2.substring(i));

            if (noSwap) {
                dp.put(key, true);
                return true;
            }

            // Case 2: Swap
            boolean swap =
                    solve(s1.substring(0, i), s2.substring(n - i))
                    &&
                    solve(s1.substring(i), s2.substring(0, n - i));

            if (swap) {
                dp.put(key, true);
                return true;
            }
        }

        dp.put(key, false);
        return false;
    }
}