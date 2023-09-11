package Stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @leetcode: 332. Reconstruct Itinerary
 */
public class FindItinerary {
    public static void main(String[] args) {}

    // Time O(N*log(N))
    // Space O(N)
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> routes = new HashMap<>();
        for (List<String> ticket : tickets) {
            routes.computeIfAbsent(ticket.get(0), x -> new PriorityQueue<>());
            routes.get(ticket.get(0)).offer(ticket.get(1));
        }
        Deque<String> buffer = new ArrayDeque<>();
        buffer.addLast("JFK");
        List<String> result = new LinkedList<>();
        while (!buffer.isEmpty()) {
            String curr = buffer.getLast();
            while (!routes.getOrDefault(curr, new PriorityQueue<>()).isEmpty()) {
                buffer.addLast(routes.get(curr).poll());
                curr = buffer.getLast();
            }
            result.add(0, buffer.removeLast());
        }
        return result;
    }
}