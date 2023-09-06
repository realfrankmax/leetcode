package Graph;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @leetcode: 64. Minimum Path Sum (Move 4 directions)
 */
public class Dijkstra {
    public static void main(String[] args) {
        int[][] in = {{1, 100, 100, 5, 1}, {1, 50, 1, 1, 1}, {1, 1, 1, 100, 1}, {1, 100, 100, 100, 1}};
        Dijkstra d = new Dijkstra();
        System.out.println(d.dijkstra(in)); // output 10
    }

    static int[] DIRS = {0, 1, 0, -1, 0};
    public int dijkstra(int[][] grid) {
        PriorityQueue<Cell> pq = new PriorityQueue<>((c1, c2) -> c1.distance - c2.distance);
        Map<String, Integer> map = new HashMap<>();
        map.put("0,0", 1);
        pq.offer(new Cell(1, 0, 0));
        while (!pq.isEmpty()) {
            Cell curr = pq.poll();
            // System.out.println(curr.x + ", " + curr.y + ": " + curr.distance);
            for (int i = 0; i < 4; i++) {
                int newRow = curr.x + DIRS[i];
                int newCol = curr.y + DIRS[i+1];
                if (newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length) {
                    int newDistance = curr.distance + grid[newRow][newCol];
                    if (newDistance < map.getOrDefault(newRow+","+newCol, Integer.MAX_VALUE)) {
                        map.put(newRow+","+newCol, newDistance);
                        pq.offer(new Cell(newDistance, newRow, newCol));
                    }
                }
            }
        }
        int m = grid.length-1;
        int n = grid[0].length-1;

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                System.out.print(map.getOrDefault(i+","+j, -1) + ", ");
            }
            System.out.println();
        }
        return map.get(m+","+n);
    }

    static class Cell {
        int distance;
        int x;
        int y;
        public Cell(int distance, int x, int y) {
            this.distance = distance;
            this.x = x;
            this.y = y;
        }
    }
}