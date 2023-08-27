package BinaryTree;

/**
 * @leetcode: 117. Populating Next Right Pointers in Each Node II
 */
public class ConnectNextRightPointerII {
    public static void main(String[] args) {}

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Node curr = root;
        while (curr != null) {
            Node nextLevel = null;
            Node prev = null;
            while (curr != null) {
                if (curr.left != null) {
                    if (nextLevel == null) {
                        nextLevel = curr.left;
                    }
                    if (prev != null) {
                        prev.next = curr.left;
                    }
                    prev = curr.left;
                }
                if (curr.right != null) {
                    if (nextLevel == null) {
                        nextLevel = curr.right;
                    }
                    if (prev != null) {
                        prev.next = curr.right;
                    }
                    prev = curr.right;
                }
                curr = curr.next;
            }
            curr = nextLevel;
        }
        return root;
    }
}
