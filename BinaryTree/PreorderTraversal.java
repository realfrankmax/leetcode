package BinaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @leetcode: 144. Binary Tree Preorder Traversal
 */
public class PreorderTraversal {
    public static void main(String[] args) {}

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> deck = new ArrayDeque<>();
        while (root != null || !deck.isEmpty()) {
            if (root != null) {
                res.add(root.val);
                deck.addLast(root);
                root = root.left;
            } else {
                TreeNode curr = deck.removeLast();
                root = curr.right;
            }
        }
        return res;
    }

    public List<Integer> preorderTraversal_Morris(TreeNode root) {
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
                    res.add(root.val);
                    root = root.left;
                } else {
                    temp.right = null;
                    root = root.right;
                }
            }
        }
        return res;
    }
}