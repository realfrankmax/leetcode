package Stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @leetcode: 735. Asteroid Collision
 */
public class AsteroidCollision {
    public static void main(String[] args) {}

    // It should be like finding matched parentheses.
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> buffer = new ArrayDeque<>();
        for (int a : asteroids) {
            if (a > 0) {
                buffer.addLast(a);
            } else {
                if (buffer.isEmpty() || buffer.getLast() < 0) {
                    buffer.addLast(a);
                } else {
                    while (!buffer.isEmpty() && buffer.getLast() > 0 && buffer.getLast() + a < 0) {
                        buffer.removeLast();
                    }
                    if (buffer.isEmpty() || buffer.getLast() < 0) {
                        buffer.addLast(a);
                    } else if (buffer.getLast() + a == 0) {
                        buffer.removeLast();
                    } 
                }
            }
        }
        return buffer.stream().mapToInt(Integer::intValue).toArray();
    }
}