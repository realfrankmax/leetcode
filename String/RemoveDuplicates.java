package String;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @leetcode: 1209. Remove All Adjacent Duplicates in String II
 */
public class RemoveDuplicates {
    public static void main(String[] args) {}
    // Time O(N)
    public String removeDuplicates(String s, int k) {
        StringBuilder builder = new StringBuilder();
        Deque<Integer> count = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (builder.length() == 0 || builder.charAt(builder.length()-1) != c) {
                count.addLast(1);
                builder.append(c);
            } else {
                count.addLast(count.removeLast()+1);
                if (count.getLast() == k) {
                    builder.delete(builder.length()-k+1, builder.length());
                    count.removeLast();
                } else {
                    builder.append(c);
                }
            }
        }
        return builder.toString();
    }
    // Time O(N*N/k)
    public String removeDuplicates_bruteforce(String s, int k) {
        StringBuilder builder = new StringBuilder();
        int count = 1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (builder.length() == 0 || builder.charAt(builder.length()-1) != c) {
                count = 1;
                builder.append(c);
            } else {
                count++;
                if (count == k) {
                    while (count != 1) {
                        builder.deleteCharAt(builder.length()-1);
                        count--;
                    }
                } else {
                    builder.append(c);
                }
            }
        }
        if (builder.length() == s.length()) {
            return s;
        }
        return removeDuplicates_bruteforce(builder.toString(), k);
    }
}