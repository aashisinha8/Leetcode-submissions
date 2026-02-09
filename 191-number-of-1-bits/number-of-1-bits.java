class Solution {
    public int hammingWeight(int n) {
        int rem=0;
        int count=0;
        while(n>=1){
            rem=n%2;
            if(rem==1){
                count++;
            }
            n=n/2;

        }
        return count;
    }
}