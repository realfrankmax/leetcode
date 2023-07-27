package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @leetcode: 101. Symmetric Tree
 */
public class IsSymmetric {
    public static void main(String[] args) {}

    // Space O(N) : Total N/2 nodes in bottom row
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        while(!nodes.isEmpty()) {
            int size = nodes.size();
            List<Integer> vals = new ArrayList<>();
            while(size-- != 0) {
                TreeNode curr = nodes.remove();
                if (curr.left == null) {
                    vals.add(null);
                } else {
                    vals.add(curr.left.val);
                    nodes.add(curr.left);
                }
                if (curr.right == null) {
                    vals.add(null);
                } else {
                    vals.add(curr.right.val);
                    nodes.add(curr.right);
                }
            }
            if (!isPalindrome(vals)) {
                return false;
            }
        }
        return true;
    }
    private boolean isPalindrome(List<Integer> list) {
        if (list.size() %2 != 0) {
            return false;
        }
        int left = 0;
        int right = list.size()-1;
        while (left < right) {
            if (list.get(left) != list.get(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    /**
    // Time O(N)
    // Space O(N) for reversed V-shape tree
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return check(root.left, root.right);
    }
    private boolean check(TreeNode n1, TreeNode n2) {
        if (n1 == null && n2 == null) {
            return true;
        } else if (n1 == null || n2 == null) {
            return false;
        } else {
            return n1.val == n2.val && check(n1.left, n2.right) && check(n1.right, n2.left);
        }
    }
     */
}