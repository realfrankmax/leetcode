package BinarySearchTree;

/**
 * @leetcode: 938. Range Sum of BST
 */
public class RangeSumBST {
    public static void main(String[] args) {}

    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        if (root.val < low) {
            return rangeSumBST(root.right, low, high);
        } else if (root.val > high) {
            return rangeSumBST(root.left, low, high);
        } else {
            if (root.val == low) {
                return root.val + rangeSumBST(root.right, low, high);
            } else if (root.val == high) {
                return root.val + rangeSumBST(root.left, low, high);
            } else {
                return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
            }   
        }
    }
}
