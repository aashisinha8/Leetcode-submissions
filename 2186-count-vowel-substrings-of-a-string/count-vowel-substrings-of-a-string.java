class Solution {
    public int countVowelSubstrings(String word) {

        int count = 0;

        for (int i = 0; i < word.length(); i++) {
            for (int j = i + 1; j <= word.length(); j++) {

                if (valid(word.substring(i, j))) {
                    count++;
                }
            }
        }

        return count;
    }

    private boolean valid(String s) {

        for (char ch : s.toCharArray()) {
            if (ch != 'a' && ch != 'e' && ch != 'i'
                    && ch != 'o' && ch != 'u') {
                return false;
            }
        }

        return s.contains("a")
                && s.contains("e")
                && s.contains("i")
                && s.contains("o")
                && s.contains("u");
    }
}