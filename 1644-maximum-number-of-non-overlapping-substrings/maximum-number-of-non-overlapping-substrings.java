class Solution {
    public List<String> maxNumOfSubstrings(String s) {

        int n = s.length();

        // 1. First and last occurrence of each character
        int[] first = new int[26];
        int[] last = new int[26];

        Arrays.fill(first, n);
        Arrays.fill(last, -1);

        for (int i = 0; i < n; i++) {
            int ch = s.charAt(i) - 'a';

            first[ch] = Math.min(first[ch], i);
            last[ch] = i;
        }

        // 2. Collect valid intervals
        List<int[]> intervals = new ArrayList<>();

        for (int ch = 0; ch < 26; ch++) {

            if (last[ch] == -1)
                continue; // character doesn't exist

            int start = first[ch];
            int end = last[ch];

            boolean valid = true;

            // 3. Expand interval
            for (int i = start; i <= end; i++) {

                int curr = s.charAt(i) - 'a';

                // Invalid: this character appeared before start
                if (first[curr] < start) {
                    valid = false;
                    break;
                }

                // Expand interval
                end = Math.max(end, last[curr]);
            }

            // 4. Collect if valid
            if (valid) {
                intervals.add(new int[]{start, end});
            }
        }

        // 5. Sort by ending index
        intervals.sort((a, b) -> Integer.compare(a[1], b[1]));

        // 6. Greedy selection
        List<String> result = new ArrayList<>();

        int lastEnd = -1;

        for (int[] interval : intervals) {

            int start = interval[0];
            int end = interval[1];

            if (start > lastEnd) {
                result.add(s.substring(start, end + 1));
                lastEnd = end;
            }
        }

        return result;
    }
}