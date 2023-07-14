package BinarySearchTree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @leetcode: Validate Binary Search Tree
 */
public class IsValidBST {
    public static void main(String[] args) {}

    // public boolean isValidBST(TreeNode root) {
    //     return isValid(root.left, null, root.val) && isValid(root.right, root.val, null);
    // }
    // private boolean isValid(TreeNode node, Integer min, Integer max) {
    //     if (node == null) {
    //         return true;
    //     }
    //     if (min != null && node.val <= min.intValue()) {
    //         return false;
    //     }
    //     if (max != null && node.val >= max.intValue()) {
    //         return false;
    //     }
    //     return isValid(node.left, min, node.val) && isValid(node.right, node.val, max);
    // }

    public boolean isValidBST(TreeNode root) {
        Deque<TreeNode> deck = new ArrayDeque<>();
        TreeNode prev = null;
        while (root != null || !deck.isEmpty()) {
            if (root != null) {
                deck.addLast(root);
                root = root.left;
            } else {
                TreeNode curr = deck.removeLast();
                if (prev != null) {
                    if (prev.val >= curr.val) {
                        return false;
                    }
                }
                prev = curr;
                root = curr.right;
            }
        }
        return true;
    }
}