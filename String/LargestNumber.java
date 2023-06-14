package String;

import java.util.PriorityQueue;

/**
 * @leetcode: Largest Number
 */
public class LargestNumber {
    public static void main(String[] args) {}

    public String largestNumber(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((i1, i2) -> {
            String s1 = i2+""+i1;
            String s2 = i1+""+i2;
            return s1.compareTo(s2);
        });
        StringBuilder builder = new StringBuilder();
        for (int n : nums) {
            pq.offer(n);
        }
        while (!pq.isEmpty()) {
            builder.append(pq.poll());
        }
        String res = builder.toString();
        return res.charAt(0) == '0' ? "0" : res;
    }
}