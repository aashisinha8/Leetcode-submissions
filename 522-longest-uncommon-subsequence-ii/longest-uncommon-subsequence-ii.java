class Solution {

    public int findLUSlength(String[] strs) {

        int max = -1;

        for (int i = 0; i < strs.length; i++) {

            boolean uncommon = true;

            for (int j = 0; j < strs.length; j++) {

                if (i == j) {
                    continue;
                }

                if (isSubsequence(strs[i], strs[j])) {
                    uncommon = false;
                    break;
                }
            }

            if (uncommon) {
                max = Math.max(max, strs[i].length());
            }
        }

        return max;
    }

    public boolean isSubsequence(String s, String t) {

        int i = 0;
        int j = 0;

        while (i < s.length() && j < t.length()) {

            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }

            j++;
        }

        return i == s.length();
    }
}