/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> ans=new ArrayList<>();
         solve(root, targetSum,result, ans);
         return result;
    }
    private void solve(TreeNode root,int target,List<List<Integer>>result, List<Integer> ans){
        if(root==null) return ;
        ans.add(root.val);
        if(root.left==null && root.right==null && root.val==target){
            result.add(new ArrayList<>(ans));
        }
        solve(root.left,target-root.val,result,ans);
        solve(root.right,target-root.val,result,ans);
        ans.remove(ans.size()-1);
    }
}