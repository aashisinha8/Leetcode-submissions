class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq=new int[26];
        int l=0,len=0,maxfreq=0;
        for(int r=0;r<s.length();r++){
            freq[s.charAt(r)-'A']++;
            maxfreq=Math.max(maxfreq,freq[s.charAt(r)-'A']);
            while((r-l+1)-maxfreq>k){
                freq[s.charAt(l)-'A']--;
                l++;
            }
            len=Math.max(len,r-l+1);

        }
        return len;
    }
}