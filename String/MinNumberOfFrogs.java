package String;

import java.util.Map;

/**
 * @leetcode: 1419. Minimum Number of Frogs Croaking
 */
public class MinNumberOfFrogs {
    public static void main(String[] args) {}

    public int minNumberOfFrogs(String croakOfFrogs) {
        Map<Character, Integer> map = Map.of('c', 0, 'r', 1, 'o', 2, 'a', 3, 'k', 4);
        int[] count = new int[map.size()];
        int max = 0;
        for (char c : croakOfFrogs.toCharArray()) {
            int index = map.get(c);
            if (index == 0) {
                count[0]++;
            } else {
                if (count[index-1] <= count[index]) {
                    return -1;
                }
                count[index]++;
                if (index == 4) {
                    max = Math.max(max, count[0]);
                    for (int i = 0; i < 5; i++) {
                        count[i]--;
                    }
                }
            }
        }
        return count[0] == count[4] ? max : -1;
    }
}