package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @leetcode: Maximum Width of Binary Tree
 */
public class WidthOfBinaryTree {
    public static void main(String[] args) {}

    // The number of nodes double at each level, the range of index would be doubled as well.
    // If the index of a parent node is i, the index of its left child node 2*i 
    // the index of its right child node as 2*i+1
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> level = new LinkedList<>();
        Queue<Integer> pos = new LinkedList<>();
        level.add(root);
        pos.add(0);
        int width = 0;
        while (!level.isEmpty()) {
            // all nodes on current level
            int size = level.size();
            int min = pos.element();
            int max = 0;
            while (size-- != 0) {
                TreeNode currNode = level.remove();
                int currPos = pos.remove();
                if (size == 0) {
                    max = currPos;
                }
                if (currNode.left != null) {
                    level.add(currNode.left);
                    pos.add(currPos*2);
                }
                if (currNode.right != null) {
                    level.add(currNode.right);
                    pos.add(currPos*2+1);
                }
            }
            width = Math.max(width, max-min+1);
        }
        return width;
    }
}