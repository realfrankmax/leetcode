package BinarySearchTree;

/**
 * @leetcode: 235. Lowest Common Ancestor of a Binary Search Tree
 */
public class LowestCommonAncestor {
    public static void main(String[] args) {}

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (root.val > p.val && root.val > q.val) {
                root = root.left;
            } else if (root.val < p.val && root.val < q.val) {
                root = root.right;
            } else {
                break;
            }
        }
        return root;
    }
}
