class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) return false;

        int[] freq = new int[26];

        for (char c : s1.toCharArray()) {
            freq[c - 'a']++;
        }

        int left = 0;
        int right = 0;
        int count = s1.length();

        while (right < s2.length()) {
            
            if (freq[s2.charAt(right) - 'a'] > 0) {
                count--;
            }
            freq[s2.charAt(right) - 'a']--;
            right++;

            if (count == 0) return true;

            if (right - left == s1.length()) {
                if (freq[s2.charAt(left) - 'a'] >= 0) {
                    count++;
                }
                freq[s2.charAt(left) - 'a']++;
                left++;
            }
        }

        return false;
    }
}