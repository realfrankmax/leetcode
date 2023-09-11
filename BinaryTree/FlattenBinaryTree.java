package BinaryTree;

/**
 * @leetcode: 114. Flatten Binary Tree to Linked List
 */
public class FlattenBinaryTree {
    public static void main(String[] args) {}

    // Time O(2N)
    // Space O(1)
    public void flatten(TreeNode root) {
        while (root != null) {
            if (root.left != null) {
                TreeNode pointer = root.left;
                while (pointer.right != null) {
                    pointer = pointer.right;
                }
                TreeNode temp = root.right;
                root.right = root.left;
                pointer.right = temp;
                root.left = null;
            }
            root = root.right;
        }
    }

    // Time O(N)
    // Space O(N)
    public void flatten_v2(TreeNode root) {
        flattenRecursion(root);
    }
    private TreeNode flattenRecursion(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            return root;
        }
        TreeNode leftEnd = flattenRecursion(root.left);
        TreeNode rightEnd = flattenRecursion(root.right);

        if (leftEnd != null) {
            TreeNode temp = root.right;
            root.right = root.left;
            leftEnd.right = temp;
            root.left = null;
        }
        return rightEnd == null ? leftEnd : rightEnd;
    }
}