package String;

import java.util.HashMap;
import java.util.Map;

/**
 * @leetcode: 1297. Maximum Number of Occurrences of a Substring
 */
public class MaxFreq {
    public static void main(String[] args) {}

    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        Map<String, Integer> strCount = new HashMap<>();
        Map<Character, Integer> count = new HashMap<>();
        int left = 0;
        int right = 0;
        int max = 0;
        while (left <= right && right < s.length()) {
            char c = s.charAt(right);
            count.put(c, count.getOrDefault(c, 0) + 1);
            // substring of minSize will detemine the maximum number of occurences.
            // Any longer substring count would be equal to or smaller.
            while (count.size() > maxLetters ||(right-left+1 > minSize)) {
                c = s.charAt(left);
                count.put(c, count.get(c)-1);
                if (count.get(c) == 0) {
                    count.remove(c);
                }
                left++;
            }
            if (right-left+1 == minSize){
                String sub = s.substring(left, right+1);
                strCount.put(sub, strCount.getOrDefault(sub, 0)+1);
                max = Math.max(max, strCount.get(sub));
            }
            right++;
        }
        return max;
    }
}
