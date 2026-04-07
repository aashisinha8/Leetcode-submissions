import java.util.*;

public class Codec {

    // SERIALIZE
    public String serialize(TreeNode root) {
        if (root == null) return "";

        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node == null) {
                sb.append("null,");
            } else {
                sb.append(node.val).append(",");
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }

        return sb.toString();
    }

    // DESERIALIZE
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) return null;

        String[] arr = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();

            // LEFT
            if (!arr[i].equals("null")) {
                current.left = new TreeNode(Integer.parseInt(arr[i]));
                queue.offer(current.left);
            }
            i++;

            // RIGHT
            if (i < arr.length && !arr[i].equals("null")) {
                current.right = new TreeNode(Integer.parseInt(arr[i]));
                queue.offer(current.right);
            }
            i++;
        }

        return root;
    }
}