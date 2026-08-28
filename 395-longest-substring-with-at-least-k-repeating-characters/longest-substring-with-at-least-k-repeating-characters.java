class Solution {

    public int longestSubstring(String s, int k) {

        if (s.length() < k) {
            return 0;
        }

        Map<Character, Integer> freq = new HashMap<>();

        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            // This character cannot be part of a valid substring
            if (freq.get(c) < k) {

                int left = longestSubstring(s.substring(0, i), k);

                int right = longestSubstring(s.substring(i + 1), k);

                return Math.max(left, right);
            }
        }

        return s.length();
    }
}