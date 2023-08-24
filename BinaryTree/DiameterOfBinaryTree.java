package BinaryTree;

/**
 * @leetcode: 543. Diameter of Binary Tree
 */
public class DiameterOfBinaryTree {
    public static void main(String[] args) {}

    private int diameter;
    public int diameterOfBinaryTree(TreeNode root) {
        checkHeight(root);
        return diameter;
    }
    private int checkHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = checkHeight(root.left);
        int rightHeight = checkHeight(root.right);
        diameter = Math.max(diameter, leftHeight+rightHeight);
        return 1 + Math.max(leftHeight, rightHeight);
    }
}