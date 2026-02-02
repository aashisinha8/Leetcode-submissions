class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
    return s;
}
        int n=s.length();
        int start=0,end=0;
        for(int c=0;c<n;c++){
            int left=c;
            int right=c;

            //odd length palindrome check
            while(left>=0 && right<n){
                if(s.charAt(left)!=s.charAt(right)){
                    break;
                }
                left--;
                right++;
            }
            if(right-left-1>end-start+1){
                start=left+1;
                end=right-1;
            }
            //evenlength palindromic check
            left=c;
            right=c+1;
            while(left>=0 && right<n){
                if(s.charAt(left)!=s.charAt(right)){
                    break;
                }
                left--;
                right++;
            }
            if(right-left-1>end-start+1){
                start=left+1;
                end=right-1;
            }

        }
        return s.substring(start,end+1);

        }
        
    }
