class Solution {
    public List<String> generateParenthesis(int n) {
       List<String> result=new ArrayList<>();
       solve(result,new StringBuilder(),n,0,0);
       return result; 
    }
    private void solve(List<String> result,StringBuilder sb,int n,int open , int close){
            //Base Case
            if(sb.length()==2*n){
                result.add(sb.toString());
                return;
            }
            //Add open
            if(open<n){
                 sb.append("(");
                 solve(result,sb,n,open+1,close);
                 sb.deleteCharAt(sb.length()-1);//backtrack
            } 
            //Add close
            if(close<open){
                sb.append(")");
                solve(result,sb,n,open,close+1);
                sb.deleteCharAt(sb.length()-1);//backtrack
            }

    }
}