class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int idx=0;
        int count=0;
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]<intervals[idx][1]){
                 count++;
                intervals[idx][1]=Math.min(intervals[idx][1],intervals[i][1]);
    
            }
            else{
                idx=i;

            }
        }
        return count;
    }
}