class Solution {

    int count = 0;
    int ans = 0;

    public int kthSmallest(TreeNode root, int k) {

        inorder(root, k);

        return ans;
    }

    private void inorder(TreeNode root, int k) {

        if(root == null) return;

        if(ans==0) inorder(root.left, k);

        count++;

        if(count == k) {
            ans = root.val;
            return;
        }

       if(ans==0)  inorder(root.right, k);
    }
}