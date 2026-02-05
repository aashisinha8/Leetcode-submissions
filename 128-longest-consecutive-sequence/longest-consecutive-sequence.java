class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        
        int len=0;
        for(int num:nums){
            set.add(num);
        }
        for(int num:set){
            if(!set.contains(num-1)){
                int currentnum=num;
                int currentlen=1;
                while(set.contains(currentnum+1)){
                    currentnum++;
                    currentlen++;
                }
                len=Math.max(len,currentlen);
            }
        }
        return len; 
    }
}