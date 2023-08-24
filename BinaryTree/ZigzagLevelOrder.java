package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @leetcode: 103. Binary Tree Zigzag Level Order Traversal
 */
public class ZigzagLevelOrder {
    public static void main(String[] args) {}

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        boolean leftToRight = true;
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> level = new LinkedList<>();
            while (size-- != 0) {
                TreeNode curr = q.remove();
                if (leftToRight) {
                    level.add(curr.val);
                } else {
                    level.add(0, curr.val);
                }
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
            leftToRight = !leftToRight;
            res.add(level);
        }
        return res;
    }
}