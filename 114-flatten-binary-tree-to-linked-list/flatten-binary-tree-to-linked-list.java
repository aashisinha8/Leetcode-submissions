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
    TreeNode prev=null;
    public void flatten(TreeNode root) {
        if(root==null) return;
        //reverse preoreder traversal hilinked list kr paega kyukipreorder measn root_>left_>right reverse me hojaega right-left-root and he right subtrre to left sub tree se chipkao
         // reverse preorder
        flatten(root.right);

        flatten(root.left);

        root.right = prev;
        root.left = null;

        prev = root;
    }
}