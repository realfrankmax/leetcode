package BinaryTree;

/**
 * @leetcode: 623. Add One Row to Tree
 */
public class AddOneRow {
    public static void main(String[] args) {}

    // Take d == 1 and d == 2 as special case, then call function on left and right nodes.
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1 || root == null) {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }
        if (depth == 2) {
            TreeNode t = root.left;
            root.left = new TreeNode(val);
            root.left.left = t;
            t = root.right;
            root.right = new TreeNode(val);
            root.right.right = t;
            return root;
        }
        addOneRow(root.left, val, depth-1);
        addOneRow(root.right, val, depth-1);
        return root;
    }
}