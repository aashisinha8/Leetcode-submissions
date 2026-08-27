class Solution {
    public List<Integer> findSubstring(String s, String[] words) {

        List<Integer> result = new ArrayList<>();

        if (s == null || s.length() == 0 || words.length == 0) {
            return result;
        }

        int wordLen = words[0].length();
        int wordCount = words.length;

        Map<String, Integer> required = new HashMap<>();

        for (String word : words) {
            required.put(word, required.getOrDefault(word, 0) + 1);
        }

        // Try each possible starting offset
        for (int offset = 0; offset < wordLen; offset++) {

            int left = offset;
            int count = 0;

            Map<String, Integer> window = new HashMap<>();

            for (int right = offset;
                 right + wordLen <= s.length();
                 right += wordLen) {

                String word = s.substring(right, right + wordLen);

                // Word is not required
                if (!required.containsKey(word)) {
                    window.clear();
                    count = 0;
                    left = right + wordLen;
                    continue;
                }

                window.put(word,
                        window.getOrDefault(word, 0) + 1);

                count++;

                // Extra occurrence of a word
                while (window.get(word) > required.get(word)) {

                    String leftWord =
                            s.substring(left, left + wordLen);

                    window.put(
                            leftWord,
                            window.get(leftWord) - 1
                    );

                    left += wordLen;
                    count--;
                }

                // Found all words
                if (count == wordCount) {

                    result.add(left);

                    // Move one word forward
                    String leftWord =
                            s.substring(left, left + wordLen);

                    window.put(
                            leftWord,
                            window.get(leftWord) - 1
                    );

                    left += wordLen;
                    count--;
                }
            }
        }

        return result;
    }
}