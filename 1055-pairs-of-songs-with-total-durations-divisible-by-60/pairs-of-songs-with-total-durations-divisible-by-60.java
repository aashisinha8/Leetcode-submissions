class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int[] freq=new int[60];
        int count=0;
        for(int t:time){
            int remainder=t%60;
            int compliment=(60-remainder)%60;
            count+=freq[compliment];
            freq[remainder]++;
        }
        return count;
    }
}