class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int idx = 0; // index of last merged interval

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[idx][1] >= intervals[i][0]) {
                // overlap → merge
                intervals[idx][1] =
                    Math.max(intervals[idx][1], intervals[i][1]);
            } else {
                // no overlap → move forward
                idx++;
                intervals[idx] = intervals[i];
            }
        }

        return Arrays.copyOf(intervals, idx + 1);//as idx starts at zero based indexing and size is 1 based
        /*Arrays.copyOf(array, newLength)

Second parameter = length of new array, not last index.*/
    }
}
