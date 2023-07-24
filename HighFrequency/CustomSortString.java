package HighFrequency;

/**
 * @leetcode: Custom Sort String
 */
public class CustomSortString {
    public static void main(String[] args) {}

    // public String customSortString(String order, String s) {
    //     Map<Character, Integer> pos = new HashMap<>();
    //     for (int i = 0; i < order.length(); i++) {
    //         pos.put(order.charAt(i), i);
    //     }
    //     int[][] pairs = new int[s.length()][2];
    //     for (int i = 0; i < s.length(); i++) {
    //         pairs[i] = new int[] {pos.getOrDefault(s.charAt(i), 0), (int)s.charAt(i)};
    //     }
    //     Arrays.sort(pairs, (p1, p2) -> p1[0] - p2[0]);
    //     StringBuilder sb = new StringBuilder();
    //     for (int i = 0; i < pairs.length; i++) {
    //         sb.append((char) pairs[i][1]);
    //     }
    //     return sb.toString();
    // }
    public String customSortString(String order, String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (char c : order.toCharArray()) {
            while (count[c - 'a']-- > 0) {
                sb.append(c);
            }
        }
        for (int i = 0; i < count.length; i++) {
            while (count[i]-- > 0) {
                sb.append((char) (i + 'a'));
            }
        }
        return sb.toString();
    }
}
