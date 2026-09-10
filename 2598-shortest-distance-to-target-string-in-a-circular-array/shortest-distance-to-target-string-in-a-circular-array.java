class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        int min=Integer.MAX_VALUE;
        int n=words.length;
        for(int i=0;i<words.length;i++){
            if(words[i].equals(target)){
                int distance=Math.min(Math.abs(i-startIndex),n-Math.abs(i-startIndex));
                min=Math.min(min,distance);
            }
        }
        return min==Integer.MAX_VALUE?-1:min;
    }
}