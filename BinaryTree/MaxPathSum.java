package BinaryTree;

/**
 * @leetcode: Binary Tree Maximum Path Sum
 */
public class MaxPathSum {
    public static void main(String[] args) {}

    private int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        checkPathSum(root);
        return max;    
    }
    private int checkPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // Left subtree could be ingored if sum is negative.
        int left = Math.max(0, checkPathSum(root.left));
        int right = Math.max(0, checkPathSum(root.right));
        this.max = Math.max(max, left + right + root.val);
        return root.val + Math.max(left, right);
    }
    
}