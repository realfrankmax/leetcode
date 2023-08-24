package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @leetcode: 199. Binary Tree Right Side View
 */
public class RightSideView {
    public static void main(String[] args) {}

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> vals = new ArrayList<>();
        if (root == null) {
            return vals;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- != 0) {
                TreeNode curr = q.remove();
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
                if (size == 0) {
                    vals.add(curr.val);
                }
            }
        }
        return vals;
    }
}