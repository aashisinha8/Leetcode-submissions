class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
        String best = "";

        for (String word : dictionary) {
            if (isSubsequence(word, s)) {
                if (word.length() > best.length() ||
                    (word.length() == best.length() && word.compareTo(best) < 0)) {
                    best = word;
                }
            }
        }

        return best;
    }

    private boolean isSubsequence(String a, String b) {
        int i = 0;
        for (int j = 0; j < b.length() && i < a.length(); j++) {
            if (a.charAt(i) == b.charAt(j)) {
                i++;
            }
        }
        return i == a.length();
    }
}
