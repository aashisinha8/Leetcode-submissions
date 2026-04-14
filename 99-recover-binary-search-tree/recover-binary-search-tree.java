class Solution {
    List<Integer> list = new ArrayList<>();
    int index = 0;

    public void recoverTree(TreeNode root) {
        inorder(root);              // collect values
        Collections.sort(list);     // sort
        fix(root);                  // reassign values
    }

    private void inorder(TreeNode root){
        if(root == null) return;
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }

    private void fix(TreeNode root){
        if(root == null) return;
        fix(root.left);
        root.val = list.get(index++);
        fix(root.right);
    }
}