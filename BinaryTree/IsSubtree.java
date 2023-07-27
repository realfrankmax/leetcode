package BinaryTree;

/**
 * @leetcode: 572. Subtree of Another Tree
 */
public class IsSubtree {
    public static void main(String[] args) {}

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }
        if (isSameTree(root, subRoot)) {
            return true;
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
    private boolean isSameTree(TreeNode r1, TreeNode r2) {
        if (r1 == null && r2 == null) {
            return true;
        } else if (r1 == null || r2 == null) {
            return false;
        } else {
            return r1.val == r2.val && isSameTree(r1.left, r2.left) && isSameTree(r1.right, r2.right);
        }
    }
}
