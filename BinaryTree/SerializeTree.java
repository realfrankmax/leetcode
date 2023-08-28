package BinaryTree;

/**
 * @leetcode: 297. Serialize and Deserialize Binary Tree
 */
public class SerializeTree {
    public static void main(String[] args) {}

    static class Codec {
        static char DELIMITER = ',';
        static char EMPTY = '#';
        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            if (root == null) {
                sb.append(EMPTY).append(DELIMITER);
                return sb.toString();
            }
            sb.append(root.val).append(DELIMITER);
            sb.append(serialize(root.left));
            sb.append(serialize(root.right));
            return sb.toString();
        }
    
        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            int[] p = new int[1];
            return helper(data, p);
        }
        private TreeNode helper(String data, int[] p) {
            if (p[0] >= data.length()) {
                return null;
            }
            if (data.charAt(p[0]) == EMPTY) {
                p[0] += 2;
                return null;
            }
            for (int i = p[0]; i < data.length(); i++) {
                if (data.charAt(i) == DELIMITER) {
                    int rootVal = Integer.parseInt(data.substring(p[0], i));
                    TreeNode root = new TreeNode(rootVal);
                    p[0] = i+1;
                    root.left = helper(data, p);
                    root.right = helper(data, p);
                    return root;
                }
            }
            return null;
        }
    }
}