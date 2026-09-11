class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> result = new ArrayList<>();

        if (s.length() < p.length()) {
            return result;
        }

        int[] freq = new int[26];

        // Frequency of characters in p
        for (char c : p.toCharArray()) {
            freq[c - 'a']++;
        }

        int left = 0;
        int right = 0;
        int count = p.length();

        while (right < s.length()) {

            // Add current character
            char c = s.charAt(right);

            if (freq[c - 'a'] > 0) {
                count--;
            }

            freq[c - 'a']--;
            right++;

            // Window size > p size
            if (right - left > p.length()) {

                char leftChar = s.charAt(left);

                if (freq[leftChar - 'a'] >= 0) {
                    count++;
                }

                freq[leftChar - 'a']++;
                left++;
            }

            // All characters matched
            if (count == 0) {
                result.add(left);
            }
        }

        return result;
    }
}