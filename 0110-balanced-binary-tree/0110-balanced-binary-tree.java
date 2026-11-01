
class Solution {

    public boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }

    public int height(TreeNode root) {

        // Base case
        if (root == null) {
            return 0;
        }

        // Calculate left subtree height
        int left = height(root.left);

        if (left == -1) {
            return -1;
        }

        // Calculate right subtree height
        int right = height(root.right);

        if (right == -1) {
            return -1;
        }

        // Check balance condition
        if (Math.abs(left - right) > 1) {
            return -1;
        }

        // Return height of current node
        return 1 + Math.max(left, right);
    }
}
