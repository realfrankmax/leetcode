package String;

/**
 * @leetcode: 424. Longest Repeating Character Replacement
 */
public class CharacterReplacement {
    public static void main(String[] args) {}

    public int characterReplacement(String s, int k) {
        int start = 0;
        int maxCount = 0;
        int res = 0;
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            count[curr-'A']++;
            // Max count for sub array from 0 to i
            // Even though start moves which makes the maxCount not for sub array [start,i]
            // It is still valid because we only record max len.
            maxCount = Math.max(maxCount, count[curr-'A']);
            // Key Note: 
            // As long as there is no new maxCount, the start pointer needs to be moved.
            // Thus res will not increase.
            if (i-start+1 > maxCount+k) {
                count[s.charAt(start)-'A']--;
                start++;
            }
            res = Math.max(res, i-start+1);
        }
        return res;
    }
}