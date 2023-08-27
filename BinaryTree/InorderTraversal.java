package BinaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @leetcode: 94. Binary Tree Inorder Traversal
 */
public class InorderTraversal {
    public static void main(String[] args) {}

    public List<Integer> inorderTraversal(TreeNode root) {
        Deque<TreeNode> buffer = new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();
        while (root != null || !buffer.isEmpty()) {
            if (root != null) {
                buffer.addLast(root);
                root = root.left;
            } else {
                TreeNode curr = buffer.removeLast();
                res.add(curr.val);
                root = curr.right;
            }
        }
        return res;
    }

    public List<Integer> inorderTraversal_Morris(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        while (root != null) {
            if (root.left == null) {
                res.add(root.val);
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
                    temp.right = null;
                    res.add(root.val);
                    root = root.right;
                }
            }
        }
        return res;
    }
}
