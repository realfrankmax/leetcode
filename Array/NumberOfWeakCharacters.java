package Array;

import java.util.Arrays;

/**
 * @leetcode: 1996. The Number of Weak Characters in the Game
 */
public class NumberOfWeakCharacters {
    public static void main(String[] args) {}

    public int numberOfWeakCharacters(int[][] properties) {
        // N^2 solution by comparing every two characters.
        // NlogN solution
        // Sort by attacking, if attacking equals, then descending order on defenses.
        Arrays.sort(properties, (p1, p2) -> p1[0] == p2[0] ? p2[1] - p1[1] : p1[0] - p2[0]);

        int maxDefense = 0;
        int weakCount = 0;
        for (int i = properties.length-1; i >= 0; i--) {
            if (properties[i][1] < maxDefense) {
                weakCount++;
            }
            maxDefense = Math.max(maxDefense, properties[i][1]);
        }
        return weakCount;
    }
}