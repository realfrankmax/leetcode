package DynamicProgramming;

/**
 * @leetcode: 91. Decode Ways
 */
public class NumDecodings {
    public static void main(String[] args) {}

    // Time O(n^2), but O(n) with cache
    // Space O(n)
    /**
    private Map<String, Integer> cache = new HashMap<>();
    public int numDecodings(String s) {
        if (cache.containsKey(s)) {
            return cache.get(s);
        }
        if (s.length() == 0) {
            return 1;
        }
        if (s.charAt(0) == '0') {
            return 0;
        }
        int count = 0;
        for (int i = 1; i <= 2 && i <= s.length(); i++) {
            int num = Integer.parseInt(s.substring(0, i));
            if (num >= 1 && num <= 26) {
                count += numDecodings(s.substring(i));
            }
        }
        cache.put(s, count);
        return count;
    }
     */

     // Time O(n)
     // Space O(1)
     public int numDecodings(String s) {
        if (s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        int curr = 1;
        int prev = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                // Must combine with prev digit
                // curr value: means decoding ways with s.charAt(i-1) (could) combined with i-2
                // prev value: means decoding ways with s.charAt(i-1) standalone.
                // prev value is what is needed.
                // prev = prev;
                if (s.charAt(i-1) == '1' || s.charAt(i-1) == '2') {
                    curr = prev;
                } else {
                    return 0;
                }
            } else {
                if (s.charAt(i-1) == '1' || (s.charAt(i-1) == '2' && s.charAt(i) <= '6')) {
                    int t = curr;
                    curr = curr + prev;
                    prev = t;
                } else {
                    // Could NOT combine with prev digit, so adding it will not increase any decoding ways
                    // curr value is what is needed.
                    // curr = curr;
                    prev = curr;
                }
            }
        }
        return curr;
    }
}