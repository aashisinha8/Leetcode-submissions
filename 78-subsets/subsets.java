class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> ans=new ArrayList<>();
        List<List<Integer>> result=new ArrayList<>();
        solve(nums,result,ans,0);
        return result;
    }
    private void solve(int[] nums,List<List<Integer>> result, List<Integer> ans,int index){
        if(index==nums.length){
            result.add(new ArrayList<>(ans));
            return;
        }
        ans.add(nums[index]);
        solve(nums,result,ans,index+1);//pick
        ans.remove(ans.size()-1);//backtrack
        solve(nums,result,ans,index+1);//non pick

    }
}