class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> set=new HashSet<>(wordDict);
        List<String> path=new ArrayList<>();
        List<String>  result=new ArrayList<>();
        backtrack(s,result,0,set,path);
        return result;
    }
     private void backtrack(String s, List<String> result, int idx,Set<String> set, List<String> path){
        if(idx==s.length()){
            result.add(String.join(" ", path));
            return;
        }
         for(int i = idx; i < s.length(); i++){

            String word = s.substring(idx, i + 1);

            if(set.contains(word)){

                path.add(word);
                
                backtrack(s,result,i+1,set,path);

                path.remove(path.size()-1);//backtrack
            }

         }


     }
}