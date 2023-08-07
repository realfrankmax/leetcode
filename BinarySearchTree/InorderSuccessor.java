package BinarySearchTree;

/**
 * @leetcode: 285. Inorder Successor in BST
 */
public class InorderSuccessor {
    public static void main(String[] args) {}

    // Logarithmic solution
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode successor = null;
        while (root != null) {
            if (root.val <= p.val) {
                root = root.right;
            } else {
                successor = root;
                root = root.left;
            }
        }
        return successor;
    }
    // Linear solution with inorder traversal
    // public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
    //     Deque<TreeNode> deck = new ArrayDeque<>();
    //     TreeNode prev = null;
    //     while (root != null || !deck.isEmpty()) {
    //         if (root != null) {
    //             deck.addLast(root);
    //             root = root.left;
    //         } else {
    //             TreeNode curr = deck.removeLast();
    //             if (prev != null && prev.val == p.val) {
    //                 return curr;
    //             }
    //             prev = curr;
    //             root = curr.right;
    //         }
    //     }
    //     return null;
    // }
}