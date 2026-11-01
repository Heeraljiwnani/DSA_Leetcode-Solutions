
class Solution {
    public boolean isSymmetric(TreeNode root) {

        if (root == null) {
            return true;
        }

        return isMirror(root.left, root.right);
    }

    public boolean isMirror(TreeNode left, TreeNode right) {

        // Both nodes are null
        if (left == null && right == null) {
            return true;
        }

        // One node is null
        if (left == null || right == null) {
            return false;
        }

        // Values must be equal
        if (left.val != right.val) {
            return false;
        }

        // Compare opposite sides
        return isMirror(left.left, right.right) &&
               isMirror(left.right, right.left);
    }
}
