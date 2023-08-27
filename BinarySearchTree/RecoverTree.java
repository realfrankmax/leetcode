package BinarySearchTree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @leetcode: 99. Recover Binary Search Tree
 */
public class RecoverTree {
    public static void main(String[] args) {}
    /**
     * Inorder traversal creates an increasing array.
     * When two nodes are switched, there are two situations:
     * 3 => 2 => 1 (two mismatches) 
     *      : switch 3 and 1
     * 1 => 3 => 2 => 4 (one mismatch)
     *      : switch 3 and 2
     */
    public void recoverTree(TreeNode root) {
        Deque<TreeNode> buffer = new ArrayDeque<>();
        TreeNode prev = null;
        TreeNode node1 = null;
        TreeNode node2 = null;
        while (root != null || !buffer.isEmpty()) {
            if (root != null) {
                buffer.addLast(root);
                root = root.left;
            } else {
                TreeNode curr = buffer.removeLast();
                if (prev != null && prev.val > curr.val) {
                    if (node1 == null) {
                        node1 = prev;
                    }
                    node2 = curr;
                }
                prev = curr;
                root = curr.right;
            }
        }
        int t = node1.val;
        node1.val = node2.val;
        node2.val = t;
    }
    public void recoverTree_Morris(TreeNode root) {
        TreeNode prev = null;
        TreeNode node1 = null;
        TreeNode node2 = null;
        while (root != null) {
            if (root.left == null) {
                if (prev != null && prev.val > root.val) {
                    if (node1 == null) {
                        node1 = prev;
                    }
                    node2 = root;
                }
                prev = root;
                root = root.right;
            } else {
                TreeNode temp = root.left;
                while (temp.right != null && temp.right != root) {
                    temp = temp.right;
                }
                if (temp.right == null) {
                    temp.right = root;
                    root = root.left;
                } else {
                    if (prev != null && prev.val > root.val) {
                        if (node1 == null) {
                            node1 = prev;
                        }
                        node2 = root;
                    }
                    temp.right = null;
                    prev = root;
                    root = root.right;
                }
            }
        }
        int t = node1.val;
        node1.val = node2.val;
        node2.val = t;
    }
}
