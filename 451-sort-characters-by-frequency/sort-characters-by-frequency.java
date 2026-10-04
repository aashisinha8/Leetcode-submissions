class Solution {
    public String frequencySort(String s) {

        // 1. Count frequency of each character
        HashMap<Character, Integer> map = new HashMap<>();

        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // 2. Put characters into a list
        List<Character> chars = new ArrayList<>(map.keySet());

        // 3. Sort characters by frequency (highest first)
        chars.sort((a, b) -> map.get(b) - map.get(a));

        // 4. Build result
        StringBuilder result = new StringBuilder();

        for (char ch : chars) {
            int frequency = map.get(ch);

            for (int i = 0; i < frequency; i++) {
                result.append(ch);
            }
        }

        return result.toString();
    }
}