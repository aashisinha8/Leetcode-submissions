class Solution {
    public int countPalindromicSubsequence(String s) {

        int ans = 0;

        // Har character ko outer character maanenge
        for (char ch = 'a'; ch <= 'z'; ch++) {

            int first = s.indexOf(ch);
            int last = s.lastIndexOf(ch);

            // Agar character ek baar ya bilkul nahi hai
            if (first == -1 || first == last) {
                continue;
            }

            // Unique middle characters mark karenge
            boolean[] seen = new boolean[26];

            // first aur last ke beech
            for (int i = first + 1; i < last; i++) {
                seen[s.charAt(i) - 'a'] = true;
            }

            // Kitne unique middle characters hain
            for (boolean b : seen) {
                if (b) {
                    ans++;
                }
            }
        }

        return ans;
    }
}