package BinaryTree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @leetcode: Serialize and Deserialize Binary Tree
 */
public class SerializeTree {
    public static void main(String[] args) {}

    private String delimiter = ",";
    private String emptyNode = "#";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        treeToString(root, sb);
        return sb.toString();
    }

    private void treeToString(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(emptyNode).append(delimiter);
            return ;
        }
        sb.append(root.val).append(delimiter);
        treeToString(root.left, sb);
        treeToString(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(delimiter);
        Queue<String> q = new LinkedList<>(Arrays.asList(nodes));
        return decode(q);
    }
    private TreeNode decode(Queue<String> nodes) {
        if (nodes.isEmpty()) {
            return null;
        }
        String curr = nodes.remove();
        if (curr.equals(emptyNode)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(curr));
        root.left = decode(nodes);
        root.right = decode(nodes);
        return root;
    }
}