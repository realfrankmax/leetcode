package BinarySearchTree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @leetcode: 
 */
public class KthSmallest {
    public static void main(String[] args) {}

    // public int kthSmallest(TreeNode root, int k) {
    //     List<Integer> vals = new ArrayList<>();
    //     inorder(root, vals, k);
    //     return vals.get(k-1);
    // }
    // private void inorder(TreeNode node, List<Integer> vals, int k) {
    //     if (node == null || vals.size() == k) {
    //         return;
    //     }
    //     inorder(node.left, vals, k);
    //     vals.add(node.val);
    //     inorder(node.right, vals, k);
    // }
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> deck = new ArrayDeque<>();
        while (root != null || !deck.isEmpty()) {
            if (root != null) {
                deck.addLast(root);
                root = root.left;
            } else {
                TreeNode curr = deck.removeLast();
                if (--k == 0) {
                    return curr.val;
                }
                root = curr.right;
            }
        }
        return -1;
    }
}