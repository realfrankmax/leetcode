package BinaryTree;

/**
 * @leetcode: 110. Balanced Binary Tree
 */
public class IsBalanced {
    public static void main(String[] args) {}

    public boolean isBalanced(TreeNode root) {
        return getHeightIfBalanced(root) != -1;
    }
    private int getHeightIfBalanced(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = getHeightIfBalanced(root.left);
        if (leftHeight == -1) {
            return -1;
        }
        int rightHeight = getHeightIfBalanced(root.right);
        if (rightHeight == -1) {
            return -1;
        }
        if (Math.abs(leftHeight-rightHeight) > 1) {
            return -1;
        } else {
            return 1 + Math.max(leftHeight, rightHeight);
        }
    }
}