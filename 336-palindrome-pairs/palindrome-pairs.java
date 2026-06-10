class Solution {

    public List<List<Integer>> palindromePairs(String[] words) {

        List<List<Integer>> result = new ArrayList<>();

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }

        for (int i = 0; i < words.length; i++) {

            String word = words[i];

            for (int cut = 0; cut <= word.length(); cut++) {

                String left = word.substring(0, cut);
                String right = word.substring(cut);

                // Case 1
                if (isPalindrome(left)) {

                    String revRight =
                        new StringBuilder(right).reverse().toString();

                    Integer idx = map.get(revRight);

                    if (idx != null && idx != i) {
                        result.add(Arrays.asList(idx, i));
                    }
                }

                // Case 2
                if (cut != word.length()
                        && isPalindrome(right)) {

                    String revLeft =
                        new StringBuilder(left).reverse().toString();

                    Integer idx = map.get(revLeft);

                    if (idx != null && idx != i) {
                        result.add(Arrays.asList(i, idx));
                    }
                }
            }
        }

        return result;
    }

    private boolean isPalindrome(String s) {

        int l = 0;
        int r = s.length() - 1;

        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) {
                return false;
            }
        }

        return true;
    }
}