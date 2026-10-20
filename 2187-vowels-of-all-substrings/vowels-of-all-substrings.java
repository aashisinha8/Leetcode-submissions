class Solution {
    public long countVowels(String word) {
/*Consider the vowel at index i.
For this vowel to be included in a substring:
- The substring's start can be anywhere from 0 to i → i + 1 choices.
- The substring's end can be anywhere from i to n-1 → n - i choices.*/
        long ans = 0;
        int n = word.length();

        for (int i = 0; i < n; i++) {

            char ch = word.charAt(i);

            if (ch == 'a' || ch == 'e' || ch == 'i' ||
                ch == 'o' || ch == 'u') {

                ans += (long) (i + 1) * (n - i);
            }
        }

        return ans;
    }
}