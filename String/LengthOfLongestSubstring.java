package String;

import java.util.HashMap;
import java.util.Map;

/**
 * @leetcode: 3. Longest Substring Without Repeating Characters
 */
public class LengthOfLongestSubstring {
    public static void main(String[] args) {}

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> pos = new HashMap<>();
        int len = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (!pos.containsKey(curr)) {
                pos.put(curr, i);
                len = Math.max(len, i-start+1);
            } else {
                // Delete characters from start to pos.get(curr)
                int end = pos.get(curr);
                for (int j = start; j <= end; j++) {
                    pos.remove(s.charAt(j));
                }
                start = end+1;
                pos.put(curr, i);
            }
        }
        return len;
    }
}