class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {

            // Step 1: Convert string to char array
            char[] arr = s.toCharArray();

            // Step 2: Sort the characters
            Arrays.sort(arr);

            // Step 3: Create key from sorted characters
            String key = new String(arr);

            // Step 4: If key not present, create new list
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }

            // Step 5: Add original string to the list
            map.get(key).add(s);
        }

        // Step 6: Return all grouped anagrams
        return new ArrayList<>(map.values());
    }
}
