class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> ans=new ArrayList<>();
        solve(n,k,result,ans);
        return result;
    }
    private void solve(int n,int k, List<List<Integer>> result,List<Integer> ans){
        if(ans.size()==k){
            result.add(new ArrayList<>(ans));
            return;
        }
        if(n>k-ans.size()){
            solve(n-1,k,result,ans);
        }
        ans.add(n);
        solve(n-1,k,result,ans);
        ans.remove(ans.size()-1);
    }
}