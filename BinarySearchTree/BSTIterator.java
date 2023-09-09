package BinarySearchTree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @leetcode: 173. Binary Search Tree Iterator
 */
public class BSTIterator {
    public static void main(String[] args) {}

    Deque<TreeNode> buffer;
    // Split code from iterative inorder traversal
    public BSTIterator(TreeNode root) {
        this.buffer = new ArrayDeque<>();
        while (root != null) {
            this.buffer.addLast(root);
            root = root.left;
        }
    }
    
    public int next() {
        TreeNode n = this.buffer.removeLast();
        int res = n.val;
        n = n.right;
        while (n != null) {
            this.buffer.addLast(n);
            n = n.left;
        }
        return res;
    }
    
    public boolean hasNext() {
        return !this.buffer.isEmpty();
    }
}
