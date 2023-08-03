package Heap;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @leetcode: 692. Top K Frequent Words
 */
public class TopKFrequent {
    public static void main(String[] args) {}

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> count = new HashMap<>();
        for (String word : words) {
            count.put(word, count.getOrDefault(word, 0)+1);
        }
        PriorityQueue<Map.Entry<String, Integer>> topK = new PriorityQueue<>((e1, e2) -> {
            if (e1.getValue() == e2.getValue()) {
                return e2.getKey().compareTo(e1.getKey());
            }
            return e1.getValue() - e2.getValue();
        });
        for (Map.Entry<String, Integer> e : count.entrySet()) {
            topK.offer(e);
            if (topK.size() == k+1) {
                topK.poll();
            }
        }
        List<String> res = new LinkedList<>();
        while (!topK.isEmpty()) {
            res.add(0, topK.poll().getKey());
        }
        return res;
    }
}
