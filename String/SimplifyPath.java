package String;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @leetcode: 71. Simplify Path
 */
public class SimplifyPath {
    public static void main(String[] args) {}

    // Only apply logic when seeing "/"
    public String simplifyPath(String path) {
        Deque<String> deck = new ArrayDeque<>();
        // Append "/" so that every path could be covered in for loop
        path += "/";
        // Index of start of the path
        int pre = 0;
        for (int i = 0; i < path.length(); i++) {
            char c = path.charAt(i);
            if (c == '/') {
                if (pre != i) {
                    String curr = path.substring(pre, i);
                    if (curr.equals("..")) {
                        if (!deck.isEmpty()) {
                            deck.removeLast();
                        }
                    } else if (!curr.equals(".")) {
                        deck.addLast("/" + curr);
                    }
                }
                pre = i+1;
            }
        }
        if (deck.isEmpty()) {
            return "/";
        }
        StringBuilder sb= new StringBuilder();
        while (!deck.isEmpty()) {
            sb.append(deck.removeFirst());
        }
        return sb.toString();
    }
    
}