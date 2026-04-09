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
    public boolean isValidBST(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        inorder(root,list);

        for(int i=1;i<list.size();i++){
            if(list.get(i)<=list.get(i-1)) return false;
        }
        return true;
    }
    private void inorder(TreeNode A, List<Integer> list){
        if(A==null) return;
        inorder(A.left,list);
        list.add(A.val);
        inorder(A.right,list);
        
    }
}