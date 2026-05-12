class Solution {
    public String reverseWords(String s) {
        String[] words=s.split(" ");
        StringBuilder sb=new StringBuilder();
        for(String word:words){
            sb.append(reverse(word));
            sb.append(" ");
        }
        return sb.toString().trim();
        
   }
   private String reverse(String s){
    char[] arr=s.toCharArray();
    int l=0;
    int r=arr.length-1;
    while(l<r){
        char ch=arr[l];
        arr[l]=arr[r];
        arr[r]=ch;
        l++;
        r--;
    }
    return new String(arr);
   }
}