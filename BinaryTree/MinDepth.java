package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @leetcode: 111. Minimum Depth of Binary Tree
 */
public class MinDepth {
    public static void main(String[] args) {}

    // Time O(N)
    // Space O(N) full tree bottom level has around n/2 nodes
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> buffer = new LinkedList<>();
        buffer.add(root);
        int depth = 0;
        while (!buffer.isEmpty()) {
            int size = buffer.size();
            depth++;
            while (size-- != 0) {
                TreeNode curr = buffer.remove();
                if (curr.left == null && curr.right == null) {
                    return depth;
                }
                if (curr.left != null) {
                    buffer.add(curr.left);
                }
                if (curr.right != null) {
                    buffer.add(curr.right);
                }
            }
        }
        return depth;
    }
}