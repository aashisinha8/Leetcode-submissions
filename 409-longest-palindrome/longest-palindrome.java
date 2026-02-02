class Solution {
    public int longestPalindrome(String s) {
        int[] freq=new int[128];
        for(char c:s.toCharArray()){
            freq[c]++;
        }
        int length=0;
        boolean oddused=false;
        //even num can be used as palindrome as whole, odd will come once in middle so if frequency is in even we consider it in length and if in odd we consider it at once at last and hence decrese the length by 1 to make it even
        for(int num:freq){
            if(num%2==0){
                length+=num;
            }
            else{
                length+=num-1;
                oddused=true;
            }
        }
        if (oddused) {
            length+=1;

        }
        return length;
        
    }
}