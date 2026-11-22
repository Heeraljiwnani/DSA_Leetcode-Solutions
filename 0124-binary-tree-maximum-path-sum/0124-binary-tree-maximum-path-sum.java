
class Solution {

    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    private int maxGain(TreeNode node) {

        // Base case
        if (node == null) {
            return 0;
        }

        // Maximum contribution from left subtree
        int left = Math.max(0, maxGain(node.left));

        // Maximum contribution from right subtree
        int right = Math.max(0, maxGain(node.right));

        // Maximum path passing through current node
        int currentSum = node.val + left + right;

        // Update global maximum
        maxSum = Math.max(maxSum, currentSum);

        // Return maximum one-sided path to parent
        return node.val + Math.max(left, right);
    }
}
