class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {

        HashMap<Character, Integer> charFreq = new HashMap<>();
        HashMap<String, Integer> subFreq = new HashMap<>();

        int left = 0;
        int ans = 0;

        for (int right = 0; right < s.length(); right++) {

            char c = s.charAt(right);
            charFreq.put(c, charFreq.getOrDefault(c, 0) + 1);

            if (right - left + 1 > minSize) {
                char leftChar = s.charAt(left);
                charFreq.put(leftChar, charFreq.get(leftChar) - 1);

                if (charFreq.get(leftChar) == 0)
                    charFreq.remove(leftChar);

                left++;
            }

            if (right - left + 1 == minSize && charFreq.size() <= maxLetters) {

                String sub = s.substring(left, right + 1);

                int freq = subFreq.getOrDefault(sub, 0) + 1;
                subFreq.put(sub, freq);

                ans = Math.max(ans, freq);
            }
        }

        return ans;
    }
}