package BinaryTree;

/**
 * @leetcode: 226. Invert Binary Tree
 */
public class InvertTree {
    public static void main(String[] args) {}

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode t = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(t);
        return root;
    }
}