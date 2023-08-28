package Math;

import java.util.HashSet;
import java.util.Set;

/**
 * @leetcode: 202. Happy Number
 */
public class HappyNumber {
    public static void main(String[] args) {}

    public boolean isHappy(int n) {
        if (n <= 0) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        while(set.add(n)) {
            int next = 0;
            while(n != 0) {
                int d = n%10;
                next += d*d;
                n = n/10;
            }
            n = next;
        }
        return n == 1;
    }
}