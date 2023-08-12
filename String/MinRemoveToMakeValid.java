package String;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @leetcode: 1249. Minimum Remove to Make Valid Parentheses
 */
public class MinRemoveToMakeValid {
    public static void main(String[] args) {}

    public String minRemoveToMakeValid(String s) {
        // Deck is to keep position of "(" in stringbuilder
        Deque<Integer> deck = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                deck.addLast(sb.length());
                sb.append(c);
            } else if (c == ')') {
                if (!deck.isEmpty()) {
                    deck.removeLast();
                    sb.append(c);
                }
            } else { // letter only
                sb.append(c);
            }
        }
        // Delete "(" from right to left
        while (!deck.isEmpty()) {
            sb.deleteCharAt(deck.removeLast());
        }
        return sb.toString();
    }
}
