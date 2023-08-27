package BinaryTree;

/**
 * @leetcode: 116. Populating Next Right Pointers in Each Node
 */
public class ConnectNextRightPointer {
    public static void main(String[] args) {}

    public Node connect(Node root) {
        if(root == null) return root;
        root.next = null;
        Node curr = root;
        while(curr.left != null){
            Node nextLevel = curr.left;
            while (curr != null) {
                curr.left.next = curr.right;
                curr.right.next = curr.next == null ? null : curr.next.left;
                curr = curr.next;
            }
            curr = nextLevel;
        }
        return root;
    }
}
