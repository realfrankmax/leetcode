package LinkedList;

/**
 * @leetcode: 2296. Design a Text Editor
 */
public class TextEditor {
    public static void main(String[] args) {
        TextEditor t = new TextEditor();
        t.addText("leetcode");
        System.out.println(t.printall());
        t.deleteText(4);
        System.out.println(t.printall());
        t.addText("practice");
        System.out.println(t.printall());
        t.cursorRight(3);
        System.out.println(t.printall());
    }

    Node head;
    Node tail;
    Node cursor;

    public TextEditor() {
        this.head = new Node('0', null, null);
        this.tail = new Node('0', null, null);
        this.cursor = new Node('|', this.head, this.tail);
        this.head.next = this.cursor;
        this.tail.prev = this.cursor;   
    }
    
    public void addText(String text) {
        for (char c : text.toCharArray()) {
            Node curr = new Node(c, this.cursor.prev, this.cursor);
            this.cursor.prev.next = curr;
            this.cursor.prev = curr;
        }
    }
    
    public int deleteText(int k) {
        int count = 0;
        while (k > 0 && this.cursor.prev.prev != null) {
            k--;
            count++;
            this.cursor.prev = this.cursor.prev.prev;
            this.cursor.prev.next = this.cursor;
        }
        return count;
    }
    
    public String cursorLeft(int k) {
        while (k > 0 && this.cursor.prev.prev != null) {
            k--;
            this.cursor.val = this.cursor.prev.val;
            this.cursor.prev.val = '|';
            this.cursor = this.cursor.prev;
        }
        return print();
    }
    
    public String cursorRight(int k) {
        while (k > 0 && this.cursor.next.next != null) {
            k--;
            this.cursor.val = this.cursor.next.val;
            this.cursor.next.val = '|';
            this.cursor = this.cursor.next;
        }
        return print();
    }
    
    private String print() {
        int i = 0;
        StringBuilder builder = new StringBuilder();
        Node pointer = this.cursor;
        while (i < 10 && pointer.prev.prev != null) {
            i++;
            builder.insert(0, pointer.prev.val);
            pointer = pointer.prev;
        }
        return builder.toString();
    }
    private String printall() {
        StringBuilder sb = new StringBuilder();
        Node pointer = this.head.next;
        while (pointer.next != null) {
            sb.append(pointer.val);
            pointer = pointer.next;
        }
        return sb.toString();
    }

    static class Node {
        char val;
        Node prev;
        Node next;
        public Node(char val, Node prev, Node next) {
            this.val = val;
            this.prev = prev;
            this.next = next;
        }
    }

}