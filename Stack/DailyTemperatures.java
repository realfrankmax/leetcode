package Stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @leetcode: 739. Daily Temperatures
 */
public class DailyTemperatures {
    public static void main(String[] args) {}

    public int[] dailyTemperatures(int[] temperatures) {
        int[] days = new int[temperatures.length];
        Deque<Integer> prevDates = new ArrayDeque<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!prevDates.isEmpty() && temperatures[i] > temperatures[prevDates.getLast()]) {
                days[prevDates.getLast()] = i - prevDates.removeLast();
            }
            prevDates.addLast(i);
        }
        return days;
    }
}
