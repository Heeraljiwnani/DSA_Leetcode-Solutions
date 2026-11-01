
import java.util.*;

class Solution {

    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();

        inorder(root, result);

        return result;
    }

    public void inorder(TreeNode root, List<Integer> result) {

        // Base case
        if (root == null) {
            return;
        }

        // 1. Traverse left subtree
        inorder(root.left, result);

        // 2. Visit root
        result.add(root.val);

        // 3. Traverse right subtree
        inorder(root.right, result);
    }
}
