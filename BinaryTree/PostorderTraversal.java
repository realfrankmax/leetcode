package BinaryTree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @leetcode: 145. Binary Tree Postorder Traversal
 */
public class PostorderTraversal {
    public static void main(String[] args) {}

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> buffer = new ArrayDeque<>();
        buffer.addLast(root);
        while (!buffer.isEmpty()) {
            TreeNode curr = buffer.removeLast();
            res.add(0, curr.val);
            if (curr.left != null) {
                buffer.addLast(curr.left);
            }
            if (curr.right != null) {
                buffer.addLast(curr.right);
            }
        }
        return res;
    }

    public List<Integer> postorderTraversal_Morris(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        while (root != null) {
            if (root.right == null) {
                res.add(0, root.val);
                root = root.left;
            } else {
                TreeNode temp = root.right;
                while (temp.left != null && temp.left != root) {
                    temp = temp.left;
                }
                if (temp.left == null) {
                    res.add(0, root.val);
                    temp.left = root;
                    root = root.right;
                } else {
                    temp.left = null;
                    root = root.left;
                }
            }
        }
        return res;
    }
}